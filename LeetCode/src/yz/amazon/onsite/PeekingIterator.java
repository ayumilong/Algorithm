/**
 * File Name: PeekingIterator.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:30:09 PM Apr 19, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:30:09 PM Apr 19, 2016
 */
public class PeekingIterator<E> implements Iterator<E> {
    private Iterator<E> iter;
    private E peekElement;
    private boolean hasPeeked;
	public PeekingIterator(Iterator<E> iterator) {
	    // initialize any member here.
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public E peek() {
        if(!hasPeeked){
            peekElement = iter.next();
            hasPeeked = true;
        }
        return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public E next() {
	    if(!hasPeeked){
	        return iter.next();
	    }
	    E ret = peekElement;
	    peekElement = null;
	    hasPeeked = false;
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return hasPeeked || iter.hasNext();
	}
}
