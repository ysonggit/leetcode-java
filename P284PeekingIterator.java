// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    boolean has_peeked;
    Integer peek_val;
    Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    has_peeked = false;
	    peek_val = null;
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!has_peeked){
            has_peeked = true;
            peek_val = iter.next();
        }
        return peek_val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!has_peeked) return iter.next();
	    Integer res = peek_val;
	    peek_val = null;
	    has_peeked = false;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return has_peeked || iter.hasNext();
	}
}
