//----------------------------------------------------------------------
// Name: 		CPTJasper
// Purpose: 	Create a Guess the Word Game
// Author:		Hung J.
// Created: 	May 23, 2025
//----------------------------------------------------------------------

import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;


public class CPTJasper{
	public static void main(String[] args){
		Console con = new Console("Guess The Word",1280,720);
		
		//Start Menu Background and Draw Font
		BufferedImage StartImage = con.loadImage("logo.png");
		con.setDrawFont(new Font("SansSerif", Font.BOLD, 40));
		
		for(int intLoad = 0; intLoad < 3; intLoad++){
			//FAKE Loading Screen
			int intSleepMS = 400;
			
			con.drawImage(StartImage,0,0);
			con.drawString("Loading.", 565, 550);
			con.repaint();
			con.sleep(intSleepMS);
			
			con.drawString("Loading..", 565, 550);
			con.repaint();
			con.sleep(intSleepMS);
			
			con.drawString("Loading...", 565, 550);
			con.repaint();
			con.sleep(intSleepMS);
		}
		
		con.drawImage(StartImage,0,0);
		con.repaint();
		
		//Changing background to black for main menu
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		
		//Starting up MainMenu with a method
		MainMenu(con);
		
	}

	public static void MainMenu(Console con){
		//Main Menu Display
		con.clear();
		
		con.setDrawColor(Color.WHITE);
		con.drawString("Main Menu", 400, 100);
		con.drawString("Play Game(p)", 400, 150);
		con.drawString("View Leaderboard(v)", 400, 200);
		con.drawString("Add Theme (a)", 400, 250);
		con.drawString("Help (h)", 400, 300);
		con.drawString("Quit (q)", 400, 350);
		con.repaint();
	
	
		char chrMenuInput = con.getChar();
		if(chrMenuInput == 'p' || chrMenuInput == 'P'){
			//Goes to starting game screen
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.clear();
			PlayGame(con);
			
		}else if(chrMenuInput == 'v' || chrMenuInput == 'V'){
	
		}else if(chrMenuInput == 'a' || chrMenuInput == 'A'){
			
		}else if(chrMenuInput == 'h' || chrMenuInput == 'H'){	
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.clear();
			//Help Menu
			con.print("Guess the word is a game where you are given a word and you have to keep");
			con.println(" on \nguessing the letters of the word until you get it or lose.");
			con.print("You get an specific amount of points based on the amount of letters in the word");
			con.println("\nand every time you guess wrong, you lose a point.");
			con.println("At zero points, you lose the game, if you guess the word before that, you win.");
			con.println("GOOD LUCK");
			con.println("(There's a secret in the main menu)");
			con.println("(Find the hidden cheat username)");
			con.println("(Press m to go back to main menu)");
			chrMenuInput = con.getChar();
			if(chrMenuInput == 'm' || chrMenuInput == 'M'){
				MainMenu(con);
			}	
		}else if(chrMenuInput == 'q' || chrMenuInput == 'Q'){
			//Quits game
			con.closeConsole();
		}else if(chrMenuInput == 'x' || chrMenuInput == 'X'){	
			//SECRET 
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,1280,720);
			con.clear();
			con.println("Why did the electric car feel discriminated against?");
			con.println("Because the rules weren't current.");
			con.println("(Press m to go back to main menu)");
			chrMenuInput = con.getChar();
			if(chrMenuInput == 'm' || chrMenuInput == 'M'){
				MainMenu(con);
			}	
		}
		
	}
	public static void PlayGame(Console con){
		//Starting Game Screen
		con.clear();
		
		//Variables
		
		String strName; 
		String strGameChoice;
		String strFile;
		String strWord;
		
		con.println("What is your name?: ");
		strName = con.readLine();
		
		TextInputFile Masterfile = new TextInputFile("themes.txt");
		
		con.println("Pick what topic you want to play:");
		
		while(Masterfile.eof() == false){
			//Printing all files from masterlist
			strFile = Masterfile.readLine();
			con.println(strFile);
		}	
		strGameChoice = con.readLine();
		
		Masterfile.close();
		
		con.clear();
		
		//Opening Game Choice
		TextInputFile GameFile = new TextInputFile(strGameChoice);
		int intWordCount = 0;
		
		while(GameFile.eof() == false){
			
			strWord = GameFile.readLine();
			System.out.println(strWord);
			intWordCount++;
			System.out.println(intWordCount);
			
		}	
		GameFile.close();
		String strWords [][];
		strWords = new String [intWordCount][2];
		//Column 0 is words
		//Column 1 is random integers from 1 to 100
		
		GameFile = new TextInputFile(strGameChoice);
		
		int intCount;
		System.out.println("\n\nTRANSITION\n\n");
		for(intCount = 0; intCount < intWordCount; intCount++){
			//Giving each word a random integer from 1 to 100
			strWords[intCount][0] = GameFile.readLine();
			int intRand;
			intRand = (int)(Math.random()*100+1);
			strWords[intCount][1] = intRand + ""; //Forces integer to be string
			System.out.println(strWords[intCount][0]);
			System.out.println(strWords[intCount][1]);
		}
		
		//Sorting array
		int intCount2;
		int intCount3;
		String strWordTemp;
		String strIntTemp;
		
		System.out.println("\n\nTRANSITION\n\n");
		
		for(intCount2 = 0; intCount2 < intWordCount - 1; intCount2++){
			for(intCount3 = 0; intCount3 < intWordCount - 1 ; intCount3++){
				//Converting string to integer to compare
				if(Integer.parseInt(strWords[intCount3][1]) > Integer.parseInt(strWords[intCount3+1][1])){
					System.out.println("SWAPPING");
					//Swapping word
					strWordTemp = strWords[intCount3][0];
					strWords[intCount3][0] = strWords[intCount3+1][0];
					strWords[intCount3+1][0] = strWordTemp;
					//Swapping integer
					strIntTemp = strWords[intCount3][1];
					strWords[intCount3][1] = strWords[intCount3+1][1];
					strWords[intCount3+1][1] = strIntTemp;
					
				}
			}	
		}		
		
		int intCount4;
		
		System.out.println("\n\nTRANSITION\n\n");
		
		for(intCount4 = 0; intCount4 < intWordCount; intCount4++){
			System.out.println(strWords[intCount4][0]);
			System.out.println(strWords[intCount4][1]);	
		}
		GameFile.close();
		
		int intLOWERCASE;
		String strLowercase;
		
		//Converting all words to only lowercase
		for(intLOWERCASE = 0; intLOWERCASE < intWordCount; intLOWERCASE++){
			
			strLowercase = strWords[intLOWERCASE][0];
			strWords[intLOWERCASE][0] = strLowercase.toLowerCase();
			
			System.out.println("\n\nTRANSITION\n\n");
			System.out.println(strWords[intLOWERCASE][0]);
		}	
	
		
		
		
		
		int intGameCount;
		int intPoints;
		int intCount5;
		String strLetter = "";
		String strDisplayWord = "";
		char chrGuess[];
		char chrGuessLetter;
		char chrDisplayWord[];
		
		//Time for the actual game
		for(intGameCount = 0; intGameCount < intWordCount; intGameCount++){
			intPoints = 0;
			strDisplayWord = "";
			strWord = strWords[intGameCount][0];
			System.out.println("\n"+strWord+"\n");
			
			//Make displayword have underscore for letters and spaces for spaces
			for (intCount5 = 0; intCount5 < strWord.length(); intCount5++) {
				strLetter = strWord.substring(intCount5, intCount5+1);
				if(strLetter.equalsIgnoreCase(" ")){
					strDisplayWord = strDisplayWord + " ";
				}else{
					//Amount of points = amount of letters
					strDisplayWord = strDisplayWord + "_";
					intPoints = intPoints + 1;
				}		
			}
			chrGuess = new char[strWord.length()];
			
			System.out.println(intPoints);
			System.out.println(strDisplayWord);
			chrDisplayWord = new char[strWord.length()];
			
			int intCount6;
			
			//Make character array match all characters of the word
			//Make display arraw match all characters of display word
			for(intCount6 = 0; intCount6 < strWord.length(); intCount6++){
				chrGuess[intCount6] = strWord.charAt(intCount6);
				chrDisplayWord[intCount6] = strDisplayWord.charAt(intCount6);
				System.out.println(chrGuess[intCount6]);
				System.out.println(chrDisplayWord[intCount6]);
					
			}
			
			System.out.println(intPoints);
			System.out.println(strDisplayWord);
			
			int intCount7;
			int intCount8;
			int intCount9;
			String strLetterUnderscore;
			boolean blnRight;
			boolean blnWin;
			int intWinCount = 0; 
			char chrAgain;
			while(intPoints > 0){
				for(intCount7 = 0; intCount7 < strWord.length(); intCount7++){
					con.clear();
					blnRight = false;
					blnWin = true;	
					con.println(strDisplayWord);
					con.println("You have " + intPoints + " points");
					con.println("Guess a letter (in lowercase)");
				
					chrGuessLetter = con.getChar();
					System.out.println(chrGuessLetter);
					//Checks all letters in the string to see if it matches with the guess
					for(intCount8 = 0; intCount8 < strWord.length(); intCount8++){
						if(chrGuess[intCount8] == chrGuessLetter){
							//Changing display word to have the correct letter
							String strModify;
							chrDisplayWord[intCount8] = chrGuessLetter;
							//Replacing specific string character with guess character
							strModify = strDisplayWord.substring(0, intCount8) + chrGuessLetter + strDisplayWord.substring(intCount8+1);
							strDisplayWord = strModify;	
							//Makes it so when guess is right, player doesn't loses points
							blnRight = true;
						}
					}
					if(blnRight == false){
						intPoints--;
					}
					//Checking if win
					for(intCount9 = 0; intCount9 < strWord.length(); intCount9++){
						strLetterUnderscore = strDisplayWord.substring(intCount9, intCount9+1);
						if(strLetterUnderscore.equalsIgnoreCase("_")){
							blnWin = false;
						}	
					}					
					System.out.println("\n\nTRANSITION\n\n");
					System.out.println("Win: " + blnWin);
					
					if(blnWin == true){
						intWinCount++;
						System.out.println("WinCount: " + intWinCount);
						con.clear();
						con.println(strDisplayWord);
						con.println("You Win!!!!!!!!");
						con.println("Do you want to play again?");
						con.println("Type anything for yes");
						con.println("Type m for no (return back to main menu)");
						chrAgain = con.getChar();
						if(chrAgain == 'm' || chrAgain == 'M'){
							MainMenu(con);
						}	
					}	
						
				}
			}
		}	
			
	}	
			
}
