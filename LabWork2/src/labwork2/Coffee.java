/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labwork2;

import java.util.Comparator;

/**
 * 
 * Class for Coffee object
 * Class implements comparable
 *
 * @author mjancek
 */
public class Coffee implements Comparable<Coffee>{
        
        private String origin;
        private String spiece;
        private int score;
        private int yearOfHarvest;
        
        
        public Coffee(){
            
        }
       
        /**
        * 
        * Constructor
        * 
        * @param origin Country of origin
        * @param spiece Name of spiece
        * @param score  SCA score
        * @param yearOfHarvest  Year of coffee harvest
        * 
        */
        public Coffee(String origin, String spiece, int score, int yearOfHarvest){
        
            this.origin = origin;
            this.spiece = spiece;
            this.score = score;
            this.yearOfHarvest = yearOfHarvest;
        
        }
        
        /**
         * 
         * Get field Origin
         * 
         * @return origin
         * 
         */
        public String getOrigin(){
            return origin;
        }
        
        
        /**
         * 
         * Get field Spiece
         * 
         * @return spiece
         * 
         */
        public String getSpiece(){
            return spiece;
        }
        
        
        /**
         * 
         * Get field Score
         * 
         * @return score
         * 
         */
        public int getScore(){
            return score;
        }
        
        
        /**
         * 
         * Get field YearOfHarvest
         * 
         * @return yearOfHarvest
         * 
         */
        public int getYearOfHarvest(){
            return yearOfHarvest;
        }
        
        /**
         * 
         * Set field origin
         * 
         * @param origin country to be new origin
         * 
         */
        public void setOrigin(String origin){
            this.origin = origin;
        }
        
        
        /**
         * 
         * Set field spiece
         * 
         * @param spiece value to be new spiece
         * 
         */
        public void setSpiece(String spiece){
            this.spiece = spiece;
        }
        
        
        /**
         * 
         * Set field score
         * 
         * @param score number 0-100 to be new score
         * 
         */
        public void setScore(int score){
            this.score = score;
        }
        
        
        /**
         * 
         * Set field year of harvest
         * 
         * @param yearOfHarvest Year when was coffee harvested
         * 
         */
        public void setYearOfHarvest(int yearOfHarvest){
            this.yearOfHarvest = yearOfHarvest;
        }
        
        /**
         * 
         * Declare sorting by score
         * 
         * @param other Coffee to be compared
         * 
         * @return 0/1/-1
         */
        @Override
        public int compareTo(Coffee other){
            int scoreToCompare = other.getScore();
            if(score > scoreToCompare)
                return -1;
            if(score < scoreToCompare)
                return 1;
            return 0;
                        
        }
        
        
        /**
         * 
         * Override sorting by score and year
         * 
         */
        public final static Comparator<Coffee> byScoreAndYear = new Comparator<Coffee>() {
            /**
             * 
             * Sorting of array
             * 
             * @param c1 coffee to be compared
             * @param c2 coffee to be compared
             * 
             * @return 1/-1/0
             * 
             */
            @Override    
            public int compare(Coffee c1, Coffee c2){
                    int result = c1.compareTo(c2);
                    if(result != 0)
                        return result;
                    if(c1.getYearOfHarvest() > c2.getYearOfHarvest())
                        return -1;
                    if(c1.getYearOfHarvest() < c2.getYearOfHarvest())
                        return 1;
                    return 0;
                }
        };
        
        
        /**
         * 
         * Setting own format of array printing
         * 
         * @return array in string
         * 
         */
        @Override
        public String toString(){
            return String.format("%-10s %-8s %3d %4d", origin, spiece, score, yearOfHarvest);
        }
                
        
        
        
    }

