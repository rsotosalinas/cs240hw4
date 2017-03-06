public class AList<T> implements ListInterface<T> {
	private T[] list;
	private int numberOfEntries;
	boolean initialized = false;
	private static final int CAPACITY = 10;
	
	public AList(){
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[CAPACITY];
		list = temp;
		initialized = true;
		numberOfEntries = 0;
		
		
	}	

	public void add(T newEntry) {
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
	}

	public void add(int newPosition, T newEntry) {
		if((newPosition >= 1) && ( newPosition <= numberOfEntries + 1 )){
			if(newPosition <= numberOfEntries){
			   int newIndex = newPosition;
			   int lastIndex = numberOfEntries;
			   for(int index = lastIndex ; index >= newIndex ; index--){
				   list[index + 1]  = list[index ];
				
			   }
			}
			list[newPosition] = newEntry;
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException(
			"Given postion to the add's new entry does is out of bounds");
	}

	public T remove(int givenPosition) {
		if((givenPosition >= 1) && ( givenPosition <= numberOfEntries + 1 )){
			assert !isEmpty();
			T result = list[givenPosition];
			if(givenPosition < numberOfEntries){
				int removeIndex = givenPosition;
				int lastIndex = numberOfEntries;
				for(int index = removeIndex; index < lastIndex; index++)
					list[index] = list[index +1];
			}
				numberOfEntries--;
				return result;
			
			
		}
		else 
			throw new IndexOutOfBoundsException(
					"illegal position given to be removed");

	}
	public void clear() {
		if( !isEmpty()){
		while(!isEmpty()){
			remove(numberOfEntries +1);
			numberOfEntries--;
		}
			
	}
	}

	public T replace(int givenPosition, T newEntry) {
		if((givenPosition >= 1) && ( givenPosition <= numberOfEntries + 1 )){
			T original = list[givenPosition];
			list[givenPosition] = newEntry;
			return original;
			
		}
		else 
			throw new IndexOutOfBoundsException(
					"illegal position given");

		
	}

	public T getEntry(int givenPosition) {
		if((givenPosition >= 1) && ( givenPosition <= numberOfEntries + 1 )){
			assert !isEmpty();
			return list[givenPosition];
		}
		else 
			throw new IndexOutOfBoundsException(
					"illegal position given");

	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int i = 0; i < numberOfEntries; i++){
			result[i] = list[numberOfEntries + 1];
		}
		return result;
	}

	public boolean contains(T anEntry) {
		boolean found  = false;
		int index = 1;
		while(!found && index <= numberOfEntries){
			if(anEntry.equals(list[index]))
				found = true;
			index++;
		}
		
		return found;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	

}
