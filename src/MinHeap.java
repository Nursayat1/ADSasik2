public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> heap;

    // Constructor initializes an empty heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Adds a new element and restores the heap property by moving it up
    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Removes and returns the minimum element (root) and restores heap
    public E extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        E min = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.add(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // Returns the minimum element without removing it
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // Moves the element at index up to maintain heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    // Moves the element at index down to maintain heap property
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            // Check if left child is smaller
            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            // Check if right child is smaller
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    // Swaps elements at index i and j
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.remove(i + 1);
        heap.add(j, temp);
        heap.remove(j + 1);
    }
}
