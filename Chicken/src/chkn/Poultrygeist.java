package chkn;

import java.util.Scanner;

public class Poultrygeist extends OffensiveChicken {

	int otherPlayerX;
	int otherPlayerY;
	int choice = 0;
	public Poultrygeist(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
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
		System.out.println("Press 3 for Haunt(Move to the previous location of the other player)");
		choice = chickenScan.nextInt();
		return choice;
	}
	
	public void SpecialAbility(Character otherPlayer) {
		System.out.println("Special Ability does not work yet-WIP");
	}
}
