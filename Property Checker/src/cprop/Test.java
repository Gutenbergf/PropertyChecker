/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprop;



import static cprop.Conjunct.receiveConjunct;
import static cprop.Conjunct.splitString;
import static cprop.Relation.MatrixOrderedPair;
import static cprop.Relation.createMatrix;
import static cprop.Relation.fillsMatrix;
import static cprop.Relation.showPairsRelation;
import static cprop.Relation.showResults;

/**
 *
 * @author Gutenberg
 */
public class Test {
    public static void main(String[] args) {
        receiveConjunct();        
        createMatrix();
        fillsMatrix();        
        showPairsRelation();     
        
        showResults();
    }
}
