package lecture9_StackAndQueue;

public class LinkedListQueue<T> {

    private QueueNode<T> start;
    private QueueNode<T> end;
    private int count;

    public LinkedListQueue(T value) {
        QueueNode<T> newNode = new QueueNode<T>(value);
        start = newNode;
        end = newNode;
        count = 1;
    }

    public void enqueue ( T value){
        QueueNode<T> newNode = new QueueNode<>(value);
        end.next = newNode;
        end = newNode;
        count++;
    }
    public T dequeue() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException("Cannot dequeue from an empty queue");
        T current = start.val;
        start = start.next;
        count--;
        return current;

    }
    public boolean isEmpty(){
        return count==0;
    }
    public int size(){
        return count;
    }
    public T peek() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException("Cannot peek from an empty queue");
        return start.val;

    }


    private static  class QueueNode <T>{
        T val;
        QueueNode<T> next;

        public QueueNode(T val) {
            this.val = val;
        }
    }

}


