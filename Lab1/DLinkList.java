//Student name: Mohamed Boudabbous            Student number: 300376202
public class DLinkList {
    DNode head;
    DNode tail;
    long size;

    DLinkList(long sz) {
        // Note the size of the linked list will not count the dummy head or tail
        head = new DNode("dummy_head", null, null);
        tail = new DNode("dummy_tail", null, null);
        head.setNext(tail);
        tail.setPrev(head);

        if (sz != 0) {
            DNode current = head;
            for (int i = 0; i < sz; i++) {
                DNode next_node = new DNode(Integer.toString(i), current, this.tail);
                current.setNext(next_node);
                next_node.setPrev(current);
                current = next_node;
            }
            this.tail.setPrev(current);
        }
        this.size = sz;
    }

    public void print() {
        if (size ==0){
            System.out.println("Empty linked list");
        }else {
            DNode current = head.getNext();
            while (current != tail) {
                System.out.println(current.getElement() + " ");
                current = current.getNext();
            }
            System.out.println();
        }

    }

    public void deleteFirst() {
        if (size ==0){
            System.out.println("Empty  list");
        }

        else{
            DNode firstNode = head.getNext();
            DNode newFirstNode = firstNode.getNext();
            head.setNext(newFirstNode);
            newFirstNode.setPrev(head);
            size= size-1;
        }
    }

    public void deleteLast() {
        if (size ==0){
            System.out.println("Empty  list");
        }
        else{
            DNode lastNode = tail.getPrev();
            DNode newLastNode = lastNode.getPrev();
            tail.setPrev(newLastNode);
            newLastNode.setNext(tail);
            size= size-1;
        }
    }


    public static void main(String[] args) {
        long list_size = 100000;

        // test delete first speed
        DLinkList llist = new DLinkList(list_size);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < list_size; i++) {
            llist.deleteFirst();
        }
        long t2 = System.currentTimeMillis();
        double total_time_in_secs = (t2-t1)/(1000.0);
        System.out.println("The total running time in seconds for the delete first method for a singly linked list" +
                " is " + total_time_in_secs + " seconds");

        // test delete last speed
        DLinkList llist2 = new DLinkList(list_size);
        t1 = System.currentTimeMillis();
        for (int i = 0; i < list_size; i++) {
            llist2.deleteLast();
        }
        t2 = System.currentTimeMillis();
        total_time_in_secs = (t2-t1)/(1000.0);
        System.out.println("The total running time in seconds for the delete last method for a singly linked list" +
                " is " + total_time_in_secs + " seconds");
    }
}
