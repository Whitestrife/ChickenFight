package chkn;

import java.util.Random;
import java.util.Scanner;

public class OffensiveChicken extends Character {
	
	Random rand = new Random();
	int turnNumber = 0;
	int turnStart;
	
	public OffensiveChicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stun
	}
		@Override
		public int displayActions(Scanner chickenScan) {
			turnNumber++;
			System.out.println("What action would you like to take?");
			System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
			System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
			System.out.println("Press 2 to change your direction");
			System.out.println("Press 3 for Damage Boost");
			return chickenScan.nextInt();
			
		}
		
		@Override
		public void SpecialAbility(Character otherPlayer) {
			int damage = rand.nextInt(3);
			this.attack(otherPlayer, damage);
		}
		
	}
