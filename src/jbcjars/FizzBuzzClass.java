package jbcjars;
public class FizzBuzzClass {
	public static void main(String[] args)
	{
		/* Write a program that prints the numbers from 1 to 100. 
		 * But for multiples of three print “Fizz” instead of the 
		 * number and for the multiples of five print “Buzz”. 
		 * For numbers which are multiples of both three and five print “FizzBuzz”.
		 */
		String FizzBuzzString; 
		for(int i=1; i<101; i++)
		{
			FizzBuzzString=""; //This string will contain text for all the multiples that the program is checking for. 
			//It makes adding new multiples easier. 
			
			if(i%3==0)
				FizzBuzzString+="Fizz";
			if(i%5==0)
				FizzBuzzString+= "Buzz";
			if(i%3==0||i%5==0)
			 System.out.println(FizzBuzzString);
			else
			 System.out.println(i);
           
			
		}
	}

}
