public class LinkedSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
	private ListInterface<T> list;
	
	public LinkedSortedList(){
		list = new LList<>();
	}

	public void add(T newEntry) {
		int newPosition = Math.abs(getPosition(newEntry));
		list.add(newPosition, newEntry);
	}
	
	

	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);
		if(position > 0){
			list.remove(position);
			result = true;
		}
		return result;
	}

	public int getPosition(T anEntry) {
		int position = 1;
		int length = list.getLength();
		 
		while((position <= length) && (anEntry.compareTo(list.getEntry(position)) != 0)){
			position++;
		}
		if((position > length ) || (anEntry.compareTo(list.getEntry(position)) != 0)){
			position = -position;
		}
		return position;
	}

	public T getEntry(int givenPosition) {
		return list.getEntry(givenPosition);
	}

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}
	public T remove(int givenPosition) {
		return list.remove(givenPosition);
	}
	public void clear() {
		list.clear();
	}

	public int getLength() {
		return list.getLength();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public T[] toArray() {
		return list.toArray();
	}
	

}
