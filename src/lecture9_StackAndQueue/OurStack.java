package lecture9_StackAndQueue;

public class OurStack {

    StackNode top;
    int count;

    public OurStack (int value){
        top = new StackNode(value);
       count = 1 ;

    }
    public void push(int value){
        StackNode newNode = new StackNode(value);
        newNode.next = top;
        top = newNode;
        count++;
    }

    public int pop () throws IllegalStateException{
        //TODO Handle Empty Stack ;
        if(count == 0 )
            throw new IllegalStateException("you can not pop from empty Stack");

        StackNode current = top;
        top =  top.next;
        count--;
      return current.val;
    }

    public int peek(){
        //TODO Handle Empty Stack ;

        return top.val;
    }

    public boolean isEmpty(){
        return count ==0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return "OurStack{" +
                "top=" + top +
                '}';
    }

    private class StackNode {
        int val ;
        StackNode next;
        StackNode (int val){
            this .val = val;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
