/**
 Test list features.
 */
public class UserOfList_v1 {
    public static void main( String[] args ) {
        List_inArraySlots_v1 list = new List_inArraySlots_v1();

         System.out.println( "number of elements: " + list.size() );
         System.out.println( "empty list:" + list);

         /* Populate the list with elements, but with a small enough
            number that we expect no invocation of expand().
        */
         int i = 0;
         for( ; i < 5; i++ ) {
             list.add( -i); // differs from index, but similar
             System.out.println( "number of elements: " + list.size() );
        }
         System.out.println("initial population of " + list.size() + " elements:");
         System.out.println( list);

        // Add enough elements that expansion is expected
        for( ; i < 15; i++ ) {

            if( i == 10) System.out.println( "expansion expected");

            list.add( -i);
            System.out.println( "number of elements: " + list.size() );
        }
        System.out.println("result of second population: " + list.size() + " elements:");
        System.out.println( list);

        // Trust no one.
        for( ; i < 35; i++ )
            list.add( -i);
        System.out.println("after second expansion: " + list.size() + " elements:");
        System.out.println( list);

        // --------- end of "code that worked in v0" ---------

        
        // test accessor
        System.out.println( "sample elements from list:");
        for( int elemIndex = 1; elemIndex < list.size(); elemIndex *= 2 ) {
            System.out.println( "element " + elemIndex + ": "
                              + list.get( elemIndex)
                              );
        }


        // test set
        setTest(  8, list);
        setTest( 16, list);

        // test remove
        System.out.println( "remove " 
                            + list.remove(8)
                            + ", resulting in "
                            + list.size()
                            + " elements:\n"
                            + list
                            + System.lineSeparator()
                          );


        // test add
        addAtTest( 0, 29, list); // beginning of the list
        System.out.println();

        addAtTest( list.size(), 17, list); // end of the list using the new add method
        System.out.println();

        addAtTest( 2, 19, list); // middle of a small list
        System.out.println();

        addAtTest( 2, 23, list); // not quite
        System.out.println();
        
        addAtTest( 0, 0, list); // almost there
        System.out.println();
        
        addAtTest( 0, 10, list); // filled the list
        System.out.println();

        addAtTest( 0, 100, list); // force an expansion or you get an error
        System.out.println();


    }


    /**
      Test the set() method, reporting and
      changing the value at index @modifyAt.
     */
     private static void setTest( int modifyAt, List_inArraySlots_v1 list
                              ) {
        System.out.println(
            "changed element " + modifyAt + " from "
          + list.set( modifyAt, modifyAt + 1000) + " to "
          + list.get( modifyAt)
          );
        }

    /**
    Test the 2-argument add( index, value) method.
    */
    private static void addAtTest( int addAt
                             , int value
                             , List_inArraySlots_v1 list
                             ) {
        System.out.print( "insert " 
                        + value
                        + " at position " 
                        + addAt);
                        
        list.add(addAt, value);
        
        System.out.print(", resulting in "  
                        + list.size() 
                        + " elements:"
                        + System.lineSeparator()
                        + list
                        + System.lineSeparator()
        );
    }
}