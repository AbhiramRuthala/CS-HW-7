


//Sources used: Google AI Mode
package list;

///**
// * 
// * A custom built linked list
// * T here is the type the list stores
// */
public class LinkedList<T> implements SimpleList<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */
        head = null;
        tail = null;
        size = 0;

	}
	
	public int size() {
		/* TODO: Implement this method */
        if (size > 0) {
            return size;
        } else {
            return 0;
        }

	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */
        size = 0;
        head = null;
        tail = null;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */
        if (tail == null) {
            ListNode<T> newNode = new ListNode<>(data);
            tail = newNode;
        } else {
            ListNode<T> newNode = new ListNode<>(data);
            tail.next = newNode;
        }
        size++;
        

	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */

            //TODO: Finish implementing this method
            if (head == null) { // first node in the list
                ListNode<T> insertNode = new ListNode<T>(data); // node to insert

                //insertNode.next = TODO: How do we make the node point back to the list? Where should it point?
                insertNode.next = head;
                // TODO: How do we make the list point to the new node?
                head.next = insertNode;
                //head = insertNode;
            }
            else if (size == 1){  // there is only one node in the list
                ListNode<T> insertNode = new ListNode<T>(data); // node to insert
                //head.next = //TODO: make list point to new node
                insertNode.next = insertNode;
                //head = //TODO: upadate head to point to the new node
                head.next = insertNode;
            }
            else { // general case
                ListNode<T> insertNode = new ListNode<T>(data); // node to insert
                // find last node in list that points to head
                ListNode<T> temp = head;
                while (temp.next != head)
                    temp = temp.next;
                temp.next = insertNode; // TODO: make list point to new node
                head.next = insertNode; //TODO: upadate head to point to the new node
            }
            size++;


	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method */
        if(size == 0){
            insertAtTail(data);
        }

	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */

        it.curNode = it.curNode.next;

	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */
        if(tail == null){
            return null;
        } else if (size == 1){

        } else {
            T prevValue = tail.prev.getData();
            T nextValue = tail.next.getData();
            //tail = tail.next;
            tail.next.prev = tail.prev;
            tail.next = tail.next.next;
        }
		return null;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */
        if(tail == null){
            return null;
        } else if (size == 1){

        } else {
            T prevValue = head.prev.getData();
            T nextValue = head.next.getData();
            head.next = head.next.next;
            head.prev = head.prev.prev;
            head = head.next;
            head.prev.next = head;

        }
		return null;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */

        T sense = head.getData();
        it.curNode.prev.next = it.curNode.next;

//        T sense = it.value();
        it.curNode = it.curNode.next;

		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
        /* TODO: Implement this method */
        for(int i = 0; i < size; i++){
            if (head.getData().equals(data)){
                return i;
            }
            head = head.next;
        }

        return -1;



	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */
        if(index < 0 || index >= size || (head == null && tail == null)) {
            return null;
        } else {
            return LinkedList.this.get(index);
        }

	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		int count = 0;
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			count++;
			toRet += curNode.getData();
			if (count != size)
				toRet += ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */
        if(size == 0){
            return null;

        } else if(size == 1){
            ListIterator<T> sense = (ListIterator<T>) head.getData();
            return sense;
        }

		return null;
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */
        if(size == 0){
            return null;

        } else if(size == 1){
            ListIterator<T> sense = (ListIterator<T>) tail.getData();
            return sense;
        }

        return null;

	}
	
	
}
