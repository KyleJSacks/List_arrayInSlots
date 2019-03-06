public class List_inArraySlots{
	
	private int[] refArray;
	private int filledElements;

	public List_inArraySlots(){
		this.refArray = new int[10];
		filledElements = 0;
	}

	public List_inArraySlots(int[] a){
		this.refArray = a;
		filledElements = a.length;
	}
	
	public int size(){
		return filledElements;
	}
    /** 
       @return a string representation of this list,
       in [a,b,c,] format
      */ 
     	public String toString() {
     	    	String ans = "[";
		for(int index=0;index<filledElements;index++){
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
	refArray[filledElements] = value;
	filledElements ++;
	return true;
      }


    /** 
      Double the capacity of the List_inArraySlots, 
      preserving existing data
     */
      private void expand() {
         System.out.println( "expand... (for debugging)");
         int[] extended = new int[filledElements * 2];
	 for(int index=0; index < filledElements;index++){
		extended[index] = refArray[index];
	 }
	 refArray = extended;
		
      }
}
	
	

		
