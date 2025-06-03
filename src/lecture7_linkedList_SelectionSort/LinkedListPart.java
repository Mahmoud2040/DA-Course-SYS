package lecture7_linkedList_SelectionSort;

import lecture7_linkedList_SelectionSort.ourLinkedList.OurLinkedList;

import java.util.LinkedList;

public class LinkedListPart {


    public static void main (String [] args){

        LinkedList<Integer>linkedList2 = new LinkedList<Integer>();
        linkedList2.add(5);
        linkedList2.add(55);
        linkedList2.add(95);
        System.out.println( linkedList2.get(1));


        OurLinkedList linkedList = new OurLinkedList();

        linkedList.print();
        System.out.println("-------------------");
        linkedList.add(25);
        linkedList.print();
        System.out.println("-------------------");

        linkedList.add(30);
        linkedList.print();
        System.out.println("-------------------");

        linkedList.add(80);
        linkedList.print();
        System.out.println("-------------------");

        linkedList.add(90);
        linkedList.print();
        System.out.println("-------------------");

        linkedList.add(800);
        linkedList.print();
        System.out.println("-------------------");

        linkedList.add(8880);
        linkedList.print();
        System.out.println("-------------------");

    }
}
