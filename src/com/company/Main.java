package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player lucas = new Player("Lucas",10,15);
        System.out.println(lucas.toString());
        savedObject(lucas);

        lucas.setHitPoints(7);
        System.out.println(lucas);
        lucas.setWeapon("axe");
        savedObject(lucas);
//        loadObject(lucas);
        System.out.println(lucas);

        ISaveable werewolf = new Monster("Werewolf",20,45);
        System.out.println("Strength = "+((Monster) werewolf).getStrength());
        System.out.println(werewolf);
        savedObject(werewolf);
    }
    public static List<String> readValues(){
        List<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit =false;
        int index = 0;
        System.out.println("Choose\n 1 to enter a string\n 0 to quit");

        while(!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    break;
            }
        }
        return values;

    }

    public static void savedObject(ISaveable objectToSave){
        for(int i=0; i<objectToSave.write().size();i++){
            System.out.println("Saving "+ objectToSave.write().get(i));
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        List<String> values = readValues();
        objectToLoad.read(values);
    }
}
