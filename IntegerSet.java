/*
In the name of Allah, the Gracious, the Merciful
 */
package integersettest;

/**
 *
 * @author ibrahim
 */
public class IntegerSet {

    private boolean[] set = new boolean[101];//automatically intialized to false "empty set"

    public IntegerSet() {

    }

    public IntegerSet(int... number) {
        for(int i=0; i<number.length;i++){
            try{
                set[number[i]] = true; 
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    public void insertElement(int element){
        try{
            set[element] = true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("Number must be in range 0 - 100 ");
        }
    }
    
    public void deleteElement(int element){
        try{
            set[element] = false;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("Number must be in range 0 - 100 ");
        }
    }
    
    /**
     * 
     * @param set1
     * @param set2
     * @return unioned Integerset object of the two Integerset objects
     * (i.e., an element of the new set’s array is set to true if that element is true
     * in either or both of the existing sets—otherwise, the new set’s element is set to false)
     */
    public static IntegerSet union(IntegerSet set1, IntegerSet set2){
        IntegerSet newSet = new IntegerSet();
        for(int i=0;i<set1.set.length;i++){
            if((set1.set[i] == false) && (set2.set[i] == false));//check if the element does not exist in both sets
            else
                newSet.insertElement(i);//if it exists in one set at least ==> insert it.
        }
        return newSet;
    }
    
    /**
     * 
     * @param set1
     * @param set2
     * @return intersectioned Integerset object of the two Integerset objects
     * (i.e.,an element of the new set’s array is set to false if that element is false in either or both of the
     * existing sets—otherwise, the new set’s element is set to true)
     */
    public static IntegerSet intersection(IntegerSet set1, IntegerSet set2){
        IntegerSet newSet = new IntegerSet();
        for(int i=0;i<set1.set.length;i++){
            if((set1.set[i] == true) && (set2.set[i] == true))//check if the element existes in both sets
                newSet.insertElement(i);
        }
        return newSet;
    }
    
    /**
     * 
     * @param set1
     * @param set2
     * @return ture if they're equal, false if they're not equal
     */
    public boolean isEqual(IntegerSet set1, IntegerSet set2){
        for(int i=0; i<set1.set.length; i++){
            if(set1.set[i] != set2.set[i])
                return false;
        }
        return true;
    }
    
    /**
     * 
     * @return a string represents the set.
     * if the set is empty (it returns ---)
     * else it returns the numbers at the set.
     */
    public String toString(){
        String string = "";
        short check = 0;
        for(int i=0; i<set.length; i++){
            if(set[i] == true){
                string += i + " ";
                check ++;
            }
        }
        
        if(check == 0 ) //it means htat all element of set are false (empty set)
            string = "---";
        
        return string;
    }
}
