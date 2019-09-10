package chkn;

import java.util.Scanner;

public class Chicken extends Character {
	
	private boolean canLeap = true;

	public Chicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		
	}
	@Override
	public int displayActions(Scanner chickenScan) {
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		if(canLeap) {
		System.out.println("Press 3 for ChickenLeap");
		}
		
		return chickenScan.nextInt();
		
	}
	@Override
	//Reworked movement to pass in opposite player to avoid collision
	public void SpecialAbility(Character otherPlayer) {
		//Double movespeed for 1 turn on a cooldown
		int speedChange = 1;
		this.setMoveSpeed(speedChange);
		super.Move(otherPlayer);
		this.setMoveSpeed(-speedChange);
		canLeap = false;
	}

}
