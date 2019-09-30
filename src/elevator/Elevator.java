
package elevator;

public class Elevator {

	private int elevator_id;
    private Person assigned;
    private int curr_floor;
	
    //Initialization of the elevator class. assigned is Null and current floor is 1
	public Elevator(int elevator_id) {
		this.elevator_id = elevator_id;
		this.assigned = null;
		this.curr_floor = 1;
	}

	//getters and setters
	public int getElevator_id() {
		return elevator_id;
	}

	public void setElevator_id(int elevator_id) {
		this.elevator_id = elevator_id;
	}

	public Person getAssigned() {
		return assigned;
	}

	public void setAssigned(Person assigned) {
		this.assigned = assigned;
	}

	public int getCurr_floor() {
		return curr_floor;
	}

	public void setCurr_floor(int curr_floor) {
		this.curr_floor = curr_floor;
	}
	
	//Checks if the elevator is free or not
    //return: True if no person object is assigned to the elevator
	public boolean isFree()
	{
		if(assigned == null)
			return true;
		else
			return false;
	}
	
	//Moves elevator up or down depending on person direction
	public void move() {
		
		if(assigned == null)
			return;
		
		if(this.curr_floor == this.assigned.getDest_floor())
		{
			this.assigned.setReached_dest(true);
			this.assigned = null;
			return;
		}
		if(this.assigned.directionUp()) {
			this.curr_floor++;
		}
		else
		{
			this.curr_floor--;
		}
		
		this.assigned.setCurrent_floor(this.curr_floor);
		
	}
	
}




   


   