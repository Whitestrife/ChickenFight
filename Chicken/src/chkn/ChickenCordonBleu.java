package chkn;

import java.util.Scanner;
import java.util.Random;

public class ChickenCordonBleu extends DefensiveChicken {

	Random rand = new Random();
	
	public ChickenCordonBleu(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int displayActions(Scanner chickenScan) {
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		System.out.println("Passive Chance to Block Damage");
		return chickenScan.nextInt();
	}
	
	public void setHp(int damageIn) {
		if (rand.nextInt(10) > 6) {
			damageIn = 0;
		}
		super.setHp(damageIn);
	}
}
