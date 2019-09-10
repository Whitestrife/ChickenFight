package chkn;

import java.util.Scanner;

public abstract class Character {

	private int maxHp, currentHp, moveSpeed, attackDistance, direction;
	//public int[][] position = new int [10][10];
	private int posX, posY;
	private boolean isPlayer;
	private String name;
	
	public Character(boolean isPlayer, int maxHp, int moveSpeed, int attackDistance, String name) {
		this.isPlayer = isPlayer;
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.moveSpeed = moveSpeed;
		this.attackDistance = attackDistance;
		this.name = name;
	}

	public void Move(Character otherPlayer) {
		switch (direction) {
		//North
		case 1:
			if(posY + moveSpeed > 9) {
				posY = 9;
			}
			else if(posY+moveSpeed == otherPlayer.currentPosY()){
				posY = otherPlayer.currentPosY() - 1;
			}else {
				posY += moveSpeed;
			}
			break;
		//East	
		case 2:
			if(posX + moveSpeed > 9) {
				posX = 9;
			}
			else if(posX+moveSpeed == otherPlayer.currentPosX()){
				posX = otherPlayer.currentPosX() - 1;
			}else {
				posX += moveSpeed;
			}
			break;
		//South
		case 3:
			if(posY - moveSpeed < 0) {
				posY = 0;
			}
			else if(posY-moveSpeed == otherPlayer.currentPosY()){
					posY = otherPlayer.currentPosY() + 1;
			}else {
				posY -= moveSpeed;
			}
			break;
		//West
		case 4:
			if(posX - moveSpeed < 0) {
				posX = 0;
			}
			else if(posX-moveSpeed == otherPlayer.currentPosX()){
				posX = otherPlayer.currentPosX() + 1;
			}else {
				posX -= moveSpeed;
			}
			break;
		}
	}
	
	public void attack(Character defender, int damage) {
		int attackX = 0;
		int attackY = 0;
		switch (this.direction) {
		//North
		case 1:
			if(this.posY - this.attackDistance < 0) {
				attackY = 0;
			}else {
				attackY = this.posY - this.attackDistance;
			}
			if(Math.abs(attackY - defender.currentPosY()) <= 2 && this.posX == defender.posX ) {
				defender.setHp(damage);
				System.out.println("Target hit. CurrentHP: " + defender.getHp());
			}
			break;
		//East	
		case 2:
			if(this.posX + this.attackDistance > 9) {
				attackX = 9;
			}else {
				attackX = this.posX + this.attackDistance;
			}
			if(Math.abs(attackX - defender.currentPosX()) <= 2 && this.posY == defender.posY) {
				defender.setHp(damage);
				System.out.println("Target hit. CurrentHP: " + defender.getHp());
			}
			break;
		//South
		case 3:
			if(this.posY + this.attackDistance > 9) {
				attackY = 9;
			}else {
				attackY = this.posY + this.attackDistance;
			}
			if(Math.abs(attackY - defender.currentPosY()) <= 2 && this.posX == defender.posX) {
				defender.setHp(damage);
				System.out.println("Target hit. CurrentHP: " + defender.getHp());
			}
			break;
		//West
		case 4:
			if(this.posX - this.attackDistance < 0) {
				attackX = 0;
			}else {
				attackX = this.posX - this.attackDistance;
			}
			if(Math.abs(attackX - defender.currentPosX()) <= 2 && this.posY == defender.posY) {
				defender.setHp(damage);
				System.out.println("Target hit. CurrentHP: " + defender.getHp());
			}
			break;
		}
	}
	
	public void changeDirection(Scanner scan) {
		this.direction = scan.nextInt();
	}
	
	public void setDirection(int dirValue) {
		this.direction = dirValue;
	}
	
	public int currentPosX() {
		return posX;
	}
	
	public int currentPosY() {
		return posY;
	}
	
	public void setPosition(Character player, int x, int y) {
		posX = x;
		posY = y;
		System.out.println(player.name + " position " + (this.posX + 1) + "," + (this.posY + 1));
	}
	
	public void setHp(int damageIn) {
		this.currentHp -= damageIn;
		if(this.currentHp > this.maxHp) {
			this.currentHp = this.maxHp;
		}
	}
	
	public int getHp() {
		return this.currentHp;
	}
	
	public int getMoveSpeed() {
		return this.moveSpeed;
	}
	
	public void setMoveSpeed(int moveSpeedAugment) {
		this.moveSpeed += moveSpeedAugment;
	}
	
	public int getAttackDistance() {
		return this.attackDistance;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public boolean isAlive() {
		if(this.currentHp > 0) {
			return true;
		}
			{
			return false;
		}
	}
	
	public void SpecialAbility(Character otherPlayer) {
		
	}
	
	public int displayActions(Scanner scan) {
		return 0;
	}
}
