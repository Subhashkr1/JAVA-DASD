public class DoubleLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // public void addFirst(int data){
    //     Node node = new Node(data);
    //     if(size == 0){
    //         head = node;
    //         tail = node;
    //     } else {
    //         node.next = head;
    //         head.prev = node;
    //         head = node;
    //     }
    //     size++;
    // }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        System.out.print("null <- ");
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("-> null");
    }

    public void addLast(int data){
        Node node = new Node(data);
        if(size == 0){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public int removeFirst1(){
        if(head == null){
            System.out.println("List is Empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = null;
            tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
        
    }

    public void reversedll(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void addAt(int data, int idx){
        if(idx < 0 || idx > size){
            System.out.println("Invalid Index");
        } else if(idx == 0){
            addFirst(data);
        } else if(idx == size){
            addLast(data);
        } else {
            Node node = new Node(data);
            Node temp = head;
            for(int i = 0; i < idx - 1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
            size++;
        }
    }

    public void removeFirst(){
        if(size == 0){
            System.out.println("List is Empty");
        } else if(size == 1){
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast(){
        if(size == 0){
            System.out.println("List is Empty");
        } else if(size == 1){
            head = null;
            tail = null;
            size = 0;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void removeAt(int idx){
        if(idx < 0 || idx >= size){
            System.out.println("Invalid Index");
        } else if(idx == 0){
            removeFirst();
        } else if(idx == size - 1){
            removeLast();
        } else {
            Node temp = head;
            for(int i = 0; i < idx - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    public int getFirst(){
        if(size == 0){
            System.out.println("List is Empty");
            return -1;
        } else {
            return head.data;
        }
    }

    public int getLast(){
        if(size == 0){
            System.out.println("List is Empty");
            return -1;
        } else {
            return tail.data;
        }
    }

    public int getAt(int idx){
        if(idx < 0 || idx >= size){
            System.out.println("Invalid Index");
            return -1;
        } else {
            Node temp = head;
            for(int i = 0; i < idx; i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void removeFirstOccurence(int data){
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(temp.data == data){
                removeAt(i);
                return;
            }
            temp = temp.next;
        }
    }

    public void removeLastOccurence(int data){
        Node temp = tail;
        for(int i = size - 1; i >= 0; i--){
            if(temp.data == data){
                removeAt(i);
                return;
            }
            temp = temp.prev;
        }
    }

    public void reversePI(){
        int li = 0;
        int ri = size - 1;
        while(li < ri){
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            li++;
            ri--;
        }
    }

    public Node getNodeAt(int idx){
        Node temp = head;
        for(int i = 0; i < idx; i++){
            temp = temp.next;
        }
        return temp;
    }



    public void reverseDI(){
        int li = 0;
        int ri = size - 1;
        while(li < ri){
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            li++;
            ri--;
        }
    }
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(10);
        dll.addFirst(20);
        dll.addFirst(30);
        dll.addFirst(40);
        dll.addFirst(50);
        dll.addLast(60);
        dll.addLast(70);
        dll.addLast(80);
        dll.addLast(90);
        dll.addLast(100);
        dll.addAt(110, 5);
        dll.addAt(120, 10);
        dll.addAt(130, 15);
        dll.display();
        dll.displayReverse();
        dll.removeFirst();
        dll.removeLast();
        dll.removeAt(5);
        dll.display();
        dll.displayReverse();
        System.out.println(dll.getFirst());
        System.out.println(dll.getLast());
        System.out.println(dll.getAt(5));
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
        dll.removeFirstOccurence(60);
        dll.removeLastOccurence(90);
        dll.display();
        dll.displayReverse();
        dll.reversePI();
        dll.display();
        dll.displayReverse();
        dll.reverseDI();
        dll.display();
        dll.displayReverse();

        dll.print();
        dll.removeFirst1();
        dll.print();
        dll.reversedll();
        dll.print();

        
    }
}
