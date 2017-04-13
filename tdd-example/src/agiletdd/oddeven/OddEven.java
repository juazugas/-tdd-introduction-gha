package agiletdd.oddeven;

import java.util.stream.IntStream;

public class OddEven {

	public static final String PRIME = "PRIME";

	public String print(int number){

		if(isPrime(number)){
			return PRIME;
		}else{
			return number%2==0 ? "EVEN" : "ODD";
		}

	}

	private boolean isPrime(int number){
		return number==1|| number ==2||!IntStream.range(2, number-1).anyMatch(i-> number%i==0 );



	}

	
}
