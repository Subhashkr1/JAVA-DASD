import java.util.*;

public class LinkedList1{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        public LinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void addLast(int val){
            Node temp = new Node(val);
            if(this.size == 0){
                this.head = temp;
                this.tail = temp;
            }else{
                this.tail.next = temp;
                this.tail = temp;
            }
            this.size++;
        }

        public int size(){
            return this.size;
        }

        public void display(){
            Node temp = this.head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeFirst(){
            if(this.size == 0){
                System.out.println("List is empty");
            }else if(this.size == 1){
                this.head = null;
                this.tail = null;
                this.size = 0;
            }else{
                this.head = this.head.next;
                this.size--;
            }
        }

        public int getFirst(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return this.head.data;
            }
        }

        public int getLast(){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }else{
                return this.tail.data;
            }
        }

        public int getAt(int idx){
            if(this.size == 0){
                System.out.println("List is empty");
                return -1;
            }else if(idx < 0 || idx >= this.size){
                System.out.println("Invalid arguments");
                return -1;
            }else{
                Node temp = this.head;
                for(int i = 0; i < idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        private Node getNodeAt(int idx){
            Node temp = this.head;
            for(int i = 0; i < idx; i++){
                temp = temp.next;
            }
            return temp;
        }

        public void addFirst(int val){
            Node temp = new Node(val);
            if(this.size == 0){
                this.head = temp;
                this.tail = temp;
            }else{
                temp.next = this.head;
                this.head = temp;
            }
            this.size++;
        }

        public void addAt(int idx, int val){
            if(idx < 0 || idx > this.size){
                System.out.println("Invalid arguments");
            }else if(idx == 0){
                addFirst(val);
            }else if(idx == this.size){
                addLast(val);
            }else{
                Node node = new Node(val);
                Node temp = getNodeAt(idx - 1);
                node.next = temp.next;
                temp.next = node;
                this.size++;
            }
        }

        public void removeLast(){
            if(this.size == 0){
                System.out.println("List is empty");
            }else if(this.size == 1){
                this.head = null;
                this.tail = null;
                this.size = 0;
            }else{
                Node temp = getNodeAt(this.size - 2);
                temp.next = null;
                this.tail = temp;
                this.size--;
            }
        }

        public void removeAt(int idx){
            if(idx < 0 || idx >= this.size){
                System.out.println("Invalid arguments");
            }else if(idx == 0){
                removeFirst();
            }else if(idx == this.size - 1){
                removeLast();
            }else{
                Node temp = getNodeAt(idx - 1);
                temp.next = temp.next.next;
                this.size--;
            }
        }

        public void reverseDI(){
            int li = 0;
            int ri = this.size - 1;
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

        public void reversePI(){
            if(this.size <= 1){
                return;
            }
            Node prev = null;
            Node curr = this.head;
            while(curr != null){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }

        public int kthFromLast(int k){
            Node slow = this.head;
            Node fast = this.head;
            for(int i = 0; i < k; i++){
                fast = fast.next;
            }
            while(fast != this.tail){
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        public int mid(){
            Node slow = this.head;
            Node fast = this.head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2){
            LinkedList ml = new LinkedList();
            Node one = l1.head;
            Node two = l2.head;
            while(one != null && two != null){
                if(one.data < two.data){
                    ml.addLast(one.data);
                    one = one.next;
                }else{
                    ml.addLast(two.data);
                    two = two.next;
                }
            }
            while(one != null){
                ml.addLast(one.data);
                one = one.next;
            }
            while(two != null){
                ml.addLast(two.data);
                two = two.next;
            }
            return ml;
        }

        public void removeDuplicates(){
            LinkedList res = new LinkedList();
            while(this.size > 0){
                int val = this.getFirst();
                this.removeFirst();
                if(res.size == 0 || val != res.tail.data){
                    res.addLast(val);
                }
            }
            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public void oddEven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while(this.size > 0){
                int val = this.getFirst();
                this.removeFirst();
                if(val % 2 == 0){
                    even.addLast(val);
                }else{
                    odd.addLast(val);
                }
            }
            if(odd.size > 0 && even.size > 0){
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }else if(odd.size > 0){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }else{
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        public void kReverse(int k){
            LinkedList prev = null;
            while(this.size > 0){
                LinkedList curr = new LinkedList();
                if(this.size >= k){
                    for(int i = 0; i < k; i++){
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }else{
                    int sz = this.size;
                    for(int i = 0; i < sz; i++){
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }
                if(prev == null){
                    prev = curr;
                }else{
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

    public static void main(String[] args) {
            try (Scanner scn = new Scanner(System.in)) {
                int n1 = scn.nextInt();
                LinkedList l1 = new LinkedList();
                for (int i = 0; i < n1; i++) {
                    int d = scn.nextInt();
                    l1.addLast(d);
                }
                int n2 = scn.nextInt();
                LinkedList l2 = new LinkedList();
                for (int i = 0; i < n2; i++) {
                    int d = scn.nextInt();
                    l2.addLast(d);
                }
                int k = scn.nextInt();
                LinkedList ml = mergeTwoSortedLists(l1, l2);
                ml.display();
                ml.kReverse(k);
                ml.display();
            }
        }

    } 

}

/*
    public static void main(String[] args){


        LinkedList<String> ll = new LinkedList<String>();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.add("G");
        ll.add("H");
        ll.add("I");
        ll.add("J");
        ll.add("K");
        ll.add("L");
        ll.add("M");
        ll.add("N");
        ll.add("O");
        ll.add("P");
        ll.add("Q");
        ll.add("R");
        ll.add("S");
        ll.add("T");
        ll.add("U");
        ll.add("V");
        ll.add("W");
        ll.add("X");
        ll.add("Y");
        ll.add("Z");
        System.out.println(ll);
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.get(2));
        System.out.println(ll.get(3));
        System.out.println(ll.get(4));
        System.out.println(ll.get(5));
        System.out.println(ll.get(6));
        System.out.println(ll.get(7));
        System.out.println(ll.get(8));
        System.out.println(ll.get(9));
        System.out.println(ll.get(10));
        System.out.println(ll.get(11));
        System.out.println(ll.get(12));
        System.out.println(ll.get(13));
        System.out.println(ll.get(14));
        System.out.println(ll.get(15));
        System.out.println(ll.get(16));
        System.out.println(ll.get(17));
        System.out.println(ll.get(18));
        System.out.println(ll.get(19));
        System.out.println(ll.get(20));
        System.out.println(ll.get(21));
        System.out.println(ll.get(22));
        System.out.println(ll.get(23));
        System.out.println(ll.get(24));
        System.out.println(ll.get(25));
        System.out.println(ll.get(26)); 
        
    } 
*/