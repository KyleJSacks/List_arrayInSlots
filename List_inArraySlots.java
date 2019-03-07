public class List_inArraySlots{
	// ===========================================================
	// FIELDS
	private int[] refArray;
	private int filledElements;

	private static final int INITIAL_CAPACITY = 10; 

	public List_inArraySlots(){
		this.refArray = new int[INITIAL_CAPACITY];
		filledElements = 0;
	}

	// ===========================================================
	// CONSTRUCTORS
	
	/* 
	To instantiate an array according to an existing array
	precondition: existing array does not have null elements
	*/
	public List_inArraySlots(int[] existingArray){
		this.refArray = existingArray;
		filledElements = existingArray.length;
	}
	
	
	// ===========================================================
	// METHODS
	
	public int size(){
		return filledElements;
  	}

	public int getValue(int index){
		return refArray[index];
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
}
