public class LinkedList<T extends Comparable<T>> {
    private Node<T>  head;


    public LinkedList() {
        this.head = null;
    }

    public void insert (T value){
        Node<T> newNode = new Node<>(value);
        if (head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertionSort() {
        if (head == null || head.next == null){
            return;
        }
        Node<T> sortedHead = null;
        Node<T> current = head;
        while (current != null){
            Node<T> next = current.next;
            sortedHead = insertSorted(sortedHead, current);
            current = next;
        }
        head = sortedHead;
    }



    private Node<T> insertSorted(Node<T> sortedHead, Node<T> newNode){


        if (sortedHead == null || newNode.value.compareTo(sortedHead.value) < 0){
            newNode.next = sortedHead;
            return newNode;
        } else{
            Node<T> current = sortedHead;
            while (current.next != null && newNode.value.compareTo(current.next.value) > 0){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            return  sortedHead;
        }
    }

    public void printList() {
        Node<T> current = head;
        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}