package specialarray;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Class for testing methods
 * 
 * @author Matej Janček
 * 
 */
public class testClass {
    
    public static void main(String[] args){
        
        testClass test = new testClass();
        System.out.println("------------------ Start of test.   ------------------");
        test.testMyProject();
        System.out.println("------------------ End of test. ------------------");
    }
    
    /**
     * 
     * Test class with output for user
     * 
     */
    private void testMyProject(){
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter number of array elements:");
        SpecialArray testArray = new SpecialArray(keyboard.nextInt());
        
        testArray.fillFromKeyboard();
        
        printArray(testArray);
        
        
        System.out.println("Testing adding element to array by index.");
        
        System.out.println("Enter fields and index to add coffee to specific position in array:");
        testArray.addCoffeeByIndex(keyboard.next(),keyboard.next(), keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt());
        
        printArray(testArray);
        
        
        System.out.println("Testing removing element from array on specific position");
        
        System.out.println("Enter index to remove number from specific position in array:");
        testArray.removeCoffeeByIndex(keyboard.nextInt());
        
        printArray(testArray);
        
        
        System.out.println("Testing removing element from array with specific score.");
        
        System.out.println("Enter score to remove coffee with this score from array:");

        // Catching wrong input by user
        try{
                  
            if(testArray.removeCoffeeByScore(keyboard.nextInt()))
                printArray(testArray);
            else
                System.out.println("Coffee with provided score is not in array." + System.lineSeparator());
            
        } catch(InputMismatchException e){
            
            System.out.println("Enter number!");
            
        }
        
        
        System.out.println("Testing linear seraching in array.");
        
        System.out.println("Enter score to find coffee with this score in array:");
        
        int index;
        
        // Catching wrong input by user
        try{
            
            index = testArray.linearSearch(keyboard.nextInt());     // Working: existing score

            if(index != -1)
                System.out.println("Coffee with provided score is at index " + index);
            else
                System.out.println("Coffee with provided score is not in array.");        

        } catch(InputMismatchException e){
            
            System.out.println("Enter number!");
            
        }
        

        
        
        System.out.println("Testing binary search in array.");
        
        System.out.println("Enter score to find coffee with this score in array:");
  
        // Catching wrong input by user
        try{
        
            index = testArray.binarySearch(keyboard.nextInt());
            if(index != -1)
                System.out.println("Coffee with provided score is at index: " + index);
            else
                System.out.println("Coffee with provided score is not in array.");
        
        } catch(InputMismatchException e){
            System.out.println("Enter number!");
        }

        
        System.out.println("Testing sorting array.");
        
        System.out.println("Array before sorting:" + System.lineSeparator() + testArray);
        testArray.mySort();
        System.out.println("Array after sorting:" + System.lineSeparator() + testArray);  
        
    }
    
    private void printArray(SpecialArray myArray){
        
        System.out.println("Elements of array:" + System.lineSeparator() + myArray + System.lineSeparator());
        
    }
    
}
