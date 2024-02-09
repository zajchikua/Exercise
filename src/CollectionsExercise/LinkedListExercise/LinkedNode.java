package CollectionsExercise.LinkedListExercise;

public class LinkedNode < D > {
    private D dataValue;
    private LinkedNode next;

    public D getDataValue ( ) {
        return this.dataValue;
    }

    public void setDataValue ( D dataValue ) {
        this.dataValue = dataValue;
    }

    public LinkedNode getNext ( ) {
        return this.next;
    }

    public void setNext ( LinkedNode next ) {
        this.next = next;
    }

    public static LinkedNode<Integer> buildNode (int data){
        LinkedNode node = new LinkedNode();
        node.setDataValue(data );
        node.setNext(null);
        return node;

    }

    public static void printLinkedList(LinkedNode head){
        while(head != null)
        {
            System.out.print(head.getDataValue() + ", ");
            head = head.getNext();
        }
        System.out.println("End of the list");
    }

    //delete the middle node of a linked list!
    public static LinkedNode deleteMiddle(LinkedNode head)
    {
        if(head == null || head.next == null){
            return head;
        }

        LinkedNode fast = head;
        LinkedNode slow = head;
        while(fast != null && fast.getNext()!= null){
            fast = fast.getNext().getNext();
            head = head.getNext();
            slow = head;
        }
        //when the fast reaches the finish, slow will be in the middle
        //so delete slow
        slow.setNext(head.getNext());
        return head;
    }
    public static void main ( String[] args ) {
        LinkedNode<Integer> head = buildNode(11);
        LinkedNode<Integer> node1 = buildNode(1);
        LinkedNode<Integer> node2 = buildNode(15);
        LinkedNode<Integer> node3 = buildNode(7);
        LinkedNode<Integer> node4 = buildNode(8);
        printLinkedList(head);

        //create the linkedlist
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        System.out.println("Print a new list! -->/n" +
                "!@@!@!@!@!@!@");
        printLinkedList(head);
        System.out.println("Now print out after Delete Middle method is called");
        System.out.println(deleteMiddle(head));
        printLinkedList(head);

    }
}

