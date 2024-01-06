package exercicio2;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeSecondToLast() {
        if (head == null || head.next == null) {
            System.out.println("Não há penúltimo nó para remover.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current.next.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        System.out.println("Lista original:");
        list.display();

        list.removeSecondToLast();
        System.out.println("Lista após remover o penúltimo nó:");
        list.display();
    }
}
