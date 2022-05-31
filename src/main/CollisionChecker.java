package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	public void checkTile(Entity entity) {
		
		
		
		switch(entity.direction){
		case "up":
			
			break;
		case "down":
			break;
		case "left":
			break;
		case "right":
			break;
		}
		 
	}
}
