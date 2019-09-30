package elevator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
* The Elevator program is the application that implements Elevator system logic
*
* @author  Sumeet Kripalani
* @version 1.0
* @since   03-08-2019
*/

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the number of test cases : ");
		int testcases = Integer.parseInt(br.readLine());
	
		//number of testcases
		
		for(int i=0;i<testcases;i++)
		{
			System.out.println("Enter the num of passengers : ");
			int passengers = Integer.parseInt(br.readLine());
			System.out.println("Enter the number of Elevators : ");
			int elevators = Integer.parseInt(br.readLine());
			
			int current[] = new int[passengers];
			int destination[] = new int[passengers];
			System.out.println("Enter the Current floor of " + passengers + " passengers seperated by space : ");
			String curr[] = br.readLine().split(" ");
			System.out.println("Enter the Destination floor of " + passengers + " passengers seperated by space : ");
			String dest[] = br.readLine().split(" ");
			
			
			for(int j=0;j<passengers;j++)
			{
				current[j] = Integer.parseInt(curr[j]);
				destination[j] =   Integer.parseInt(dest[j]);
			}
			
			Driver d = new Driver(elevators, passengers, current,destination);
			d.simulate();
			
		}
		

	}

}
