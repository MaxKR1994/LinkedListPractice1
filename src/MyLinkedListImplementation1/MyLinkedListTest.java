package MyLinkedListImplementation1;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        System.out.println("LinkedList size: " + myLinkedList.size());
        System.out.println("Element at index[1]: " + myLinkedList.get(1));
        System.out.println("First element: " + myLinkedList.getFirst());
        System.out.println("Last element: " + myLinkedList.getLast());
        System.out.println("Is the myLinkedList empty: " + myLinkedList.isEmpty());
        myLinkedList.addByIndex(0,10);// elements: [0, 1, 2, 3, 4] --> [10, 0, 1, 2, 3, 4]
        //    index: [0, 1, 2, 3, 4] --> [ 0, 1, 2, 3, 4, 5]
        System.out.println("Element at index[0] after add element by index[0]: " + myLinkedList.get(0));
        System.out.println("Element at index[0] after add element by index[5]: " + myLinkedList.get(5));
        System.out.println("LinkedList new size: " + myLinkedList.size()); // size "5" -> size "6"
        myLinkedList.set(2,20);
        System.out.println("Element at index[2]: " + myLinkedList.get(2));
        System.out.println("Does the myLinkedList contain element (10)?: " + myLinkedList.contains(10));
        myLinkedList.remove(5);
        System.out.println("Element at index[4]: " + myLinkedList.get(4));
    }
}
