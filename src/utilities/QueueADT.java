package utilities;
//linked list
public interface QueueADT<E> {

	// Person 3

    void enqueue(E element);

    E dequeue();

    E peek();

    boolean equals(QueueADT<E> that);

    Iterator<E> iterator();
    // Person 4 

    Object[] toArray();
  
    E[] toArray(E[] copy);

    boolean isFull();

    int size();

    boolean isEmpty();

    void dequeueAll();
}
