//Name: Abhiram Ruthala
//Email: kas4kj@virginia.edu
//HW = CS HW 7
//Sources used: Google AI Mode, ChatGPT 5, https://www2.lawrence.edu/fast/GREGGJ/CMSC270/linked/iterators.html#:~:text=The%20iterator%20for%20the%20list,the%20iterator%20to%20point%20to.
package queue;

import list.LinkedList;

/**
 * A Linked-List based Queue
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{
	private LinkedList<T> list;
	/**
	 * Constructor: Initialize the inner list 
	 */
	public Queue(){
		/* TODO: Implement this method */
        this.list = new LinkedList<>();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		/* TODO: Implement this method */
        if (list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
	}
	
	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		/* TODO: Implement this method */ 
		/* Hint: Which method in LinkedList.java already accomplishes this? */
        if(list.size() > 0) {
            list.insertAtTail(data);
        } else {
            return;
        }
	}
	
	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue() throws EmptyQueueException {		
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */ 
		/* What should you do if the queue is empty? */
        if(list.size() > 0) {
            T sense = list.removeAtHead();
            return sense;
        } else if (list.size() == 0) {
            throw new EmptyQueueException("It's an empty queue. There are no parameters initialized.");
        } else {
            return null;
        }
	}

	/**
	 * Simply return the value from the head of the list, list should remain unchanged 
         * throw exception if list is empty.
	 */
	public T peek() throws EmptyQueueException {		
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */ 
		/* What should you do if the queue is empty? */

        if(list.size() > 0) {
//            list.find(list.removeAtHead());
            list.get(0);
            return list.get(0);
        } else if (list.size() == 0) {
            throw new EmptyQueueException("It's an empty queue. There are no parameters initialized.");
        } else {
            return null;
        }
	}
}
