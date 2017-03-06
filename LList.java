public class LList<T> implements ListInterface<T> {
	private Node firstNode;
	private Node lastNode;
	private int numberOfEntries = 0;
	
	private class Node{
		private T data; 
		private Node next;
		
		private Node(T data){
			this(data, null);
		}
		private Node(T data, Node nextNode){
			this.data = data;
			next= nextNode;
		}
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if(isEmpty())
		   firstNode = newNode;
		else{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.next = newNode;
		}
		numberOfEntries++;
		
	}

	public void add(int newPosition, T newEntry) {
		if((newPosition >= 1) && (newPosition <= numberOfEntries)){
		    Node newNode = new Node(newEntry);
		    if(newPosition ==1){
		    	newNode.next = firstNode;
		    	firstNode = newNode;
		    }
		    else{
		    	Node nodeBefore = getNodeAt(newPosition -1);
		    	Node nodeAfter = nodeBefore.next;
		    	newNode.next = nodeAfter;
		    	nodeBefore.next = newNode;
		    	
		    }
		    numberOfEntries++;

		}
		else
			throw new IndexOutOfBoundsException(
		    		"illegal position given");
	}

	public T remove(int givenPosition) {
		T result = null;
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			if(givenPosition == 1){
				result = firstNode.data;
				firstNode = firstNode.next;
			}
			else {
				Node nodeBefore = getNodeAt(givenPosition -1);
				Node nodeToRemove = nodeBefore.next;
				result = nodeToRemove.data;
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter;
			}
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException(
		    		"illegal position given");

	}

	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
		
	}

	public T replace(int givenPosition, T newEntry) {
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.data;
			desiredNode.data = newEntry;
			return originalEntry;
			
		}
		else
			throw new IndexOutOfBoundsException(
		    		"illegal position given");
	}

	public T getEntry(int givenPosition) {
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
			assert !isEmpty();
			return getNodeAt(givenPosition).data;
		}
		else
			throw new IndexOutOfBoundsException(
		    		"illegal position given");
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] list = (T[])new Object[numberOfEntries];
		int index = 0;
		Node temp = firstNode;
		while(index < numberOfEntries && temp != null){
			list[index] = temp.data;
			temp = temp.next;
			index++;
		}
		return list;
	}

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode= firstNode;
		while(!found && currentNode!= null){
			if(anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return false;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		
		return numberOfEntries == 0;
	}
	private Node getNodeAt(int getPosition){
		assert (1 <= getPosition && getPosition <= numberOfEntries);
		Node temp = firstNode;
		int index = 1;
		while(index < getPosition){
			temp = temp.next;
			index++;
		}
		
		return temp;
	}

}
