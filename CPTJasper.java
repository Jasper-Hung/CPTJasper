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
		con.println("Main Menu");
		con.println("Play Game (p)");
		con.println("View Leaderboard (v)");
		con.println("Add Theme (a)");
		con.println("Help (h)");
		con.println("Quit (q)");
		char chrMenuInput = con.getChar();
		if(chrMenuInput == 'p' || chrMenuInput == 'P'){
			//Goes to starting game screen
			PlayGame(con);
			
		}else if(chrMenuInput == 'v' || chrMenuInput == 'V'){
	
		}else if(chrMenuInput == 'a' || chrMenuInput == 'A'){
			
		}else if(chrMenuInput == 'h' || chrMenuInput == 'H'){	
			con.clear();
			//Help Menu
			con.print("Guess the word is a game where you are given a word and you have to keep");
			con.println(" on \nguessing the letters of the word until you get it or lose.");
			con.print("You get an specific amount of points based on the amount of letters in the word");
			con.println("\nand every time you guess wrong, you lose a point.");
			con.println("At zero points, you lose the game, if you guess the word before that, you win.");
			con.println("GOOD LUCK");
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
		
		while(GameFile.eof() == false){
			strWord = GameFile.readLine();
			con.println(strWord);
			
		}	
		
	}	
		
}
