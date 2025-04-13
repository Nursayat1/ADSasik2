public class Main {
    public static void main(String[] args) {

        System.out.println(" ArrayList Test ");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "X"); // Insert element "X" at index 1
        System.out.println("After additions: ");
        for (String s : arrayList) System.out.print(s + " ");
        arrayList.remove(2); // Remove element at index 2 ("B")
        System.out.println("\nAfter removal: ");
        for (String s : arrayList) System.out.print(s + " ");

        System.out.println("\n\n LinkedList Test ");
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(1, 15); // Insert 15 at index 1
        System.out.println("After additions: ");
        for (int i : linkedList) System.out.print(i + " ");
        linkedList.remove(2); // Remove element at index 2 (which was 20)
        System.out.println("\nAfter removal: ");
        for (int i : linkedList) System.out.print(i + " ");

        System.out.println("\n\n Stack Test ");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3); // Stack becomes [1, 2, 3]
        System.out.println("Peek: " + stack.peek()); // View the top element (3)
        System.out.println("Pop: " + stack.pop());   // Remove the top element (3)
        System.out.println("Size: " + stack.size()); // Check stack size (2)

        System.out.println("\n Queue Test ");
        Queue<String> queue = new Queue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third"); // Queue becomes [first, second, third]
        System.out.println("Peek: " + queue.peek());       // View front element (first)
        System.out.println("Dequeue: " + queue.dequeue()); // Remove front element (first)
        System.out.println("Size: " + queue.size());       // Check queue size (2)

        System.out.println("\n MinHeap Test ");
        MinHeap<Integer> heap = new MinHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1); // Heap rearranges to keep the smallest element at the top
        System.out.println("Min: " + heap.peek());         // View the smallest element (1)
        System.out.println("Extract Min: " + heap.extractMin()); // Remove and return min (1)
        System.out.println("New Min: " + heap.peek());     // View the new smallest element
    }
}
