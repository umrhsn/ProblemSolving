package LeetCode.Easy;

// 21. Merge Two Sorted Lists

/**
 <a href="https://leetcode.com/problems/merge-two-sorted-lists/">...</a>
 */

/**
 # Explanation of the Merge Two Sorted Lists Algorithm

 This code implements the solution to the "Merge Two Sorted Lists" problem, which is a common algorithm for combining two sorted linked lists into a single sorted linked list.

 ## The Code Explained

 ### `mergeTwoLists` Method

 ```java
 public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
 ListNode dummy = new ListNode(0);
 ListNode current = dummy;
 while (list1 != null && list2 != null) {
 if (list1.val < list2.val) {
 current.next = list1;
 list1 = list1.next;
 } else {
 current.next = list2;
 list2 = list2.next;
 }
 current = current.next;
 }
 // Attach any remaining nodes
 current.next = (list1 != null) ? list1 : list2;
 return dummy.next;
 }
 ```


 The method works as follows:

 1. **Initialization**:
 - Creates a dummy node with value 0 (this is a common technique in linked list problems)
 - Sets a `current` pointer to the dummy node to track our position as we build the merged list

 2. **Main Merging Logic**:
 - Uses a while loop that continues as long as both lists have remaining nodes
 - At each step, compares the values of the current nodes from both lists
 - Takes the smaller value node and appends it to the merged list
 - Advances the pointer of the list that contributed the node
 - Moves the `current` pointer forward to maintain its position at the end of the merged list

 3. **Handling Remaining Nodes**:
 - After the loop, at least one of the lists is empty
 - Attaches any remaining nodes from either list to the end of the merged list
 - Uses a ternary operator to choose the non-empty list (or null if both are empty)

 4. **Result**:
 - Returns `dummy.next`, which is the head of the merged list (skipping the dummy node)

 ### `printList` Method

 ```java
 public static void printList(ListNode head) {
 while (head != null) {
 System.out.print(head.val);
 if (head.next != null) {
 System.out.print(" -> ");
 }
 head = head.next;
 }
 System.out.println();
 }
 ```


 This is a utility method to display a linked list:
 - Traverses the list from head to tail
 - Prints each node's value
 - Adds arrow separators between nodes for visual clarity
 - Adds a newline at the end

 ## Example Execution

 To illustrate how this works, consider merging two sorted lists:
 - List1: 1 -> 3 -> 5
 - List2: 2 -> 4 -> 6

 Here's what happens step by step:

 1. Create `dummy` node (value 0) and set `current = dummy`
 2. Compare 1 < 2, so add node with value 1 to the merged list and advance List1
 3. Compare 3 > 2, so add node with value 2 to the merged list and advance List2
 4. Compare 3 < 4, so add node with value 3 to the merged list and advance List1
 5. Compare 5 > 4, so add node with value 4 to the merged list and advance List2
 6. Compare 5 < 6, so add node with value 5 to the merged list and advance List1
 7. List1 is now empty, so attach the remainder of List2 (just node with value 6)
 8. Final merged list: 1 -> 2 -> 3 -> 4 -> 5 -> 6

 ## Time and Space Complexity

 - **Time Complexity**: O(n + m) where n and m are the lengths of the two input lists
 - Each node is processed exactly once
 - **Space Complexity**: O(1) - constant extra space
 - Only uses a few pointers regardless of input size
 - The merged list reuses the original nodes, not creating new ones

 This is a very efficient algorithm for merging sorted linked lists.
 */

public class _21 {
    // Test method for merging two sorted lists
    public static void main(String[] args) {
        // Create first list: 1->2->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create second list: 1->3->4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Test the method
        ListNode merged = mergeTwoLists(list1, list2);

        // Print result
        printList(merged); // Should print: 1->1->2->3->4->4
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach any remaining nodes
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}