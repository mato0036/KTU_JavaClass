package labwork2;

import java.io.*;
import java.util.*;
import javax.swing.*;


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
    
    
    List<Coffee> listCoffee = new ArrayList<>();
    
    
    /**
     * 
     * Add new coffee to list from file
     * 
     * @param file file with new data
     * @param textArea place where to output data
     * 
     */
    public void fillFromFile(File file, JTextArea textArea){
        
        Scanner sc = null;
        
        try{
            sc = new Scanner(file);            
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Scanner str = new Scanner(line);
            
            try{
                String origin = str.next();
                String spiece = str.next();
                int score = str.nextInt();
                int yearOfHarvest = str.nextInt();
                
                Coffee c = new Coffee(origin, spiece, score, yearOfHarvest);
                listCoffee.add(c);           
            }catch(InputMismatchException e){
                JOptionPane.showMessageDialog( textArea, "Wrong input");		               
            }catch(NoSuchElementException e){
                JOptionPane.showMessageDialog( textArea, "Missing data");		

            }
        }
    }
    
    /**
     * 
     * Add coffe from specific origin to new list
     * 
     * @param newList list to add coffee
     * @param origin origin of coffee added to newList
     * 
     */
    public void newCoffee(List newList, String origin){
        
        for(int i = 0; i < listCoffee.size(); i++){
            if(listCoffee.get(i).getOrigin().equals(origin)){
                newList.add(listCoffee.get(i));
            }
        }
    }
    
    
    
    /**
     * 
     * Sorting according to compareTo - by score
     * 
     */
    public void sortByScore(){
        listCoffee.sort(null);        
    }
    
    
    /**
     * 
     * Sorting according to score and year
     * 
     */
    public void sortByScoreAndYear(){
        listCoffee.sort(Coffee.byScoreAndYear);
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
        
        for(int i = 0; i < listCoffee.size(); i++){
            arrayOutput += listCoffee.get(i) + "\n";
        }
    
        return arrayOutput;
    }
    
    
    /**
     * 
     * Save list to new file
     * 
     * @param file File where list will be saved
     * @param list List to save
     * @param area TextArea to show error
     * 
     */
    public void saveFile(File file, List<Coffee> list, JTextArea area){
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(file));
            for(Coffee one : list){
                pw.println(one.toString());
            }
            pw.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(area, "Writting error");
        }
    }
    
    
}
