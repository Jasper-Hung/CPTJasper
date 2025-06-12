//----------------------------------------------------------------------
// Program Name: 	CPTJasper
// Purpose: 		Create a Guess the Word Game
// Author:			Hung J.
// Created: 		May 23, 2025
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
	//End of method	
	}
	public static void MainMenu(Console con){
		//Main Menu Display
		con.setDrawColor(Color.DARK_GRAY);
		con.fillRect(0,0,1280,720);
		con.clear();
		
		con.setDrawColor(Color.WHITE);
		con.drawLine(350,135,925,135);
		con.drawLine(350,135,350,650);
		con.drawLine(350,650,925,650);
		con.drawLine(925,135,925,650);
		con.setDrawFont(new Font("SansSerif", Font.BOLD, 75));
		con.drawString("MAIN MENU", 425, 20);
		con.setDrawFont(new Font("SansSerif", Font.PLAIN, 40));
		con.drawString("Play Game(p)", 400, 150);
		con.drawString("View Leaderboard(v)", 400, 250);
		con.drawString("Add Theme (a)", 400, 350);
		con.drawString("Help (h)", 400, 450);
		con.drawString("Quit (q)", 400, 550);
		con.repaint();
	
		char chrMenuInput = con.getChar();
		if(chrMenuInput == 'p' || chrMenuInput == 'P'){
			//Goes to starting game screen
			con.setDrawColor(Color.DARK_GRAY);
			con.fillRect(0,0,1280,720);
			con.clear();
			PlayGame(con);
			
		}else if(chrMenuInput == 'v' || chrMenuInput == 'V'){
			//Goes to leaderboard screen
			con.setDrawColor(Color.DARK_GRAY);
			con.fillRect(0,0,1280,720);
			con.clear();
			Leaderboard(con);
		}else if(chrMenuInput == 'a' || chrMenuInput == 'A'){
			//Goes to add theme screen
			con.setDrawColor(Color.DARK_GRAY);
			con.fillRect(0,0,1280,720);
			con.clear();
			AddTheme(con);
		}else if(chrMenuInput == 'h' || chrMenuInput == 'H'){	
			con.setDrawColor(Color.DARK_GRAY);
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
			con.println("(Press m to go back to main menu)");
			while(chrMenuInput != 'm'){
				chrMenuInput = con.getChar();
			}	
			if(chrMenuInput == 'm' || chrMenuInput == 'M'){
				MainMenu(con);
			}	
		}else if(chrMenuInput == 'q' || chrMenuInput == 'Q'){
			//Quits game
			con.closeConsole();
		}else if(chrMenuInput == 's' || chrMenuInput == 'S'){	
			//SECRET 
			con.setDrawColor(Color.DARK_GRAY);
			con.fillRect(0,0,1280,720);
			con.clear();
			con.println("Why did the electric car feel discriminated against?");
			con.println("Because the rules weren't current.");
			con.println("(Press m to go back to main menu)");
			while(chrMenuInput != 'm'){	
				chrMenuInput = con.getChar();
			}	
			if(chrMenuInput == 'm' || chrMenuInput == 'M'){
				MainMenu(con);
			}
				
		}else{
			//If user does not put in right letter
			con.setDrawColor(Color.DARK_GRAY);
			con.fillRect(0,0,1280,720);
			con.clear();
			con.println("INVALID LETTER");
			con.println("Refreshing...");
			con.sleep(1000);
			MainMenu(con);	
		}	
	//End of method	
	}
	public static void PlayGame(Console con){
		//Starting Game Screen
		con.clear();
		
		//Variables
		
		String strName; 
		String strGameChoice;
		String strFile;
		String strWord;
		boolean blnFileCheck = false;
		
		con.println("What is your name?: ");
		strName = con.readLine();
		
		TextInputFile Masterfile = new TextInputFile("themes.txt");
		
		con.println("Pick what topic you want to play (Case-sensitive):");
		
		while(Masterfile.eof() == false){
			//Printing all files from masterlist
			strFile = Masterfile.readLine();
			con.println(strFile);
		}	
		strGameChoice = con.readLine();
		
		Masterfile.close();
		
		Masterfile = new TextInputFile("themes.txt");
		
		//Checks if the file choice actually matches one of the files
		while(Masterfile.eof() == false){
			strFile = Masterfile.readLine();
			if(strFile.equals(strGameChoice)){
				blnFileCheck = true;
			}	
		}
		//If invalid word
		if(blnFileCheck == false){
			con.println("Invalid choice...");
			con.println("Sending you back to main menu!!!");
			con.sleep(2000);
			MainMenu(con);
		}		
		
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
		//Dummy points so the while loop can work properly inside the actual game
		int intFakePoints;
		int intWinCount = 0;
		int intCount5;
		String strLetter = "";
		String strDisplayWord = "";
		char chrGuess[];
		char chrGuessLetter;
		char chrDisplayWord[];
		
		//Setting up word for game
		for(intGameCount = 0; intGameCount <= intWordCount; intGameCount++){
			
			//Setting up leaderboard file variable for later uses
			TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
			
			
			//If user reaches the end of the word list
			if(intGameCount == intWordCount){
				con.clear();
				con.println("CONGRATULATIONS");
				con.println("You've reached the end of the word list.");	
				con.println("Returning back to main menu...");
				//Printing data to leaderboard because end of game
				leaderboard = new TextOutputFile("leaderboard.txt",true);
				leaderboard.println(strName);
				leaderboard.println(intWinCount);
				leaderboard.close();
				con.sleep(5000);
				MainMenu(con);
			}	
			intPoints = 0;
			intFakePoints = 0;
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
					intFakePoints = intFakePoints + 1;
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
			String strLetterUnderscore;
			boolean blnRight;
			boolean blnWin;
			char chrPlayAgain;
			
			//Actual Gameplay
			while(intFakePoints > 0){
				con.clear();
				blnRight = false;
				blnWin = true;	
				con.println(strDisplayWord);
				con.println("You have " + intPoints + " points");
				con.println("Guess a letter (in lowercase)");
				
				chrGuessLetter = con.getChar();
				System.out.println(chrGuessLetter);
				//Checks all letters in the string to see if it matches with the guess
				for(intCount7 = 0; intCount7 < strWord.length(); intCount7++){
					if(chrGuess[intCount7] == chrGuessLetter){
						//Changing display word to have the correct letter
						String strModify;
						chrDisplayWord[intCount7] = chrGuessLetter;
						//Replacing specific string character with guess character
						strModify = strDisplayWord.substring(0, intCount7) + chrGuessLetter + strDisplayWord.substring(intCount7+1);
						strDisplayWord = strModify;	
						//Makes it so when guess is right, player doesn't loses points
						blnRight = true;
					}
				}
				if(blnRight == false){
					intPoints--;
					intFakePoints--;
				}
				//Checking if win
				for(intCount8 = 0; intCount8 < strWord.length(); intCount8++){
					strLetterUnderscore = strDisplayWord.substring(intCount8, intCount8+1);
					if(strLetterUnderscore.equalsIgnoreCase("_")){
						blnWin = false;
					}	
				}					
				System.out.println("\n\nTRANSITION\n\n");
				System.out.println("Win: " + blnWin);
				

					
				//This happens when you win
				if(blnWin == true){
					intWinCount++;
					System.out.println("WinCount: " + intWinCount);
					con.clear();
					con.println(strDisplayWord);
					con.println("You Win!!!!!!!!");
					con.println("You have " + intWinCount + " win(s) so far.");
					con.println("Do you want to play again?");
					con.println("Type anything for yes");
					con.println("Type m for no (return back to main menu)");
					chrPlayAgain = con.getChar();
					if(chrPlayAgain == 'm' || chrPlayAgain == 'M'){
						//Printing data to leaderboard because end of game
						leaderboard = new TextOutputFile("leaderboard.txt",true);
						leaderboard.println(strName);
						leaderboard.println(intWinCount);
						leaderboard.close();
						MainMenu(con);
					}else{
						intFakePoints = 0;
					}		
				}
				//This happens when you lose	
				if(intPoints == 0){
					con.clear();
					con.println("You have just reached 0 points.");
					con.println("..................");
					con.println("YOU LOST!");
					con.println("The word was: " + strWord);
					con.println("You have " + intWinCount + " win(s) so far.");
					con.println("Do you want to play again?");
					con.println("Type anything for yes");
					con.println("Type m for no (return back to main menu)");
					chrPlayAgain = con.getChar();
					if(chrPlayAgain == 'm' || chrPlayAgain == 'M'){
						//Printing data to leaderboard because end of game
						leaderboard = new TextOutputFile("leaderboard.txt",true);
						leaderboard.println(strName);
						leaderboard.println(intWinCount);
						leaderboard.close();
						MainMenu(con);
					}else{
						intFakePoints = 0;
					}		
				
				}		
			}
		}	
	//End of Method		
	}	
	public static void AddTheme(Console con){
		String strTheme;
		String strWord = "";
		
		TextOutputFile themes = new TextOutputFile("themes.txt",true);
		
		con.println("What is the theme name, type '.txt' at the end of name");
		strTheme = con.readLine();
		themes.println(strTheme);
		themes.close();
		
		TextOutputFile UserCreatedFile = new TextOutputFile(strTheme,true);
		while(!strWord.equalsIgnoreCase("stop")){
			con.clear();
			con.println("Enter a word to the file: ");
			con.println("Enter 'stop' to stop");
			strWord = con.readLine();
			if(strWord.equalsIgnoreCase("")){
				con.println("You can not enter an empty word");
				con.sleep(1000);	
			}	
			if(!strWord.equalsIgnoreCase("stop")){
				UserCreatedFile.println(strWord);
			}	
		}
		con.println("Returning to main menu...");
		con.sleep(1000);
		MainMenu(con);
		
	//End of method	
	}			
	public static void Leaderboard(Console con){
		//Setting up leaderboard layout
		con.setDrawColor(Color.WHITE);
		con.drawLine(0, 75, 1280, 75);
		con.drawString("LEADERBOARD", 500, 6);
		con.setDrawFont(new Font("SansSerif", Font.PLAIN, 20));
		con.drawString("Return to main menu (press m)", 950, 675);
		con.repaint();
		
		int intBoardLoop = 0;
		char chrReturnMenu;
		int intBoardCount = 0;
		String strNameTemp;
		String strScoreTemp;
		TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
		
		//Finding length of leaderboard
		while(leaderboard.eof() == false){
			strNameTemp = leaderboard.readLine();
			strScoreTemp = leaderboard.readLine();
			intBoardCount++;
		}
		leaderboard.close();	
		
		String strLeaderboard[][];
		strLeaderboard = new String[intBoardCount][2];
		
		//Column 0 is name
		//Column 1 is amount of wins

		int intCount;
		leaderboard = new TextInputFile("leaderboard.txt");
		
		//Putting data from leaderboard file to array
		for(intCount = 0; intCount < intBoardCount; intCount++){
			strLeaderboard[intCount][0] = leaderboard.readLine();
			strLeaderboard[intCount][1]	= leaderboard.readLine();
			System.out.println(strLeaderboard[intCount][0]);
			System.out.println(strLeaderboard[intCount][1]);
		}	
		leaderboard.close();
		
		int intCount2;
		int intCount3;
		//Sorting leaderboard by score highest to lowest
		for(intCount2 = 0; intCount2 < intBoardCount - 1; intCount2++){
			for(intCount3 = 0; intCount3 < intBoardCount - 1 ; intCount3++){
				//Converting string to integer to compare
				if(Integer.parseInt(strLeaderboard[intCount3][1]) < Integer.parseInt(strLeaderboard[intCount3+1][1])){
					System.out.println("SWAPPING");
					//Swapping name
					strNameTemp = strLeaderboard[intCount3][0];
					strLeaderboard[intCount3][0] = strLeaderboard[intCount3+1][0];
					strLeaderboard[intCount3+1][0] = strNameTemp;
					//Swapping score
					strScoreTemp = strLeaderboard[intCount3][1];
					strLeaderboard[intCount3][1] = strLeaderboard[intCount3+1][1];
					strLeaderboard[intCount3+1][1] = strScoreTemp;
					
				}
			}		
		}
		int intCount4;
		//Printing leaderboard
		String strName;
		String strPlus = " - ";
		String strScore;
		con.setDrawFont(new Font("Dialog", Font.PLAIN, 30));
		
		for(intCount4 = 0; intCount4 < intBoardCount; intCount4++){
			//Prints name + score on to middle of screen
			strName = strLeaderboard[intCount4][0];
			strScore = strLeaderboard[intCount4][1];
			con.drawString(strName, 320,(intCount4 + 2)* 40);
			con.drawString(strPlus, 640,(intCount4 + 2)* 40);
			con.drawString(strScore, 960,(intCount4 + 2)* 40);
			con.repaint();

		}
		//Return back to main menu
		while(intBoardLoop == 0){
			chrReturnMenu = con.getChar();
			if(chrReturnMenu == 'm'){
				MainMenu(con);
			}else{
				chrReturnMenu = con.getChar();
			}		
		}
	//End of method	
	}
		
}
