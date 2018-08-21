/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprop;

import static cprop.Conjunct.conjunctA;
import static cprop.Conjunct.conjunctB;

/**
 *
 * @author Gutenberg
 */
public class Relation {
    static boolean[][] MatrixOrderedPair;
    
   
    //Control Methods
    
    public static void createMatrix(){
        int biggerA = getBiggerValueConjunct(conjunctA);
        int biggerB = getBiggerValueConjunct(conjunctB);
        if(biggerA>biggerB){
            MatrixOrderedPair = new boolean[biggerA][biggerA];
        }else{
           MatrixOrderedPair = new boolean[biggerB][biggerB]; 
        }
        
        
    }
    
    public static void fillsMatrix( ) {
                
        for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) {            
            for ( int j = 0 ; j < MatrixOrderedPair.length ; j++ ) {               
                
                if(i<=j && xContainedInA(i) && yContainedInB(j)){ // if the condition is met i<y, then belongs to relationship xRy
                    MatrixOrderedPair[i][j]=true;  
                }else{// Otherwise, does not belong
                    MatrixOrderedPair[i][j]=false;
                }                              
           }
        }
    }
    
    public static boolean xContainedInA(int x){
        for(int i=0;i<conjunctA.length;i++){
            if(x==conjunctA[i]){
                return true;
            }
        }
        return false;
    }
    
    public static boolean yContainedInB(int y){
        for(int i=0;i<conjunctA.length;i++){
            if(y==conjunctA[i]){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    public static int getBiggerValueConjunct(int[] conjunct){
        int bigger =0;
        for(int i=1;i<conjunct.length;i++){
            if(conjunct[i-1]>conjunct[i]){
                bigger = conjunct[i-1];
            }else{
                bigger=conjunct[i];
            }
        }
        return bigger;
    }
    //Printing Methods
    
    
    public static void printMatrix(){
        for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) {   
            for ( int j = 0 ; j < MatrixOrderedPair.length ; j++ ) { 
                System.out.println("Pair: ("+i+","+j+")= "+MatrixOrderedPair[i][j] + " | ");               
                                             
           }
        }
    }
    
    
    public static void showPairsRelation(){
        System.out.println("Conjunct of Orderly Pairs of xRy Relation");
        for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) {   
            for ( int j = 0 ; j < MatrixOrderedPair.length ; j++ ) { 
                if(MatrixOrderedPair[i][j]==true){
                    System.out.println("("+i+","+j+")"); 
                }
                              
                                             
           }
        }
    }
    
    public static void showResults(){
        System.out.println("========== Results ==============");
        System.out.println("Reflexiva: "+isReflexiva());
        System.out.println("Sim�trica: "+isSimetrica());
        System.out.println("Transitiva: "+isTransitiva());
    }
    
    //Verification Methods
    
    public static boolean isReflexiva(){
        for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) { 
            if(MatrixOrderedPair[i][i]==false){
                
                return false;
            }                                                             
        }
        return true;
    }
    
    public static boolean isSimetrica(){
    	boolean result = true;
    	for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) {            
            for ( int j = 0 ; j < MatrixOrderedPair[0].length ; j++ ) {               
                
                if(i!=j){
                	if(MatrixOrderedPair[i][j]==true){
                		if(MatrixOrderedPair[j][i]==false){                			
                			result = false;
                			break;
                		}
                	}
                }                          
           }
        }
    	if(result==false){
    		return false; // Não É simétrica
    	}else{
    		return true; // É simétrica
    	}
    	
    }
    
    public static boolean isTransitiva() {
            
        for ( int i = 0 ; i < MatrixOrderedPair.length ; i++ ) {
            for  ( int j = 0 ; j < MatrixOrderedPair.length ; j++ ) {
                if ( (j+1) < MatrixOrderedPair.length ) {
                    if ( MatrixOrderedPair[i][j] == true && MatrixOrderedPair[j][j+1] == true ) { // x < y
                        if ( MatrixOrderedPair[i][j+1] == true ) { // y < z
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
