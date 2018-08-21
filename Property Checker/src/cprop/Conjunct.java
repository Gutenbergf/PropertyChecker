/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprop;

import java.util.Scanner;

/**
 *
 * @author Gutenberg
 */
public class Conjunct {
    static int conjunctA[];
    static int conjunctB[];
    
    public static void receiveConjunct(){
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Conjunct A: ");        
        conjunctA = splitString( reader.nextLine() );
        
        System.out.print("Conjunct B: ");        
        conjunctB = splitString( reader.nextLine() );
    }
    
    public static int[] splitString( String str ) {
        
        String aux[] = str.split( "," );
        int elem[] = new int[aux.length];
        
        for( int i = 0 ; i < aux.length ; i++ ) {
            elem[i] = Integer.parseInt( String.valueOf( aux[i] ) );
        }
        
        return elem;
    }
    
}
