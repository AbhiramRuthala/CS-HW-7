//Name: Abhiram Ruthala
//Email: kas4kj@virginia.edu
//HW = CS HW 7
//Sources used: Google AI Mode, ChatGPT 5, https://www2.lawrence.edu/fast/GREGGJ/CMSC270/linked/iterators.html#:~:text=The%20iterator%20for%20the%20list,the%20iterator%20to%20point%20to.
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
        ListNode<T> newNode = new ListNode<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;

        }
        size++;
        

	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */
        ListNode<T> newNode = new ListNode<>(data);

            //TODO: Finish implementing this method
            if(size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
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
        ListNode<T> newNode = new ListNode<>(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
        } else if (index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {

            ListNode<T> current = head;
            if(index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            } else {
                for (int i = 0; i < index; i++) {
                    current = current.next;

                }
                current.next = newNode;
                newNode.prev = current;
            }
        }
        size++;

	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */
        ListNode<T> newNode = new ListNode<>(data);

        if(it.curNode == head) {
            newNode.next = head;
            head = newNode;
        } else if (it.curNode == tail) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            newNode.next = it.curNode.next;
            it.curNode.next.prev = newNode;
            newNode.prev = it.curNode;
            it.curNode.next = newNode;
        }
        size++;



	}

	public T removeAtTail(){
		/* TODO: Implement this method */
//        if(tail == null){
//            return null;
//        } else if (size == 1){
//
//        } else {
//            T prevValue = tail.prev.getData();
//            T nextValue = tail.next.getData();
//            //tail = tail.next;
//            tail.next.prev = tail.prev;
//            tail.next = tail.next.next;
//        }
//		return null;
        T newdata = tail.getData();

        if(size == 0){
            return null;
        } else {
            tail = tail.prev;
            if(tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            size--;
            return newdata;
        }

	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */
//        if(tail == null){
//            return null;
//        } else if (size == 1){
//
//        } else {
//            T prevValue = head.prev.getData();
//            T nextValue = head.next.getData();
//            head.next = head.next.next;
//            head.prev = head.prev.prev;
//            head = head.next;
//            head.prev.next = head;
//
//        }
//		return null;
        T lostData = head.getData();

        if(size == 0){
            return null;
        } else {
            head = head.next;
            if(head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return lostData;
        }
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */
        if(it.curNode == null) {
            return null;
        }
        if(it.curNode == head) {
            it.curNode.prev.next = null;
            it.curNode.next.prev = null;
            it.curNode = null;
            head = head.next;
        } else if (it.curNode == tail) {
            it.curNode.prev.next = null;
            tail = tail.prev;
        } else {
            it.curNode.prev.next = it.curNode.next;
            it.curNode.next.prev = it.curNode.prev;
        }
        size--;

//        T sense = head.getData();
//        it.curNode.prev.next = it.curNode.next;
//
////        T sense = it.value();
//        it.curNode = it.curNode.next;

		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
        /* TODO: Implement this method */
        ListNode<T> curr = head;
        for(int i = 0; i < size; i++){
            if (curr.getData().equals(data)){
                return i;
            }
            curr = curr.next;
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
        if(index < 0 || index >= size) {
            return null;
        }
        if(size == 0){
            return null;
        }

        ListNode<T> temp = head;
        if(temp == null) {
            return null;
        }


        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp.getData();
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
        if(size == 0) {
            return null;
        } else {
            return new ListIterator<>(head);
        }
//        } else if(size == 1){
//            ListIterator<T> sense = (ListIterator<T>) head.getData();
//            return sense;
//        }

	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */
        if(size == 0) {
            return null;

        } else {
            return new ListIterator<>(tail);
        }
//        } else if(size == 1){
//            ListIterator<T> sense = (ListIterator<T>) tail.getData();
//            return sense;
//        }


	}
	
	
}
