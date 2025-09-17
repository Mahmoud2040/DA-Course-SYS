package lecture9_StackAndQueue;

import java.util.*;

public class MainTest {


    public static void main (String []args ){

        OurQueue queue = new OurQueue(3);

        String s = "Ali";
        String w = "Ali";
        System.out.println("BAlice".hashCode());
        System.out.println("Alice".hashCode());



        System.out.println(s.hashCode());


      /*  System.out.println(queue);
        queue.enqueue(3);
        queue.enqueue(12);
        queue.enqueue(25);
        queue.enqueue(7);
        queue.enqueue(9);

        System.out.println(queue);

        System.out.println("Test peek " + queue.peek());
        System.out.println("Test size " + queue.size());
        System.out.println("Test is Empty " + queue.isEmpty());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue);

        System.out.println("Test peek " + queue.peek());
        System.out.println("Test size " + queue.size());
        System.out.println("Test is Empty " + queue.isEmpty());

        queue.dequeue();
        queue.dequeue();

        try {
            queue.dequeue();
        }catch (IllegalStateException e){
            System.out.println("error happned " + e.getLocalizedMessage());
        }*/


    }
}
