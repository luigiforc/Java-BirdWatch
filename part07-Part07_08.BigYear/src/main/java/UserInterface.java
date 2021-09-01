/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luigi
 */
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Bird> birds;
    

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.birds = new ArrayList<>();
        
    }

    public void start(){
        while(true){
            System.out.print("? ");
            String input=scanner.nextLine();
            if(input.equals("Add")){
                System.out.print("Name: ");
                String name=scanner.nextLine();
                System.out.print("Name in Latin: ");
                String latinName=scanner.nextLine();
                addBird(name,latinName);
            } else if (input.equals("Observation")){
                boolean flag=true;
                System.out.print("Bird? ");
                String name=scanner.nextLine();
                for(Bird bird:birds){
                    if(bird.getName().equals(name)){
                        bird.addObservation();
                        flag=false;
                    } 
                }
                if(flag){
                    System.out.println("Not a bird!");
                }
            } else if(input.equals("All")){                
                printAll();
            } else if(input.equals("One")){
                System.out.print("Bird? ");
                String name=scanner.nextLine();
                printOne(name);
            } else if(input.equals("Quit")){
                break;
            }
        }
    }
    
    public void addBird(String name,String latinName){
        if(name.isEmpty()||latinName.isEmpty()){
            return;
        }
        Bird bird = new Bird(name,latinName);
        this.birds.add(bird);
    }
    
    public void printAll(){
        for(Bird bird:birds){
            System.out.println(bird.getName()+" ("+bird.getLatinName()+"): "+bird.getObservationCount()+" observations");
        }
    }
    
    public void printOne(String searched){
        for(Bird bird:birds){
            if(bird.getName().equals(searched)){
                System.out.println(bird.getName()+" ("+bird.getLatinName()+"): "+bird.getObservationCount()+" observations");
            }
            
        }
    }
    
   
}
