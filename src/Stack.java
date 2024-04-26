public class Stack extends myLinkedList{

    public Stack(){
        super();
    }

    public boolean isEmpty(){
        if(Stack.super.getSize() == 0)
            return true;
        else
            return false;
    }

    public void push(int x){

// create Node for x
        Node n = new Node(x);

        //int x goes to top of stack -- insert front
        Stack.super.insertFront(n);

    }

    public int pop(){
        //value at top of stack is deleted and returned by the method
        int copy = Stack.super.getItem(1);
        Stack.super.deleteFront();
        return copy;
    }

    public int top(){
        //returns the value at the top but does not delete the item

        return Stack.super.getItem(1);

    }

}
