package CollectionsExercise.LinkedListExercise;

public class Sum2LinkedLists {
    /**
     * Definition for singly-linked list.*/

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode myHead = new ListNode(0);
            ListNode tail = myHead;
            int current = 0; //store the value for addition

            while(l1 != null || l2 != null || current !=0)
            {
                int d1 = (l1 != null)? l1.val : 0;
                int d2 = (l2 != null)? l2.val : 0;

                int sum = current + (d1 + d2);
                int realDigit = sum % 10;
                current = sum / 10; //this will take it to the next iteration

                ListNode newNode = new ListNode(realDigit);
                tail.next = newNode;
                tail = tail.next;
                System.out.println(newNode.val);

                l1 = (l1 != null)? l1.next : null;
                l2 = (l2 != null)? l2.next : null;

            }

            ListNode result = myHead.next;
            myHead.next = null;
            return result;
    }

    public static void main ( String[] args ) {
        ListNode l3 = new ListNode(0, null);
        ListNode l2 = new ListNode(9, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode a1 = new ListNode(10, null);
        ListNode a3 = new ListNode(4, a1);
        ListNode a2 = new ListNode(5, a3);
        ListNode a4 = new ListNode(3, a2);
        System.out.println(addTwoNumbers(l1, a1));
}


}



