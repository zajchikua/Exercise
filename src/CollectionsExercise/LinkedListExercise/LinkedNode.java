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
        node.dataValue = data ;
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
    }
}

