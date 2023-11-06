package informatica;
 
import robocode.*; 
import robocode.Robot;
import java.awt.*; 

public class Wall_Avoider extends AdvancedRobot{
	
	int move_direction = 1; //way to move
	double field_height;  
	double field_width; 
	double wall_margin = 100; 
	boolean handling_wall_event = false; 
	
	public void run() {
		field_height = getBattleFieldHeight(); 
		field_width = getBattleFieldWidth(); 
		setAllColors(Color.cyan);
		while (true) {
			System.out.println("Close to wall? " + closeWall()); 
			System.out.println("Handling wall event? " + handling_wall_event); 
			if (closeWall() && !handling_wall_event) {
				System.out.println("Inside IF"); 
				move_direction = -move_direction;
			    handling_wall_event = true;
			} else if (!closeWall() && handling_wall_event) {
			    handling_wall_event = false;
			}	
			System.out.println("Move direction: " + move_direction); 
			setAhead(100*move_direction); 
			execute(); 
		}
	}
		
	boolean closeWall() {
		double current_x = getX(); 
		double current_y = getY(); 
		boolean too_close_to_wall = false; 

	    if (current_x < wall_margin || current_x > field_width - wall_margin || current_y < wall_margin || current_y > field_height - wall_margin) {
	        too_close_to_wall = true;
	    }
	    
	    System.out.println("Field width: " + field_width);
	    System.out.println("Field height: " + field_height);
	    
	    System.out.println("Condition 1: " + (current_x < wall_margin)); 
	    System.out.println("Condition 2: " + (current_x > field_width - wall_margin)); 
	    System.out.println("Condition 3: " + (current_y < wall_margin)); 
	    System.out.println("Condition 4: " + (current_y > field_height - wall_margin)); 
	    
	    System.out.println("Current X: " + current_x); 
	    System.out.println("Current Y: " + current_y); 
	    System.out.println("Too close to wall: " + too_close_to_wall); 
	    System.out.println("Handling wall event: " + handling_wall_event); 
	    return too_close_to_wall;
	}

}