package MyLinkedListImplementation1;

import MyLinkedListImplementation1.MyList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    static class Node<T>{
        T element;
        Node<T> nextElement;

        public Node(T element) {
            this.element = element;
        }
    }
    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size;

    public static <T> MyList<T> of(T... elements){
        MyLinkedList<T> linkedList = new MyLinkedList<>();
        for (T e : elements){
            linkedList.add(e);
        }
        return linkedList;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(firstElement == null){
            firstElement = lastElement = newNode;
        } else {
            lastElement.nextElement = newNode;
            lastElement = newNode;
        }
        size++;
    }

    @Override
    public void addByIndex(int index, T element) {
        Objects.checkIndex(index,size+1);
        Node<T> newNode = new Node<>(element);
        if (firstElement == null){
            firstElement = lastElement = newNode;
        } else if (index == 0) {
            newNode.nextElement = firstElement;
            firstElement = newNode;
        } else if (index == size) {
            lastElement.nextElement = newNode;
            lastElement = newNode;
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            newNode.nextElement = prev.nextElement;
            prev.nextElement = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = firstElement;
        for (int i = 0; i < index; i++) {
            current = current.nextElement;
        }
        return current;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index,size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index,size);
        return getNodeByIndex(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index,size);
        T removedElement;
        if (index == 0){
            removedElement = firstElement.element;
            firstElement = firstElement.nextElement;
            if (firstElement == null){
                lastElement = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.nextElement.element;
            prev.nextElement = prev.nextElement.nextElement;
            if (index == size - 1){
                lastElement = prev;
            }
        }
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = firstElement;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)){
                return true;
            }
            current = current.nextElement;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (firstElement == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        firstElement = lastElement = null;
        size = 0;
    }

}
