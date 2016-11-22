public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev = null;
        Node next = null;
     
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    int size;
    Map<Integer, Node> mapping = new HashMap<Integer, Node>();
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        int retval = -1;
        if (mapping.containsKey(key)){
            Node curr = mapping.get(key);
            retval = curr.value;
            //change pointers
            
            resetPointers(curr);
            
        }
        
        return retval;
    }
    
    public void set(int key, int value) {
        
        if (mapping.containsKey(key)){
            Node curr = mapping.get(key);
            curr.value = value;
            
            resetPointers(curr);
            return;
        }
        
        //append to tail if not in mapping
        
        Node newNode = new Node(key, value);
        if (capacity == size){ //cannot add any more
            //evict head
            mapping.remove(head.key);
            if (head == tail){
                //only element
                head = null;
                tail = null;
            }else{
                //more than one elem
                Node newHead = head.next;
                newHead.prev = null;
                head = newHead;
                size--;
            }
        }
        
        if (tail == null){ //if cache empty;
            head = newNode;
            tail = newNode;
            
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        mapping.put(key, newNode);
        size++;
    }
    
    public void resetPointers(Node curr){
        if (head == curr && tail == curr){ //only element
                
        } else if (tail == curr){
            
        } else if (head == curr){
            head = curr.next;
            curr.next = null;
            head.prev = null;
            
            curr.prev = tail;
            tail.next = curr;
            tail = curr;
        } else {
            
            Node prev = curr.prev;
            Node next = curr.next;
            prev.next = next;
            next.prev = prev;
            
            curr.next = null;
            curr.prev = tail;
            tail.next = curr;
            tail = curr;
                
        }
    }
    
}