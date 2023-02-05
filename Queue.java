
public class Queue {

    LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue (Customer elem) {
        list.insertAtBack(elem);
    }

    public Customer dequeue() {
        return list.removeFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}