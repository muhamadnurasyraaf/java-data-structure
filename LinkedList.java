
import java.nio.file.FileStore;

public class LinkedList {

    private Node firstNode;
    private Node LastNode;
    private Node currNode;

    public LinkedList() {
        firstNode = LastNode = currNode = null;
    }

    public void insertAtBack(Customer elem) {
        if(isEmpty()) {
            firstNode = LastNode = new Node(elem);
        }else {
            Node obj = new Node(elem);
            LastNode.next = obj;
            LastNode = LastNode.next;
        }
    }

    public void insertAtFront(Customer elem){
        if(isEmpty()){
            firstNode = LastNode = new Node(elem);
        }
        else{
            firstNode = LastNode.next = new Node(elem);
        }
    }

    public Customer getFirst() {

        if(isEmpty()) {
            throw new EmptyListException();
        }else {
            currNode = firstNode;
            return currNode.data;
        }
    }

    public Customer getNext() {
        if(isEmpty()) {
            throw new EmptyListException();
        }else if(currNode != LastNode){
            currNode = currNode.next;
            return currNode.data;
        }else {
            return null;
        }
    }

    public Customer removeFront() {

        Customer remove = null;

        if(isEmpty()) {
            throw new EmptyListException();
        }

        remove = firstNode.data;

        if(firstNode.equals(LastNode)) {
            firstNode = LastNode = null;
        }else {
            firstNode = firstNode.next;
        }
        return remove;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

}