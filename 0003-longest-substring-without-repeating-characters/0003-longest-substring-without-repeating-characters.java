class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        int maxLength = 0;
        int left = 0; // The left boundary of our sliding window
        
        // Move the right boundary of the window one character at a time
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map, it might be a duplicate
            if (charMap.containsKey(currentChar)) {
                // Move 'left' to the right of the duplicate's last seen position.
                // Math.max ensures 'left' never moves backward!
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            
            // Update or add the character's newest index in the map
            charMap.put(currentChar, right);
            
            // Calculate current window length (right - left + 1) and update maximum
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna