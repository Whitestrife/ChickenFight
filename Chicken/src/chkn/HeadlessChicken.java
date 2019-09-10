package chkn;

import java.util.Random;
import java.util.Scanner;

public class HeadlessChicken extends DefensiveChicken {

	Random rand = new Random();
	public HeadlessChicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stub
	}

	public int displayActions(Scanner chickenScan) {
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move in a random direction " + this.getMoveSpeed() + " spaces(I mean, you are headless)");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		return chickenScan.nextInt();
		
	}
	
	@Override
	public void Move(Character otherPlayer) {
		int direction = 1;
		if(this.currentPosX() == 9 && this.currentPosY() == 9) {
				direction = (rand.nextInt(2)+3);
		}else if(this.currentPosX() == 9 && this.currentPosY() == 0) {
			int roll = rand.nextInt(2);
			if(roll == 0) {
				direction = 0;
			}else if(roll == 1) {
				direction = 4;
			}
		}else if(this.currentPosX() == 9) {
			int roll = rand.nextInt(3);
				if(roll == 0) {
					direction = 1;
				}else if(roll == 1) {
					direction = 3;
				}else {
					direction = 4;
				}
		}else if(this.currentPosX() == 0 && this.currentPosY() == 9) {
			direction = (rand.nextInt(2)+2);
		}else if(this.currentPosX() == 0 && this.currentPosY() == 0) {
			int roll = rand.nextInt(2);
			if(roll == 0) {
				direction = 1;
			}else if(roll == 1) {
				direction = 2;
			}	
		}else if(this.currentPosX() == 0){
			direction = (rand.nextInt(3)+1);
		}else if(this.currentPosY() == 0){
			int roll = rand.nextInt(2);
				if(roll == 0) {
					direction = 1;
				}else if(roll == 1) {
					direction = 2;
				}else {
					direction = 4;
				}
		}else if(this.currentPosY() == 9) {
			direction = (rand.nextInt(3)+2);
		}else {
			direction = (rand.nextInt(4)+1);
		}
		switch (direction) {
		//North
		case 1:
			if(this.currentPosY() + this.getMoveSpeed() > 9) {
				this.setPosition(this, this.currentPosX(), 9);
			}
			else if(this.currentPosY()+this.getMoveSpeed() == otherPlayer.currentPosY()){
				this.setPosition(this, this.currentPosX(), otherPlayer.currentPosY() - 1);
			}else {
				this.setPosition(this, this.currentPosX(), this.currentPosY() + this.getMoveSpeed());
			}
			break;
		//East	
		case 2:
			if(this.currentPosX() + this.getMoveSpeed() > 9) {
				this.setPosition(this, 9, this.currentPosY());
			}
			else if(this.currentPosX()+ this.getMoveSpeed() == otherPlayer.currentPosX()){
				this.setPosition(this, otherPlayer.currentPosX() - 1, this.currentPosY());
			}else {
				this.setPosition(this, this.currentPosX() + this.getMoveSpeed(), this.currentPosY());
			}
			break;
		//South
		case 3:
			if(this.currentPosY() - this.getMoveSpeed() < 0) {
				this.setPosition(this, this.currentPosX(), 0);
			}
			else if(this.currentPosY()-this.getMoveSpeed() == otherPlayer.currentPosY()){
				this.setPosition(this, this.currentPosX(), otherPlayer.currentPosY() + 1);
			}else {
				this.setPosition(this, this.currentPosX(), this.currentPosY() - this.getMoveSpeed());
			}
			break;
		//West
		case 4:
			if(this.currentPosX() - this.getMoveSpeed() > 0) {
				this.setPosition(this, 9, this.currentPosY());
			}
			else if(this.currentPosX() - this.getMoveSpeed() == otherPlayer.currentPosX()){
				this.setPosition(this, otherPlayer.currentPosX() + 1, this.currentPosY());
			}else {
				this.setPosition(this, this.currentPosX() - this.getMoveSpeed(), this.currentPosY());
			}
			break;
		}
	}
}
