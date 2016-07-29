package LabWork;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabNum7 {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		String choice = "yes";
		String[][] infoTable = {
				{"Gerrae","Chicago","Pizza",},
				{"Tommy","Detroit","Chinese"},
				{"Valere","Racine","Deserts"},
				{"Karen","Ferndale","Mexcian"},
				{"Latresha","Flint","Seafood"},
				{"Blair","Troy","Sushi"},
				{"Shruti","Auburn Hills","Indian"},
				{"Lily","Commerce Township","Steak"},
				{"Laurin","Rochester Hills","Sushi"},
				{"Kristen","Sterling Heights","Pizza"},
				{"Abbi","East Lansing","Pizza"},
				{"Ambyr","Redford","Coffee"},
				{"Amy","Lapeer","Seafood"},
				{"Jamila","Chicago","Crablegs"},
				{"DeeAnn","Chicago","Alfredo"},
				{"Vonnita","Southfield","Pot pies"},
				{"Tracy","Holly","Thai"},
				{"Noor","Farmington","Pizza"},
				{"Janna","North Branch","Steak"},
				{"Grace","Fenton","French Fries"}};
		
		int classMate = 0;
		
		System.out.println("Welcome to our Java Class.");
		while (choice.equalsIgnoreCase("yes"))
		{
			
			
				//accept the user input and check to see if its an integer
				try {
					System.out.println("Which student would you like to learn more about?(enter a number 1-4): ");
					classMate = scan1.nextInt();
					scan1.nextLine(); //garbage line
					
					 
				}catch(InputMismatchException e){
					System.out.println("That Student does not exist. Try again.");
					scan1.nextLine(); //garbage line
					continue;
				}
				//validate you have a valid number
			if (classMate >20 ||classMate <1){
				try {
					 throw new ArrayIndexOutOfBoundsException();
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("That Student does not exist. Try again.");
					continue;
				}
				
				
			}
			else
			{
				//get student name
				System.out.print("Student "+ classMate +" is "+ infoTable[classMate -1][0]+".");
				System.out.print(" What would you like to know about "+ infoTable[classMate -1][0]+"?");
				System.out.println(" enter \"homewtown\" or \"favorite food\"):"); 
				String userInput = scan1.nextLine();
				String result = "";
				result =  getMoreInfo(infoTable, classMate, userInput,result);
				if(result.equalsIgnoreCase("false") ){
					 System.out.print(" What would you like to know about "+ infoTable[classMate -1][0]+".");
					 System.out.println(" enter \"homewtown\" or \"favorite food\"):"); 
					 userInput = scan1.nextLine();
					 getMoreInfo(infoTable, classMate, userInput,result);
				 }
			}
	             
			System.out.println("Would you like to learn about another Student? (enter yes or no):");
	        choice = scan1.nextLine();
		}
		
	     if (choice.equalsIgnoreCase("no")){
	    	 System.out.println("Thanks for playing. Goodbye!");
	     }

		//close the scanner.
		scan1.close();
	}

	/**
	 * @param infoTable
	 * @param classMate
	 * @param userInput
	 */
	private static String getMoreInfo(String[][] infoTable, int classMate, String userInput,String valid) {
		valid = "true";
		switch (userInput){
		case "hometown": case "Hometown": case "HOMETOWN":
			System.out.println( infoTable[classMate -1][0]+"'s " +" hometown is "+ infoTable[classMate -1][1]+".");
			break;
		case "favorite food":case "Favorite Food":case "FAVORITE FOOD":
			System.out.println( infoTable[classMate -1][0]+"'s "+" favorite food is "+ infoTable[classMate -1][2]+".");
			break;
		default:
			if (!userInput.equalsIgnoreCase("hometown") | !userInput.equalsIgnoreCase("favorite food")){
				try{
					throw new IllegalArgumentException();
				}catch(IllegalArgumentException i){
					System.out.print("That data does not exist. Please try again.");
					valid ="false";
				}
				
			}
			
		}//end of switch
		
		return valid;
		
	}

}
