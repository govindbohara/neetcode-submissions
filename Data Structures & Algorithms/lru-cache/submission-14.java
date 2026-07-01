class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int k, int val){
        this.key = k;
        this.val = val;
    }

    Node(int key, int val, Node prev, Node next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    int cap;
    Node left;
    Node right;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(0,0,null, null);
        right = new Node(0,0, null, null);
        left.next = right;
        right.prev = left;
        this.left = left;
        this.right = right;

        map = new HashMap();
    }

    public void removeKey(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        

    };
    public void insertKey(Node node){
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    };
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            removeKey(n);
            insertKey(n);
            return n.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            removeKey(n);
            insertKey(n);
            return;
        }
        if(map.size() == cap){
            Node lru = left.next;
            removeKey(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        map.put(key, newNode);
        insertKey(newNode);
    }
}
