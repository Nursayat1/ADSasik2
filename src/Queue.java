public class Queue<E> {
    private LinkedList<E> list;

    // Initializes an empty queue using MyLinkedList
    public Queue() {
        list = new LinkedList<>();
    }

    // Adds an element to the end of the queue
    public void enqueue(E element) {
        list.add(element);
    }

    // Removes and returns the front element of the queue
    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    // Returns the front element without removing it
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    // Returns true if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the number of elements in the queue
    public int size() {
        return list.size();
    }
}
