
/*Assumptions:
1. Each elevator can hold only one person
2. Initially all elevators are at ground floor in this case 1
3. Priority is decided as follows to reduce how many times the elevator moves
    A. Closest to the elevator 
    B. Have small difference between current floor and destination floor
4. Elevator can move only one floor up/down in one count cycle
5. Cost is the total number of floors the elevators move
6. It takes one count cycle for a person to board the elevator
*/

package elevator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
	
	private int numOfElevators;
	private int numOfPersons;
	private ArrayList<Person> persons;
	private ArrayList<Elevator> elevators;
	
	private int[] currentfloor;
	private int[] dest_floor;
	
	//to count the cycles
	private int counter;
	
	public Driver(int numOfElevators, int numOfPersons, int[] currentfloor,
			int[] dest_floor) throws Exception {
		super();
		this.numOfElevators = numOfElevators;
		this.numOfPersons = numOfPersons;
		this.counter = 0;
		this.currentfloor = currentfloor;
		this.dest_floor = dest_floor;
		this.persons = new ArrayList<Person>();
		this.elevators = new ArrayList<Elevator>();
	
		/* Exception: when the length of `current_floor`, `destination_floor` and number of persons are
        different.*/
		
		if(numOfPersons!= currentfloor.length || numOfPersons!= dest_floor.length)
		{
			throw new Exception("Lengths for number of persons or number of current floors or number of destination floors are different");
			
		}
		
		//
		for(int i = 0; i < numOfPersons; i++)
		{
			this.persons.add(new Person(this.currentfloor[i],this.dest_floor[i],i+1));
		}
		
		for(int i = 0; i < numOfElevators; i++)
		{
			this.elevators.add(new Elevator(i+1));
		}
		
	}
	
	public int getNumOfElevators() {
		return numOfElevators;
	}
	public void setNumOfElevators(int numOfElevators) {
		this.numOfElevators = numOfElevators;
	}
	public int getNumOfPersons() {
		return numOfPersons;
	}
	public void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}
	
	//Runs the simulation of the whole system in simulate method
	public void simulate() {
		
		 	while(this.persons.size()!=0)
		 	{
		 		
		 		for (Elevator elevator :this.elevators) {
		 			
		 			if(elevator.isFree()) {
		 				for(Person p : this.persons)
		 				{

		 					p.setAssignedElevator(elevator);
		 					p.setPersonCurrElevatorDiff(Math.abs(p.getCurrent_floor() - elevator.getCurr_floor()));
		 				}
		 				Collections.sort(this.persons);
		 				elevator.setAssigned(this.persons.get(0));
		 				System.out.println("Person : " + this.persons.get(0) + " " + "is assigned elevator :  " + this.persons.get(0).getAssignedElevator().getElevator_id());
		 			}
		 			elevator.move();
		 		}
		 		
		 		/*I didnot use the Iterator for removing elements, 
		 		 * because the elements are being modified by Collections.sort and 
		 		 * Concurrentmodification exception will occur
		 		 */
		 		List<Person> toRemove = new ArrayList<Person>();
		 		for (Person persontemp : this.persons) {
		 		    if (persontemp.isReached_dest()) {
		 		        toRemove.add(persontemp);
		 		    }
		 		}
		 		this.persons.removeAll(toRemove);
		 		
		 		toRemove.clear();
		 		
		 		this.counter++;
		 		
		 	}
		 	
		 	System.out.println("Counter : " + counter);
	}

}



