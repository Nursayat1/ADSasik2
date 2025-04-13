public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        // Ensures there is enough space in the array to add more elements
        if (size >= elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    @Override
    public void add(E element) {
        // Adds an element at the end of the list
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        // Adds an element at a specific index in the list
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        // Returns the element at the specified index
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    @Override
    public E remove(int index) {
        // Removes the element at the specified index and shifts elements to the left
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E removed = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    @Override
    public boolean remove(E element) {
        // Removes the first occurrence of the specified element
        int index = indexOf(element);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public int size() {
        // Returns the number of elements in the list
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Checks if the list is empty
        return size == 0;
    }

    @Override
    public void clear() {
        // Clears all elements from the list
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        // Checks if the list contains the specified element
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        // Returns the index of the first occurrence of the specified element
        for (int i = 0; i < size; i++) {
            if (element == null && elements[i] == null) return i;
            if (element != null && element.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        // Returns an iterator for the list
        return new java.util.Iterator<E>() {
            private int current = 0;

            public boolean hasNext() {
                return current < size;
            }

            public E next() {
                return (E) elements[current++];
            }
        };
    }
}
