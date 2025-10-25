//Name: Abhiram Ruthala
//Email: kas4kj@virginia.edu
//HW = CS HW 7
//Sources used: Google AI Mode, ChatGPT 5, https://www2.lawrence.edu/fast/GREGGJ/CMSC270/linked/iterators.html#:~:text=The%20iterator%20for%20the%20list,the%20iterator%20to%20point%20to.

package list;

public class ListIterator<T> { 
	protected ListNode<T> curNode;  /* Current node (of type ListNode) */
	
        /* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		/* TODO: Implement this method */
        this.curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy tail node? */
        if (curNode == null && curNode.next == null) {
            return true;
        } else {
            return false;
        }
        
	}
	
	public boolean isPastBeginning() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
        if (curNode == null && curNode.prev == null) {
            return true;
        } else {
            return false;
        }
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
        if(this.curNode.getData() != null ) {
            return this.curNode.getData();
        } else {
            return null;
        }

	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move forward before you do! */
                /*       (Otherwise, do not move at all) */
        if(isPastEnd()) {
            return;
        } else {
            this.curNode = this.curNode.next;
        }

	}
	
	public void moveBackward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
        if(isPastBeginning()) {
            return;
        } else {
            this.curNode = this.curNode.prev;
        }



	}
}


