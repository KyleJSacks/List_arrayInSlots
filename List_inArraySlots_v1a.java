public class List_inArraySlots_v1a{
    // ===========================================================
    // FIELDS
    private int[] refArray;
    private int filledElements;

    private static final int INITIAL_CAPACITY = 10;

    public List_inArraySlots_v1a(){
        this.refArray = new int[INITIAL_CAPACITY];
        filledElements = 0;
    }

    // ===========================================================
    // CONSTRUCTORS

    /*
    To instantiate an array according to an existing array
    precondition: existing array does not have null elements
    */
    public List_inArraySlots_v1a(int[] existingArray){
        this.refArray = existingArray;
        filledElements = existingArray.length;
    }


    // ===========================================================
    // METHODS from v0

    public int size(){
    return filledElements;
    }

    /**
    @return a string representation of this list,
    in [a,b,c,] format
    */
    public String toString() {
        String ans = "[";
        for(int index = 0; index<filledElements; index++){
            ans += refArray[index] + ",";
        }

        ans += "]";
        return ans;
    }


    /**
    Appends @value to the end of this list.

    @return true, in keeping with conventions yet to be discussed
    */
    public boolean add( int value) {
        // first check if the list is already full
        if (refArray.length == filledElements)
            expand(); // if so, expand the array

        // then add the value
        refArray[filledElements] = value;
        filledElements ++;

        return true;
    }


    /**
    Double the capacity of the List_inArraySlots,
    preserving existing data
    */
    private void expand() {
        
        int[] extended = new int[refArray.length * 2];         // instantiate an array with twice the capacity
        for(int index=0; index < filledElements;index++){      // copy over each non-null value
            extended[index] = refArray[index];
        }
        refArray = extended;                                   // replace the reference held in refArray to the new array

      }

    // ===========================================================
    // METHODS from v1

    /**
    accessor
    @return element @index from this list
    precondition: @index is within the bounds of the array.
    (Having warned the user about this precondition,
    you should NOT complicate your code to check
    whether user violated the condition.)
     */
    public int get( int index ) {
        return refArray[index];
    }

    /**
    Store et value at @index to @newValue

    @return old value at @index
    @precondition: @index is within the bounds of this list.
    */
    public int set( int index, int newValue ) {
        // store old value in local variable to return later
        int oldValue = refArray[index];

        // assign new value
        refArray[index] = newValue;

        return oldValue;
    }
    
    
    /**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
     public int remove( int index) {
        int removed = refArray[index];

        for( ; index < filledElements; index++){
            // set the element to the value of the element to the left
            refArray[index] = refArray[index + 1];
        }
        
        // update number of elements
        filledElements--;
        
        return removed;
     }


    /**
    Insert @value at position @index in this list.

    Shift the element currently at that position (if any)
    and any subsequent elements to the right
    (that is, increase the index associated with each).
    */
    public void add( int index, int value) {

        // keep track of element being moved and element that will be replaced
        int elemReplaced = 0;
        int elemShifting = refArray[index];
        
        //expand if necessary
        if (filledElements + 1 > refArray.length) expand();
              
        // set the new value to given index
        refArray[index] = value;   

        // update filledElements 
        filledElements++;

        // shift the rest of the elements by...
        for ( ++index; index < filledElements; index++){
            //  keep track of the element that will be replaced
            elemReplaced = refArray[index];

            // now replace with the element you were shifting
            refArray[index] = elemShifting;

            //update the element you are elemShifting
            elemShifting = elemReplaced;
        }
        
        
    }

}
