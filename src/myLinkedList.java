//Emma Hopkins -- this code contains the methods for inserting, deleting, and printing the list
public class myLinkedList  {
    protected  Node head;

    protected int  size;
    public  myLinkedList( )    // default constructor
    {
        head = null;
        size = 0;
    }
    void insertEmpty(Node n){
        n.setNext(n);
        n.setPrev(n);
        head = n;
        size++;
    }
    void insertFront(Node n){
        Node front = head;
        if(isEmpty()){
            insertEmpty(n);
            return;
        }
        n.setPrev( front.getPrev( ) ) ;    // list is NOT empty so hook up the n node
        n.setNext( front );
        front.getPrev( ).setNext(n);
        front.setPrev( n );
        head = n;
        size++;
    }

    void insertRear (Node n){

        if(isEmpty()){
            insertEmpty(n);
            return;
        }
        head.getPrev().setNext(n);
        head.setPrev(n);
        n.setPrev(head.getPrev());
        n.setNext(head);
        size++;
    }

    void insertPos(Node n, int pos){
        Node temp = head;
        int count = 1;
        if(isEmpty()) {
            insertEmpty(n);
            return;
        }
        if(pos == 1){
            insertFront(n);
            size++;
        }
        else{
            while(count < pos){
                temp = temp.getNext();
                count++;
            }
            size++;
            n.setPrev(temp.getPrev());
            n.setNext(temp);
            temp.getPrev().setNext(n);
            temp.setPrev(n);
        }
    }

    int deleteFront(){
        int copy = head.getData();
        head.getNext().setPrev(head.getPrev());
        head.getPrev().setNext(head.getNext());
        head = head.getNext( );
        size=size-1;
        return copy;
    }

    int deleteRear(){
        Node front = head.getPrev();
        int copy = head.getPrev().getData();

        front.getPrev().setNext(head.getPrev().getPrev());
        front.getPrev().setPrev(head.getPrev().getNext());
        front = front.getPrev().getPrev();
        size--;
        return copy;
    }

    int deletePos(int pos){
        Node temp = head;
        int count = 1;
        if (pos == 1) {
            deleteFront();
        }
        if (pos == size) {
            deleteRear();
        }
        else{
            while(count < pos){
                temp = temp.getNext();
                count++;
            }
            temp.getPrev( ).setNext(  temp.getNext() );
            temp.getNext( ).setPrev( temp.getPrev( ) );

            //temp.getNext().setPrev(temp.getPrev());
            //temp.getPrev().setNext(temp.getNext());
            size--;

        }
        return temp.getData();
    }

    void printList(Node n){
        Node front = head;
        int temp = head.getNext().getData();
        if(isEmpty()) {
            insertEmpty(n);
            return;
        }
        System.out.println(1 + " : " + head.getData( ));
        //while(temp != front)
        for(int i = 2; i <= size; i++) {
            temp =  front.getNext().getData();
            System.out.println(i + " : " + temp);
            front = front.getNext();

        }
        //}

    }

    boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

   int getItem(int pos) {
        Node temp = head;
        int count = 1;

        while (count < pos) {
            temp = temp.getNext();
            count++;
        }
        return temp.getData();
    }

     int getSize(){
        return size;
    }

// Add setter and Getter methods for Head and Size fields HERE
}   // end myLinkedList class
