package chkn;

import java.util.Scanner;

public class BuffaloChicken extends OffensiveChicken {

	public BuffaloChicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
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
		System.out.println("Press 3 for Buffalo Burn(50% Chance for Triple Damage or no Damage)");
		return chickenScan.nextInt();
		
	}
	
	@Override
	public void SpecialAbility(Character otherPlayer) {
		int chanceToBurn = rand.nextInt(2);
		if (chanceToBurn == 1) {
			otherPlayer.setHp(3);
		}else {
			System.out.println("Your buffalo was not spicy enough");
		}
	}

}
