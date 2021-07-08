public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array(capacity);
    }

    public ArrayQueue() {
        this.array = new Array();
    }

    public int getSize() {
        return this.array.getSize();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapacity() {
        return this.array.getCapacity();
    }

    public void enqueue(E e) {
        this.array.addLast(e);
    }

    public E dequeue() {
        return this.array.removeFirst();
    }

    public E getFront() {
        return this.array.getFirst();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");

        for(int i = 0; i < this.array.getSize(); ++i) {
            res.append(this.array.get(i));
            if (i != this.array.getSize() - 1) {
                res.append(",");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue();

        for(int i = 0; i < 10; i ++ ) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
