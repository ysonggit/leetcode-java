// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    boolean has_peeked;
    int peek_val;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    has_peeked = false;
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!has_peeked) {
            peek_val = iter.next();
            has_peeked = true;
        }
        return peek_val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(has_peeked){
	        has_peeked = false;
	        return peek_val;
	    }
	    return iter.next();
	}

	@Override
	public boolean hasNext() {
	    return has_peeked || iter.hasNext();
	}
}
