/*
In the name of Allah, the Gracious, the Merciful
 */
package integersettest;

/**
 *
 * @author ibrahim
 * @reviewer Hossam
 */
public class IntegerSet {

    private boolean[] set = new boolean[101];//automatically intialized to false "empty set"
    // Test1: To make code maintainable, efficient, and readable you should have declared '101' as a constant. For readability, These numbers are known as magic numbers. When someone else reads these numbers they do not make sense for him. However, if you declared them as constants they would have names that reflect their purpose. For Efficiency, I see that you have used the length of the set many times in the code. Each time you invoke the function length() that takes some instructions to finish. However, if this number was declared as a constant you would not need invoke this function. For maintainability, if you used this number many times in the code directly and you wanted to change it you need to go through all of them and make update. However if it has been declared as a constant you would need to update it once.
    public IntegerSet() {

    }

    public IntegerSet(int... number) {	//Test2: Make sure that your variables names reflect their purpose. Here a good name is "numbers"
        for(int i=0; i<number.length;i++){
            try{
                set[number[i]] = true;	//Test3: Great that you take care of indentation(Ex: spaces before and after assignment opeator). This 						//makes code much readable. Follow this good practice in for loop line. It should be: 
					//for(int i = 0; i < number.length; i++)
            }
            catch(ArrayIndexOutOfBoundsException e){	//Test4: Really greate that you caught this exception. I really liked it. But you  								//should output a much readable message for user to tell him not to enter values  								//larger than 100 rather than outputing the exeption method. It does not make sense 								//for users
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
            System.out.println("Number must be in range 0 - 100 ");	//Test5: Greate you outputed a readable message, no need for previous 										//line
        }
    }
    
    public void deleteElement(int element){
        try{
            set[element] = false;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("Number must be in range 0 - 100 ");	//Test6: same as test4
        }
	//Test7: I think you should make sure first that this number has been indeed inserted before by checking if(set[element] == true)
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
        for(int i=0;i<set1.set.length;i++){	//Test8: the same as test3
            if((set1.set[i] == false) && (set2.set[i] == false));//check if the element does not exist in both sets
            else
                newSet.insertElement(i);//if it exists in one set at least ==> insert it.
	    //Test9: This if-else block is useless. with no else part, a much readable one is this:
	    //if(set1.set[i] == true || set2.set[i] == true)
	    //    newSet.insertElement();
	
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
        for(int i=0;i<set1.set.length;i++){	//test10: the same as test3
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
        for(int i=0; i<set1.set.length; i++){	//Test11: the same as test3
            if(set1.set[i] != set2.set[i])
                return false;
        }
        return true;
	//Test12: Greate implementation ya man
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
        for(int i=0; i<set.length; i++){	//Test13: the same as test3
            if(set[i] == true){
                string += i + " ";
                check ++;
            }
        }
        //Test14: If any time you wanna make a String object that you will maintain through a loop, it is very efficient to use
	//StringBuilder object. That is because String class is immutable in the sense that if you created an object of it, each time you
	//change the string value the Java VM destroys this object totally and creates a new one.	
        if(check == 0 ) //it means htat all element of set are false (empty set)
            string = "---";
        
        return string;
    }
}
