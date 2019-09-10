package chkn;

import java.util.Scanner;

public class DefensiveChicken extends Character {

	int turnNumber = 0;
	int turnStart;
	boolean abilityUsed;
	
	public DefensiveChicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int displayActions(Scanner chickenScan) {
		turnNumber++;
		if((turnNumber - turnStart) > 3) {
			abilityUsed = false;
		}
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		System.out.println("Press 3 for Range Cripple");
		return chickenScan.nextInt();
		
	}
	
	@Override
	public void SpecialAbility(Character otherPlayer) { //TODO-Find a way to manage turn number to deactivate debuff
		turnStart = turnNumber;
		if(!abilityUsed) {	
		otherPlayer.setMoveSpeed(-1);
		abilityUsed = true;
		}
		
	}

}
