/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialarray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 *
 * @author mjancek
 */
public class SpecialArray {

    private int[] myArray;
    
    public SpecialArray(int count){
        
        myArray = new int[count];
    }
    
    
    public void fillFromKeyboard(int number){
        
        Scanner keyboard = new  Scanner(System.in);
    
        System.out.println("Enter " + myArray.length + " numbers to fill array:");
        
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = keyboard.nextInt();
        }
    }
    
    
    @Override
    public String toString(){
        
        String arrayOutput = new String();
        
        for(int i = 0; i < myArray.length; i++){
            arrayOutput += String.format("%d ", myArray[i]);
        }
    
        return arrayOutput;
    }
    
    
    public void addNumberByIndex(int number, int index){
        
        try {
            myArray[index] = number;
        
        } catch(InputMismatchException e) {
            System.out.println("Wrong number or index.");
        }
    }
   
    
    public void removeElementByIndex(int index){
        
        int newArray[] = new int[myArray.length - 1];
        
        System.arraycopy(myArray, 0, newArray, 0, index);
        
        if(index != myArray.length - 1){
            System.arraycopy(myArray, index + 1, newArray, index, newArray.length - index);
        }
        
        myArray = newArray;
    }
    
    
    public boolean removeEmelentByValue(int value){
        
        int newArray[] = new int[myArray.length -1];
        
        int index = linearSearch(value);
        
        if(index != -1){
            System.arraycopy(myArray, 0, newArray, 0, index);
                
            if(index != myArray.length - 1){
                System.arraycopy(myArray, index + 1, newArray, index, myArray.length - index);
            }
            myArray = newArray;
            return true;
        } else
            return false;

           
    }
    
    public int linearSearch(int value){
        
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] == value){
                return i;
            }
        }
        
        return -1;
    }
    
    
    public int binarySearch(int value, int left, int right){
        
        if(right >= left){
            
            mySort();
            
            int middle = (right + left) / 2;
            
            if(myArray[middle] == value)
                return middle;
            
            
            if(middle < value)
                return binarySearch(value, middle + 1, right);
            else
                return binarySearch(value, left, middle + 1);
            
        }
        
        return -1;
    }
    
    
    public void mySort(){
        
        Arrays.sort(myArray);
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
