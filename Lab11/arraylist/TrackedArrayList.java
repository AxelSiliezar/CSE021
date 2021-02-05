package arraylist;

import java.util.ArrayList;

// the symbol 'CLASS' will stand for the class of elements that
// the ArrayList was declared with
public class TrackedArrayList<CLASS> extends ArrayList<CLASS> {



	private int maxSize = 0;
	public int maxSizeSoFar() { return maxSize; }



	//This is how you would override the remove method
	@Override
	public boolean remove(Object element) {

		return super.remove(element);
	}


	// This is how you override the add method.  We can use the
	// symbol 'CLASS' because we used it above, when we defined
	// TrackedArrayList
	@Override
	public boolean add(CLASS element) {
		// inside, you can use 'element' as necessary
		boolean ret = super.add(element);
		if (maxSize < super.size()) maxSize++;
		return ret;
	}

}
