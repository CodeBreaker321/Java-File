package LinkedList;
public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void addFirst(int data){
        Node cpy = new Node(data);
        if(head == null ){
            head = tail =cpy;
        }
        cpy.next = head;
        head = cpy;
    }
    public static void addlast(int data){
        Node cpy = new Node(data);
        if(head == null){
            head = tail = cpy;
            return;
        }
        tail.next=cpy;
        tail=cpy;

    }
    public static void addmiddle(int data, int idx){
        Node cpy = new Node(data);
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(i==idx-1){
                cpy.next = temp.next;
                temp.next = cpy;
                break;
            }
            temp=temp.next;
            i++;
        }
    }
    public static void printll(){
        if(head == null){
            System.out.println("LL Is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    public static int sizell(){
        int cnt=0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    public static int removefirst(){
        if(head == null){
            System.out.println("Linked List Is  Empty");
            return Integer.MIN_VALUE;
        }
        else if(sizell()==1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }
    public static int removelast(){
        if(head == null){
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        }
        if(sizell()==1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        return val;
    }
    public static int SearchIter(int key){
        int cnt=0;
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                return cnt;
            }
            cnt++;
            temp=temp.next;
        }
        return -1;
    }
    public static int searchRecc(int key,int cnt,Node temp){
        if(temp.next == null){
            if(temp.data == key){
                return cnt;
            }
            return -1;
        }
        if(temp.data == key){
            return cnt;
        }
        return searchRecc(key,cnt+1,temp.next);
    }
    // public static void ReverseLL(){
    //     Node prev = null;
    //     Node curr = head;
    //     Node next;
    //     while(curr!=null){
    //         curr.next = prev;
    //         next = 
    //     }


    // }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addlast(2);
        printll();
        ll.addmiddle(10,2);
        printll();
        System.out.println(sizell());
        ll.removefirst();
        printll();
        // ll.removelast();
        // ll.removelast();
        // ll.removelast();
        // ll.removelast();
        System.out.println(ll.SearchIter(2));
        System.out.println(searchRecc(2, 0, head));
        printll();
    }
}
