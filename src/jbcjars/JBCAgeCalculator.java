package jbcjars;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class JBCAgeCalculator 
{
	public static boolean validateDate(int vDay, int vMonth, int vYear)
	{
		//This function returns validDate as true if the date is valid, false if it is not 
		//The value of validDate is returned as the value of the function. 
		boolean validDate = false; 
		
		if(vMonth<1||vMonth>12)
		{
			 validDate=false;
		     return validDate;
		}
		
		switch(vMonth)
		{
			case 2: //Check for a valid value for February (leap year included) 
				if(vYear%4!=0 && vDay<=29) 
					validDate = true; 
				else if(vDay<28)
					validDate = true; 
				else validDate = false; 
			break; 
			
			case 4: case 6: case 10: case 11:
			{//Check for valid values for April, June, September and November
				if(vDay<30 && vDay>=1)
					validDate = true;
				else 
					validDate = false; 
			break; 
			}
			default:
			{ //Check for valid values for all other days 
				if(vDay<31  && vDay>=1)
					validDate=true; 
				else 
					validDate = false; 
			break; 
			}
		
		}
		return validDate; 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean validDate;
		
		int gDay=0; 
		int gMonth=0; 
		int gYear=0;
		
		Scanner userInput = new Scanner(System.in); 
	
		do
		{
			System.out.println("Enter your day of birth");
			gDay = userInput.nextInt();
			System.out.println("Enter your month of birth");
			gMonth = userInput.nextInt();			
			System.out.println("Enter your year of birth");
			gYear = userInput.nextInt();
				
			validDate = validateDate(gDay,gMonth,gYear);
			if(!validDate)
			{
				System.out.println("The date entered is invalid. Please re-enter");
			}
			else 
				System.out.println("You are:"+calculateAge(gDay,gMonth,gYear)+"years old");
		}while(validDate==false);
		userInput.close(); 
	}

	public static int calculateAge(int gDay, int gMonth, int gYear) 
	{
		// TODO Auto-generated method stub
		Date usedBirthDate=null;
		Date todaysDate = new Date() ;
		String birthDate = Integer.toString(gDay)+"/"+Integer.toString(gMonth)+"/"+Integer.toString(gYear);

		try 
		{
			usedBirthDate=new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
		} catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat outputFormatter = new SimpleDateFormat("EEEE dd MM yyyy");
		long difference = todaysDate.getTime() - usedBirthDate.getTime(); 
		int age = Math.round(difference / 1000 / 60 / 60 / 24 / 365);
		System.out.println("Date of birth:"+outputFormatter.format(usedBirthDate));
		return age;
	}

}
