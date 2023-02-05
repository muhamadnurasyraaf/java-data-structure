
public class Node {
    public Customer data;
    public Node next;
    
        public Node(Customer c) {
            this.data = c;
            this.next = null;  
        }
    
        public Node(Customer c, Node nextNode) {
            this.data = c;
            this.next = nextNode;
        }
    
        public Customer getContestant() {return data;}
        public Node getLink() {return next;}
}
