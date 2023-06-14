public class ArrayLinkedStack {
    private Node top;
    private int size;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public ArrayLinkedStack() {
        top = null;
        size = 0;
    }

    public void push(Object item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Object item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayLinkedStack stack = new ArrayLinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Top element is : "+stack.peek());

        System.out.println("size of stack: " + stack.size());
        System.out.println("popped item: " + stack.pop());
        System.out.println("Top element is : "+stack.peek());
        System.out.println("popped item: " + stack.pop());
        System.out.println("Top element is : "+stack.peek());
    }
}