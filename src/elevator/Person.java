package elevator;

public class Person implements Comparable<Person>{
	
	private int person_id;
	private int current_floor;
	private int dest_floor;
	private boolean reached_dest;
	private boolean isAssigned;
	private Elevator assignedElevator;
	private Integer personCurrElevatorDiff;
	private Integer personCurrDestDiff;
	
	/*Initialization of person class
	 * Here, reached_dest and isAssigned are boolean,
	 * personCurrDestDiff represents the difference between currentfloor of person and destination floor of person
	 *  personCurrElevatorDiff represents the difference between currentfloor of person and elevator's current floor
	 */
	
	public Person(int current_floor, int dest_floor, int id) {
		super();
		this.person_id = id;
		this.current_floor = current_floor;
		this.dest_floor = dest_floor;
		this.reached_dest = false;
		this.isAssigned = false;
		this.assignedElevator = null;
		this.personCurrDestDiff = Math.abs(current_floor - dest_floor);
		this.personCurrElevatorDiff = 0;
		
	}
	
	public int getCurrent_floor() {
		return current_floor;
	}
	public void setCurrent_floor(int current_floor) {
		this.current_floor = current_floor;
	}
	public int getDest_floor() {
		return dest_floor;
	}
	public void setDest_floor(int dest_floor) {
		this.dest_floor = dest_floor;
	}

	//True if person has reached the destination
    //return:Boolean value if person object has reached the destination
	public boolean isReached_dest() {
		return reached_dest;
	}

	//Sets if the person object has reached the destination
	public void setReached_dest(boolean reached_dest) {
		this.reached_dest = reached_dest;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	
	public Elevator getAssignedElevator() {
		return assignedElevator;
	}

	public void setAssignedElevator(Elevator assignedElevator) {
		this.assignedElevator = assignedElevator;
	}
	


	public Integer getPersonCurrElevatorDiff() {
		return personCurrElevatorDiff;
	}

	public void setPersonCurrElevatorDiff(Integer personCurrElevatorDiff) {
		this.personCurrElevatorDiff = personCurrElevatorDiff;
	}

	
	/*
	 * Checks weather the person is going up or down
        return: Boolean value for direction
	 */
	public boolean directionUp() {
		
		if(this.current_floor - this.dest_floor<0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
/*
 * Overriden the compareTo method of Person class for custom comparison
 * For my logic to work, I need to do relative sorting.
 * Example : When we write "Select * from Person order by name, birthyear"
 * The order in which columns get sorted are by name first and in case of same names, then by birth year.
 * Similarly, person objects in the arraylist need to be sorted on the basis of personCurrElevatorDiff and 
 * personCurrDestDiff.
 */

	@Override
	public int compareTo(Person arg0) {
		
		int compare = personCurrElevatorDiff.compareTo(arg0.personCurrElevatorDiff);
				if(compare == 0)
				{
					compare = Integer.compare(personCurrDestDiff, arg0.personCurrDestDiff);
				}
		return compare;
	
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", current_floor=" + current_floor + ", dest_floor=" + dest_floor
				+ "]" + "\n";
	}

}

    
  
