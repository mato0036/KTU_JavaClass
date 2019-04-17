package specialarray;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * Class methods
 * 
 * @author Matej Janček
 * 
 * First laboratory work in Java class. Implementing basic array operations.
 * 
 */
public class SpecialArray {
    
    
    private Coffee[] newCoffee;
    

    /**
     * 
     * Constructor
     * 
     * @param size size of new array
     * 
     */
    public SpecialArray(int size){
        
        // Catching wrong index
        try{
            
            newCoffee = new Coffee[size];
            
        } catch(NegativeArraySizeException e){
            
            System.out.println("Enter positive number!\n");
            System.exit(1);
        }
    }
    
    public SpecialArray(){
        
    }
    
    
    /**
     * 
     * Fill array by numbers from input
     * 
     */
    public void fillFromKeyboard(){
        
        Scanner keyboard = new Scanner(System.in);
    
        String origin, spiece;
        int score, yearOfHarvest;
        
        System.out.println("Enter " + newCoffee.length + " lines with origin, spiece, score and year of harvest to fill array of coffee. \nSeparate fields with spaces, each coffee to new line.");
        
        for(int i = 0; i < newCoffee.length; i++){ 
            
            // Catching wrong input by user
            try {
            
                origin = keyboard.next();
                spiece = keyboard.next();
                score = keyboard.nextInt();
                yearOfHarvest = keyboard.nextInt();
                
                Coffee c = new Coffee(origin, spiece, score, yearOfHarvest);
                newCoffee[i] = c;
                
            } catch(InputMismatchException e) {
                
                System.out.println("Wrong format of fields!");
                System.exit(1);
            }
        }                    
    }
    
    
    /**
     * 
     * Printing array
     * 
     * @return  array to print
     * 
     */
    @Override
    public String toString(){
        
        String arrayOutput = "";
        
        for(int i = 0; i < newCoffee.length; i++){
            arrayOutput += newCoffee[i] + "\n";
        }
    
        return arrayOutput;
    }
    
    
    /**
     * 
     * Add number to array to specific index
     * 
     * @param origin    country of origin of new coffee
     * @param spiece    spiece of new coffee
     * @param score     score of new coffee
     * @param yearOfHarvest year of harvesting coffee
     * @param index     index of new coffee
     * 
     */
    public void addCoffeeByIndex(String origin, String spiece, int score, int yearOfHarvest, int index){
        
        // Catching wrong index and wrong input by user
        try {
            
            newCoffee[index].setOrigin(origin);
            newCoffee[index].setSpiece(spiece);
            newCoffee[index].setYearOfHarvest(yearOfHarvest);
            newCoffee[index].setScore(score);
        
        } catch(ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Wrong index!");
            
        } catch(InputMismatchException e2){
            
            System.out.println("Wrong format of fields!");
        }
    }
   
    
    /**
     * 
     * Remove element with provided index from array
     * 
     * @param index index of element to be removed
     * 
     */
    public void removeCoffeeByIndex(int index){
        
        if(index > newCoffee.length || index < 0){
            System.out.println("Wrong index.");
            return;
        }
            
        Coffee newArray[] = new Coffee[newCoffee.length - 1];
        
        System.arraycopy(newCoffee, 0, newArray, 0, index);
        
        if(index != newCoffee.length - 1){
            System.arraycopy(newCoffee, index + 1, newArray, index, newArray.length - index);
        }
        
        newCoffee = newArray;
    }
    
    
    /**
     * 
     * Remove element with provided value from array
     * 
     * @param score coffee with this score to be removed
     * 
     * @return true on succes, false on fail
     * 
     */
    public boolean removeCoffeeByScore(int score){
        
        Coffee newArray[] = new Coffee[newCoffee.length -1];
        
        int index = linearSearch(score);
        
        if(index != -1){
            System.arraycopy(newCoffee, 0, newArray, 0, index);
                
            if(index != newCoffee.length - 1){
                System.arraycopy(newCoffee, index + 1, newArray, index, newCoffee.length - index);
            }
            newCoffee = newArray;
            return true;
            
        } else
            
            return false;        
    }
    
    
    /**
     * Searching value in array by linear search
     * 
     * @param score searched score
     * 
     * @return on success index of element with provided value
     *          on fail -1
     * 
     */
    public int linearSearch(int score){
        
        for(int i = 0; i < newCoffee.length; i++){
            if(newCoffee[i].getScore() == score){
                return i;
            }
        }
        
        return -1;
    }
    
    
    /**
     * 
     * Searching value in array by nonrecursive binary search
     * 
     * @param score searched score 
     * 
     * @return on success index of element with provided value
     *          on fail -1
     * 
     */

    public int binarySearch(int score){
        
        int left = 0;
        int right = newCoffee.length;
        int middle;
        
        mySort();
        
        while(left <= right){                  
            
            middle = (right + left) / 2;
            
            if(newCoffee[middle].getScore() == score)
                return middle;
            
            
            if(middle < score)
                left = middle + 1;
            else
                right = middle + 1;
            
        }
        
        return -1;
    }
    
    
    /**
     * 
     * Sort array
     * 
     */
    public void mySort(){
        
        Arrays.sort(newCoffee);
        
    }   
    
}
