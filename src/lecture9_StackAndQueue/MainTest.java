package lecture9_StackAndQueue;

public class MainTest {


    public static void main (String []args ){

        OurStack stack = new OurStack(3);
        System.out.println(stack);
        stack.push(3);
        stack.push(12);
        stack.push(25);
        stack.push(7);
        stack.push(9);

        System.out.println(stack);

        System.out.println("Test peek " + stack.peek());
        System.out.println("Test size " + stack.size());
        System.out.println("Test is Empty " + stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);

        System.out.println("Test peek " + stack.peek());
        System.out.println("Test size " + stack.size());
        System.out.println("Test is Empty " + stack.isEmpty());

        stack.pop();
        stack.pop();

        try {
            stack.pop();
        }catch (IllegalStateException e){
            System.out.println("error happned " + e.getLocalizedMessage());
        }


    }
}
