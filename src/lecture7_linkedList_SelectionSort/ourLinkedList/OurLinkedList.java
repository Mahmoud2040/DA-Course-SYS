package lecture7_linkedList_SelectionSort.ourLinkedList;

public class OurLinkedList {

    Node head ;
    Node last ;

    public boolean add (int value) {
        Node newValue = new Node(value);
        if (head == null){
            head = newValue;
            last = head;
        }else {
        last.setNext(newValue);
        last = newValue;
        }
        return true;
    }

    public boolean delete (int value) {

        return false;
    }

    public boolean search (int value) {


        return false;
    }

    public void print() {
     if(head!=null ){
        Node current = head ;
        while (current!=null ){
            System.out.println( current.getValue() + " -> " + current.getNext());
            current = current.getNext();
        }
     }else
         System.out.println("{ }");


    }
}
