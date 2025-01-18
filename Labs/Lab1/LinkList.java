class LinkList {
    long size;
    Node head;

    LinkList(long sz) {
        head = new Node("dummy_head", null); // dummy node, always empty content, never to be deleted
        if (sz != 0) {
            head.setNext(new Node("0", null));
            Node current = head.getNext();
            for (int i = 1; i < sz; ++i) {
                Node node2Add = new Node(Integer.toString(i), null);
                current.setNext(node2Add);
                current = node2Add;
            }
        }
        this.size = sz;
    }

    public void print() {
        if (this.size == 0) {
            System.out.println("Empty Linked List");
        }

        Node current = head.getNext();
        while (current != null) {
            System.out.print((String) current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void deleteFirst() {
        if (head.getNext() != null) {
            head.setNext(head.getNext().getNext());
            this.size -= 1;
        }
        else {
            System.out.println("Cannot delete from an empty list.");
        }
    }

    public void deleteLast() {
        if (this.size == 0) {
            System.out.println("Cannot delete last from empty linked list.");
            return;
        }
        Node prev = head.getNext();
        Node current = prev.getNext();
        while (current != null) {
            prev = current;
            current = current.getNext();
        }
        prev.setNext(null);
    }

    public static void main(String[] args) {
        long list_size = 100000;

        // test delete first speed
        LinkList llist = new LinkList(list_size);
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < list_size; i++) {
            llist.deleteFirst();
        }
        long t2 = System.currentTimeMillis();
        double total_time_in_secs = (t2-t1)/(1000.0);
        System.out.println("The total running time in seconds for the delete first method for a singly linked list" +
                " is " + total_time_in_secs + " seconds");

        // test delete last speed
        LinkList llist2 = new LinkList(list_size);
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