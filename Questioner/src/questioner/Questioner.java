/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questioner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mfaux02
 */
public class Questioner {
    static Map<String, String> key = new HashMap<>();   //Key HashMap
    static Map<String, String> ans = new HashMap<>();   //Answer HashMap
    static int numCorrect = 0;                          //Numbercorrect
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");
        sendParagraphs();   //Sending paragraphs to user
        getAnswers();       //getting answers from user
        checkAnswers();     //checking answers
        System.out.println("Correct Answers: " + numCorrect);//sending number of correct answers
        
    }//close main
    
    public static void sendParagraphs(){
        String p1 = "Dogs:Cats\nPigs:Donkeys\nCows:Spiders";
        key.put("Dogs", "Cats");
        key.put("Pigs", "Donkeys");
        key.put("Cows", "Spiders");
        System.out.println(p1);
    }//close sendParagraphs
    
    public static void getAnswers(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Press any key + enter.");
        scan.next();
        for(int i = 0; i < 100; i++){
            System.out.println("");
        }//for loop to make whitespace
        
        Set<String> keys = key.keySet();        //casting map keys to a set
        Iterator<String> it = keys.iterator();  //casting set of map key to an iterator
        String curKey;                          //Current map key
        String answer;                          //answer from user
        
        while(it.hasNext()){
            curKey = it.next();                 //getting next map key
            System.out.print(curKey + ":");     //asking for answer from user
            answer = scan.next();               //getting answer from user
            ans.put(curKey, answer);            //putting answer in ans map
        }//while loop getting all answers from user
    }//close getAnswers
    
    public static int checkAnswers(){
        Set<String> keys = key.keySet();        //casting map keys to a set
        Iterator<String> it = keys.iterator();  //casting set of map key to an iterator
        String curKey;                          //Current map key
        
        
        while(it.hasNext()){
            curKey = it.next();                 //current key
            if(key.get(curKey).equals(ans.get(curKey))){
                numCorrect++;                   //increment number correct
            }//checking if answer is correct
        }//while loop checking all answers
        return numCorrect;
    }//close CheckAnswers
}//close class
