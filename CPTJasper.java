import arc.*;

public class CPTJasper{
	public static void main(String[] args){
		Console con = new Console();
		con.println("Hello World");
		
		int intNum;
		int intAdd;
		
		con.println("What is the number?: ");
		intNum = con.readInt();
		
		con.println("What is the number you want to add to the original?");
		intAdd = con.readInt();
		
		intNum = intNum + intAdd;
		
		con.println("The new number is: " + intNum);
	}
}
