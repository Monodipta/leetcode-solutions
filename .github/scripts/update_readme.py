#!/usr/bin/env python3
"""Rebuild the progress counts and solved-problems table in README.md
by scanning the numbered problem folders (e.g. 0001-two-sum) that LeetHub AI pushes."""
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
README = ROOT / "README.md"

LANGS = {
    ".java": "Java", ".py": "Python", ".cpp": "C++", ".c": "C", ".cs": "C#",
    ".js": "JavaScript", ".ts": "TypeScript", ".go": "Go", ".rs": "Rust",
    ".kt": "Kotlin", ".swift": "Swift", ".rb": "Ruby", ".php": "PHP",
    ".scala": "Scala", ".sql": "SQL", ".sh": "Bash",
}


def parse_problem(folder: Path):
    number = int(folder.name.split("-", 1)[0])
    slug_title = folder.name.split("-", 1)[1].replace("-", " ").title()
    title, difficulty = slug_title, "Unknown"

    readme = folder / "README.md"
    if readme.exists():
        text = readme.read_text(encoding="utf-8", errors="ignore")
        m = re.search(r"<h2[^>]*>\s*<a[^>]*>\s*\d+\.\s*(.*?)\s*</a>", text, re.S)
        if m:
            title = re.sub(r"<[^>]+>", "", m.group(1)).strip()
        else:
            m = re.search(r"^#+\s*\d+\.\s*(.+)$", text, re.M)
            if m:
                title = m.group(1).strip()
        m = re.search(r"<h3[^>]*>\s*(Easy|Medium|Hard)\s*</h3>", text, re.I)
        if not m:
            m = re.search(r"Difficulty\W{0,5}(Easy|Medium|Hard)", text, re.I)
        if not m:
            m = re.search(r"\b(Easy|Medium|Hard)\b", text[:800], re.I)
        if m:
            difficulty = m.group(1).capitalize()

    langs = sorted({LANGS[f.suffix.lower()] for f in folder.iterdir()
                    if f.is_file() and f.suffix.lower() in LANGS})
    return {
        "number": number, "title": title, "difficulty": difficulty,
        "langs": ", ".join(langs) or "-", "folder": folder.name,
    }


def replace_block(text: str, name: str, content: str) -> str:
    pattern = re.compile(
        rf"(<!-- {name}:START -->)(.*?)(<!-- {name}:END -->)", re.S)
    if not pattern.search(text):
        sys.exit(f"Missing <!-- {name}:START --> / <!-- {name}:END --> markers in README.md")
    return pattern.sub(lambda m: f"{m.group(1)}\n{content}\n{m.group(3)}", text)


def main():
    folders = [p for p in ROOT.iterdir() if p.is_dir() and re.match(r"^\d+-", p.name)]
    problems = sorted((parse_problem(f) for f in folders), key=lambda p: p["number"])

    counts = {d: sum(1 for p in problems if p["difficulty"] == d)
              for d in ("Easy", "Medium", "Hard")}
    total = len(problems)

    progress = "\n".join([
        "| Difficulty | Solved |",
        "|------------|:------:|",
        f"| Easy       | {counts['Easy']} |",
        f"| Medium     | {counts['Medium']} |",
        f"| Hard       | {counts['Hard']} |",
        f"| **Total**  | **{total}** |",
    ])

    rows = ["| #    | Problem | Difficulty | Language |",
            "|-----:|---------|:----------:|----------|"]
    for p in problems:
        rows.append(f"| {p['number']} | [{p['title']}](./{p['folder']}) | "
                    f"{p['difficulty']} | {p['langs']} |")

    text = README.read_text(encoding="utf-8")
    text = replace_block(text, "PROGRESS", progress)
    text = replace_block(text, "PROBLEMS", "\n".join(rows))
    text = re.sub(r"Problems%20Solved-\d+-brightgreen",
                  f"Problems%20Solved-{total}-brightgreen", text)
    README.write_text(text, encoding="utf-8")
    print(f"README updated: {total} problems "
          f"({counts['Easy']} easy, {counts['Medium']} medium, {counts['Hard']} hard)")


if __name__ == "__main__":
    main()
