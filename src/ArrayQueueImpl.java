public class ArrayQueueImpl {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public int peek() {
        //implement
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public void enqueue(int obj) {
        //implement
        if(rear == arr.length) {
            resize();
        }
        if(front == -1) {
            front = 0;
            arr[front] = obj;
            return;
        }
        else if(rear == front){
            rear++;
            arr[rear] = obj;
        }
        else {
            if (rear == arr.length - 1) {
                resize();
            }
            rear++;
            arr[rear] = obj;
        }
    }

    public int dequeue() {
        //implement
        if (isEmpty()) {
            return -1;
        }
        else if (front == rear) {
            int item = arr[front];
            front = -1;
            return item;
        }
        else {
            int item = arr[front];
            for(int i = 1; i < rear ; i++){
                arr[i - 1] = arr[i];
            }
            rear--;
            return item;
        }
    }

    public boolean isEmpty() {
        //implement
        if(front == -1){
            System.out.println("Queue is Empty");
        }
        return front == -1;
    }

    public int size() {
        //implement
        if(front == -1){
            return 0;
        }
        return rear + 1;
    }

    private void resize() {
        //implement
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {
        ArrayQueueImpl arrayQueue = new ArrayQueueImpl();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(7);
        arrayQueue.enqueue(8);
        arrayQueue.enqueue(9);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(11);
        System.out.println("First element is: "+arrayQueue.peek());
        System.out.println("Queue size is "+arrayQueue.size());
        System.out.println("Dequeue element: "+arrayQueue.dequeue());
        System.out.println("Queue size is "+arrayQueue.size());
        System.out.println("Dequeue element: "+arrayQueue.dequeue());
        System.out.println("First element is: "+arrayQueue.peek());
    }
}

