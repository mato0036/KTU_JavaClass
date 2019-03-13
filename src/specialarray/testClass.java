/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialarray;

import java.util.Scanner;

/**
 *
 * @author mjancek
 */
public class testClass {
    
    public static void main(String[] args){
        
        testClass test = new testClass();
        test.testMyProject();
        System.out.println("--------- End of test. ---------");
    }
    
    private void testMyProject(){
        
        System.out.println("--------- Start of test. ---------");
        
        SpecialArray testArray = new SpecialArray();
        
        testArray.fillFromKeyboard();
        
        System.out.println("Your array: " + testArray);
        
        
        
        
        
        
    }
    
}
