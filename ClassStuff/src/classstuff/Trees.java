/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classstuff;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Mafau
 */
public class Trees {
    static LinkedList<HashMap<String,String>> maps;
    static final int HASH_PASS = 730288509;//"Password1234" in Hash
    static final String LOCKED ="Locked";
    static final String UNLOCKED ="Unlocked";
    static int selected;
    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        maps = new LinkedList<>();//initializing LinkedList
        setupMars();//generating mars map
        System.out.println("Welcome!");
        select();
        menu();
    }
    
    public static void setupMars(){
        maps.add(new HashMap<>());//mars map
        
        //location name, duration, purpose, cost, crew size, resources required of Mars Mission
        maps.get(0).put("Name", "Mars_Mission");
        maps.get(0).put("Location", "Mars");
        maps.get(0).put("Duration", "1 Month");
        maps.get(0).put("Purpose", "Scientific");
        maps.get(0).put("Cost", "$200000000");
        maps.get(0).put("Crew", "7");    
        maps.get(0).put("Resources", "Mars");
        maps.get(0).put("Lock", "Unlocked");
    }
    
    public static void menu(){
        
        String response;
        boolean run = true;
        while(run){
            System.out.println("What would you like to do?");
            System.out.println("(Select) new File");
            System.out.println("(View) File's stored data");
            System.out.println("(Change) File's stored data");
            System.out.println("(Lock) the File to prevent changes");
            System.out.println("(Unlock) the File to change data");
            System.out.println("(Exit) the program");
            response = scan.nextLine();
            System.out.println("");
            switch(response){
                case "Select":
                    select();
                    break;
                case "View":
                    view();
                    break;
                case "Change":
                    change();
                    break;
                case "Lock":
                    lock();
                    break;
                case "Unlock":
                    unlock();
                    break;
                case "Exit":
                    run = false;
                    break;
                default:
                    System.out.println("Sorry I didn't understand that.");
                    break;
            }
        }
    }
    
    public static void select(){
        boolean run = true;
        String response;
        while(run){
            System.out.println("Please Type the File Name to Select");
            for(int i = 0; i < maps.size(); i++){
                System.out.println("File 0" + i + " Name: " + maps.get(i).get("Name"));
            }
            System.out.println("New_File");
            System.out.println("");
            
            response = scan.nextLine();
            if(response.equals("New_File")){
                maps.add(new HashMap<>(maps.get(0)));
                maps.get(maps.size()-1).replace("Name", "New_File");
                maps.get(maps.size()-1).replace("Lock", UNLOCKED);
                selected = maps.size() - 1;
                run = false;
            }else{
                for(int i = 0; i < maps.size(); i++){
                    if(response.equals(maps.get(i).get("Name"))){
                        selected = i;
                        run = false;
                    }
                }
                
                if(run){
                    System.out.println("File not found");
                    System.out.println("");
                }
                
            }
        }
    }
    
    public static void view(){
        boolean run = true;
        String response;
        while(run){
            System.out.println("Enter Keys to view Stored Value.");
            System.out.println("Enter \"Back\" to go back.");
            System.out.println("Some Possible Keys:");
            System.out.println("Name, Location, Duration, Purpose, Cost, Crew, Resourses, Lock");
            System.out.println("");
            response = scan.nextLine();
            
            if(response.equals("Back")){
                run = false;
            }else{
            System.out.println(response + ": " +maps.get(selected).get(response));
            System.out.println("");
            }
            
        }
    }
    
    public static void change(){
        boolean run = true;
        String lock = maps.get(selected).get("Lock");
        String response;
        String key;
        if(lock.equals(LOCKED)){
            run = false;
            System.out.println("File is Locked!!!");
        }
        while(run){
            System.out.println("Enter Keys to Change Value.");
            System.out.println("Enter \"Back\" to go back.");
            System.out.println("Some Possible Keys:");
            System.out.println("Name, Location, Duration, Purpose, Cost, Crew, Resourses, Lock");
            System.out.println("");
            response = scan.nextLine();
            
            if(response.equals("Back")){
                run = false;
            }else{
                key = response;
                System.out.println("Change " + response + ": " + maps.get(selected).get(response));
                System.out.print("To     " + response + ": " );
                response = scan.nextLine();
                maps.get(selected).replace(key, response);
                
                System.out.println("Changed!");
                System.out.println("");
            }
        }
    }
    
    public static void lock(){
        maps.get(selected).replace("Lock", LOCKED);
        System.out.println("File Locked!");
    }
    
    public static void unlock(){
        String response;
        System.out.println("Please enter Admin Password.");
        response = scan.nextLine();
        if(response.hashCode() == HASH_PASS){
            maps.get(selected).replace("Lock", UNLOCKED);
            System.out.println("File Unlocked!");
        }
    }
}
