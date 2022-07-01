package MyLinkedListImplementation1;

public interface MyList<T> {
    public void add(T element);
    public void addByIndex(int index,T element);
    public void set(int index, T element);
    public T get(int index);
    public T getFirst();
    public T getLast();
    public T remove(int index);
    public boolean contains (T element);
    public boolean isEmpty ();
    public int size();
    public void clear();
}
