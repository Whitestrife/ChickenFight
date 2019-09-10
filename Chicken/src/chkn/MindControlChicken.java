package chkn;

import java.util.Scanner;

public class MindControlChicken extends DefensiveChicken {

	public MindControlChicken(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		super(isPlayer, maxHp, moveSpeed, attackDistance, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int displayActions(Scanner chickenScan) {
		System.out.println("What action would you like to take?");
		System.out.println("Press 0 to move " + this.getMoveSpeed() + " spaces");
		System.out.println("Press 1 for Attack at a distance of " + this.getAttackDistance() + " spaces");
		System.out.println("Press 2 to change your direction");
		System.out.println("Press 3 for Move Other Player(direction they are already facing)");
		return chickenScan.nextInt();
	}
	
	public void SpecialAbility(Character otherPlayer) {
		switch (otherPlayer.getDirection()) {
		//North
		case 1:
			if(otherPlayer.currentPosY() + otherPlayer.getMoveSpeed() > 9) {
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), 9);
			}
			else if(otherPlayer.currentPosY()+otherPlayer.getMoveSpeed() == this.currentPosY()){
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), this.currentPosY()-1);
			}else {
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), (otherPlayer.currentPosY() + otherPlayer.getMoveSpeed()));
			}
			break;
		//East	
		case 2:
			if(otherPlayer.currentPosX() + otherPlayer.getMoveSpeed() > 9) {
				otherPlayer.setPosition(otherPlayer, 9, otherPlayer.currentPosY());
			}
			else if(otherPlayer.currentPosX()+otherPlayer.getMoveSpeed() == this.currentPosX()){
				otherPlayer.setPosition(otherPlayer, this.currentPosX() - 1, otherPlayer.currentPosY());
			}else {
				otherPlayer.setPosition(otherPlayer, (otherPlayer.currentPosX() + otherPlayer.getMoveSpeed()), otherPlayer.currentPosY());
			}
			break;
		//South
		case 3:
			if(otherPlayer.currentPosY() - otherPlayer.getMoveSpeed() < 0) {
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), 0);
			}
			else if(otherPlayer.currentPosY()-otherPlayer.getMoveSpeed() == this.currentPosY()){
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), this.currentPosY()+1);
			}else {
				otherPlayer.setPosition(otherPlayer, otherPlayer.currentPosX(), (otherPlayer.currentPosY() - otherPlayer.getMoveSpeed()));
			}
			break;
		//West
		case 4:
			if(otherPlayer.currentPosX() - otherPlayer.getMoveSpeed() < 0) {
				otherPlayer.setPosition(otherPlayer, 0, otherPlayer.currentPosY());
			}
			else if(otherPlayer.currentPosX()-otherPlayer.getMoveSpeed() == this.currentPosX()){
				otherPlayer.setPosition(otherPlayer, this.currentPosX() + 1, otherPlayer.currentPosY());
			}else {
				otherPlayer.setPosition(otherPlayer, (otherPlayer.currentPosX() - otherPlayer.getMoveSpeed()), otherPlayer.currentPosY());
			}
			break;
		}
	}
}
