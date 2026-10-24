/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Count the total number of nodes in the list
        int totalLength = 0;
        ListNode curr = head;
        while (curr != null) {
            totalLength++;
            curr = curr.next;
        }

        // A dummy node helps manage changing heads smoothly
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Merge sub-lists iteratively by doubling the step size each time
        // 1 -> 2 -> 4 -> 8 -> 16... up to totalLength
        for (int step = 1; step < totalLength; step <<= 1) {
            ListNode prev = dummy;
            curr = dummy.next;

            while (curr != null) {
                // Extract the first sub-list of size 'step'
                ListNode left = curr;
                ListNode right = split(left, step);
                
                // Extract the next sub-list of size 'step' and save the remaining tail
                curr = split(right, step);

                // Merge the two sorted sub-lists and link them back to the chain
                prev.next = merge(left, right);

                // Move 'prev' to the end of the newly merged section
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    /**
     * Splits off a sub-list of a given size from the head.
     * Returns a pointer to the rest of the list, cutting the end of the split section.
     */
    private ListNode split(ListNode head, int size) {
        if (head == null) return null;

        ListNode curr = head;
        // Advance 'size - 1' steps to reach the end of the sub-list segment
        for (int i = 1; i < size && curr.next != null; i++) {
            curr = curr.next;
        }

        ListNode nextPart = curr.next;
        curr.next = null; // Cut the connection to isolate the sub-list
        return nextPart;
    }

    /**
     * Standard iterative in-place merge of two sorted lists.
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna