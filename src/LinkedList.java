public class LinkedList<E> implements List<E> {
    private class MyNode {
        E data;
        MyNode next;
        MyNode prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    // Adds an element to the end of the list
    @Override
    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (head == null) { // If list is empty, set both head and tail
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Adds an element at a specific index
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(element);

        if (index == 0) { // Add to the beginning
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (size == 0) tail = head;
        } else if (index == size) { // Add to the end
            add(element);
            return;
        } else {
            // Insert in the middle
            MyNode current = getNode(index);
            MyNode previous = current.prev;

            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    // Returns the element at the given index
    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    // Helper method to get node by index efficiently (from head or tail)
    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    // Removes and returns the element at the given index
    @Override
    public E remove(int index) {
        MyNode toRemove = getNode(index);
        E data = toRemove.data;

        MyNode before = toRemove.prev;
        MyNode after = toRemove.next;

        if (before != null) before.next = after;
        else head = after;

        if (after != null) after.prev = before;
        else tail = before;

        size--;
        return data;
    }

    // Removes the first occurrence of the given element
    @Override
    public boolean remove(E element) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if ((element == null && current.data == null) ||
                    (element != null && element.equals(current.data))) {
                remove(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Clears the entire list
    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    // Returns index of first occurrence of the element, or -1 if not found
    @Override
    public int indexOf(E element) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if ((element == null && current.data == null) ||
                    (element != null && element.equals(current.data))) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // Provides iterator to traverse the list
    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
