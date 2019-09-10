package chkn;

import java.util.Scanner;

public class ChickenChaser extends OffensiveChicken {

	public ChickenChaser(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public int displayActions(Scanner chickenScan) {
		turnNumber++;
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		System.out.println("Press 3 for Dash(Move to the edge you are facing)");
		return chickenScan.nextInt();
	}
	
	public void SpecialAbility(Character otherPlayer) {
		switch (this.getDirection()) {
		//North
		case 1:
			this.setPosition(this, this.currentPosX(), 9);
			break;
		//East	
		case 2:
			this.setPosition(this, 9,this.currentPosY());
			break;
		//South
		case 3:
			this.setPosition(this, this.currentPosX(), 0);
			break;
		//West
		case 4:
			this.setPosition(this, 0,this.currentPosY());
			break;
		}
	}
}
	
