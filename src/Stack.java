public class Stack<E> {
    private ArrayList<E> list;

    public Stack() {
        list = new ArrayList<>();
    }

    // Adds an element to the top of the stack
    public void push(E element) {
        list.add(element);
    }

    // Removes and returns the top element of the stack
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.remove(list.size() - 1);
    }

    // Returns the top element without removing it
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
