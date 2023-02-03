import java.util.*;

public class LinkedList2{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    public static int size;
    private char[] haed;

    public void addFirst(int data){

        //step1 = cretae a new node
        Node newNode = new Node(data);
        size++;

        if(head ==null){
            head = tail = newNode;
            return;
        }

        //step2 = newNode next = head
        newNode.next = head;

        //step3 = head = newNode
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){ //O(n)

        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx < 0 || idx > size){
            System.out.println("Invalid Index");
            return;
        }
        if(idx == 0){
            addFirst(data);
            return;
        }
        if(idx == size){
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for(int i = 0; i < idx - 1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // public int removeLast(){
    //     if(size == 0){
    //         System.out.println("List is empty");
    //         return Integer.MIN_VALUE;
    //     }
    //     else if(size == 1){
    //         int val = head.data;
    //         head = tail = null;
    //         size = 0;
    //         return val;
    //     }
    //     int val = tail.data;
    //     Node temp = head;
    //     while(temp.next != tail){
    //         temp = temp.next;
    //     }
    //     temp.next = null;
    //     tail = temp;
    //     size--;
    //     return val;
    // }

    public int removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
 
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Search (Iterative)
    public int itrSearch(int key){ //O(n)
        Node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data == key){ //key found case
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    //Search(Reursive)
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key){ //O(n)
        return helper(head, key);
    }

    //Reverse a Linked List Iterative
    public void reverse(){
    
        Node prev = null;
        Node curr = tail = head;
        Node Next;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        head = prev;
    }

    //Find and Remove nth node from the end of the list(Iterative)
    // public void removeNthFromEnd(int n){
    //     if(n > size){
    //         System.out.println("Invalid Index");
    //         return;
    //     }
    //     if(n == size){
    //         removeFirst();
    //         return;
    //     }
    //     if(n == 1){
    //         removeLast();
    //         return;
    //     }
    //     Node temp = head;
    //     for(int i = 0; i < size - n - 1; i++){
    //         temp = temp.next;
    //     }
    //     temp.next = temp.next.next;
    //     size--;
    // }

    public void deleteNthFromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next; //remove first
            return;
        }

        //sz-n
        int i =1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    //Check if a Linked List is Palindrome
    // public boolean isPalindrome(){
    //     Node temp = head;
    //     Stack<Integer> st = new Stack<>();
    //     while(temp != null){
    //         st.push(temp.data);
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     while(temp != null){
    //         if(temp.data != st.pop()){
    //             return false;
    //         }
    //         temp = temp.next;
    //     }
    //     return true;
    // }

    public Node findMid(Node head){  //helper
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);
        
        //step1- reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  //rght half head
        Node left = head;

        //step3 - check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    //Detect a Loop/Cycle in a linked list
    //floyd's cycle finding Algorithm
    public static boolean IScycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //Remove a Loop/Cycle in a linked list
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    public static void main(String[] args){
        LinkedList2 ll = new LinkedList2();

        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        ll.add(2, 3);
        ll.print();
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        ll.reverse();
        ll.print();
        ll.reverse();
        ll.print();
        ll.add(2, 30);
        ll.print();


        System.out.println("Size of the list is: " + size);
        System.out.println(ll.itrSearch(4));
        System.out.println(ll.recSearch(30));
        System.out.println(ll.recSearch(3));

       ll. addLast(4);
       ll. addLast(30);
       ll. addLast(3);
       ll. addLast(2);
       ll.print();
       System.out.println(ll.checkPalindrome());
       System.out.println(size/2);
       ll.print();
       LinkedList2.head = ll.mergeSort(LinkedList2.head);
       ll.print();
       ll.print();
       System.out.println(ll.haed);

       
       //for Cyclic (infinite loop)
    //    head = new Node(1);
    //    head.next = new Node(2);
    //    head.next.next = new Node(3);
    //    head.next.next.next = head;  //1->2->3->1
    //    System.out.print(IScycle());

    //    head = new Node(1);
    //    Node temp = new Node(2);
    //    head.next = temp;
    //    head.next.next = new Node(3);
    //    head.next.next.next = temp;  //1->2->3->2
    //    System.out.println(IScycle());
    //    ll.print();
    //    removeCycle();
    //    System.out.println(IScycle());
    //    ll.print();


    }
}