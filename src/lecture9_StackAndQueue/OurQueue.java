package lecture9_StackAndQueue;

public class OurQueue {

    int count ;
    QueueNode start;
    QueueNode end ;

    public OurQueue(int  value) {
        QueueNode node = new QueueNode(value);
        this.start = node;
        this.end = node;
         count = 1 ;
    }

    public void enqueue (int  value){
        QueueNode newNode = new QueueNode(value);
        end.next = newNode;
        end = newNode;
        count++;
    }

    public boolean isEmpty(){
        return start==null;
    }
    public int dequeue() throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException("empty queue");
        QueueNode current = start;
        start =start.next;
        count--;
        return current.val;
    }
    public int peek () throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException("empty queue");
        return start.val;
    }

    @Override
    public String toString() {
        return "OurQueue{" +
                "count=" + count +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int size() {
        return count;
    }

    private static class QueueNode {
        int val ;
        OurQueue.QueueNode next;
        QueueNode (int val){
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
