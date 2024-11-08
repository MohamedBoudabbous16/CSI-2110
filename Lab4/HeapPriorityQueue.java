/**
 * Array Heap implementation of a priority queue
 * @author Lachlan Plant
 */
public class HeapPriorityQueue<K extends Comparable,V> implements PriorityQueue<K ,V> {
    
    private Entry[] storage; //The Heap itself in array form
    private int tail;        //Index of last element in the heap
    
    /**
    * Default constructor
    */
    public HeapPriorityQueue(){
        this.storage = new Entry[10];
        this.tail = -1;
    }
    
    /**
    * HeapPriorityQueue constructor with max storage of size elements
    */
    public HeapPriorityQueue(int size){
        this.storage = new Entry[size];
        this.tail = -1;
    }
    
    /****************************************************
     * 
     *             Priority Queue Methods
     * 
     ****************************************************/
    
    /**
    * Returns the number of items in the priority queue.
    * O(1)
    * @return number of items
    */
    public int size(){return tail+1;
    }

    /**
    * Tests whether the priority queue is empty.
    * O(1)
    * @return true if the priority queue is empty, false otherwise
    */
    public boolean isEmpty(){
        if (size() ==0) return true;
        else{
            return false;
        }
    }
    
    /**
    * Inserts a key-value pair and returns the entry created.
    * O(log(n))
    * @param key     the key of the new entry
    * @param value   the associated value of the new entry
    * @return the entry storing the new key-value pair
    * @throws IllegalArgumentException if the heap is full
    */
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        if (tail == storage.length - 1){
            throw new IllegalArgumentException("Heap is full");
        }
        else{
            Entry<K,V> e = new Entry<>(key,value);
            tail++;
            storage[tail] = new Entry(key, value);
            upHeap(tail);
            return e;
        }
    }
    
    /**
    * Returns (but does not remove) an entry with minimal key.
    * O(1)
    * @return entry having a minimal key (or null if empty)
    */
    public Entry<K, V> min() {
        if (isEmpty()) return null;
        return storage[0];
    }
    
    /**
    * Removes and returns an entry with minimal key.
    * O(log(n))
    * @return the removed entry (or null if empty)
    */ 
    public Entry<K,V> removeMin(){
        if (isEmpty()) return null;
        else{
            Entry<K,V> e = storage[0];
            storage[0] = storage[tail];
            storage[tail] = null;
            tail--;
            downHeap(0);
            return e;

        }
    }
    
    
    /****************************************************
     * 
     *           Methods for Heap Operations
     * 
     ****************************************************/
    
    /**
    * Algorithm to place element after insertion at the tail.
    * O(log(n))
    */
    private void upHeap(int location) {
        if (location == 0) return;
        int parentIndex = (location - 1) / 2;
        if (storage[location].getKey().compareTo(storage[parentIndex].getKey()) < 0) {
            swap(location, parentIndex);
            upHeap(parentIndex);
        }
    }



    
    /**
    * Algorithm to place element after removal of root and tail element placed at root.
    * O(log(n))
    */
    private void downHeap(int location){
        int leftChildIndex = 2 * location + 1;
        int rightChildIndex = 2 * location + 2;
        int smallest = location;
        if (leftChildIndex > tail){
            return;
        }
        if (leftChildIndex <= tail){
            if (storage[leftChildIndex].getKey().compareTo(storage[smallest].getKey()) < 0) {
                smallest = leftChildIndex;
            }
        }
        if ((rightChildIndex <= tail) && (storage[rightChildIndex].getKey().compareTo(storage[smallest].getKey()) < 0)) {
            smallest = rightChildIndex;
        }
        if (smallest != location) {
            swap(location, smallest);
            downHeap(smallest);
        }
    }


    /**
    * Find parent of a given location,
    * Parent of the root is the root
    * O(1)
    */
    private int parent(int location) {
        if (location == 0) return 0;
        return (location - 1) / 2;
    }



    /**
    * Inplace swap of 2 elements, assumes locations are in array
    * O(1)
    */
    private void swap(int location1, int location2){
        Entry<K, V> temp = storage[location1];
        storage[location1]= storage[location2];
        storage[location2]= temp;
    }
    
}
