package chkn;

import java.util.Scanner;

public class Game {
	
	Scanner gameScan = new Scanner(System.in);
	
	public Game() {
		
		Character player1 = characterSelect(1);
		Character player2 = characterSelect(2);
		player1.setPosition(player1,0, 0);
		player1.setDirection(1);
		player2.setPosition(player2,9, 9);
		player2.setDirection(3);
		
		while(player1.isAlive() & player2.isAlive()) {
			//Consider changing the display actions to run in this class, so that i can handle attacking in a different way
		if(player1.getDirection() == 1) {
			System.out.println("Player 1 you are facing North");
		}
		else if(player1.getDirection() == 2) {
			System.out.println("Player 1 you are facing East");
		}
		else if(player1.getDirection() == 3) {
			System.out.println("Player 1 you are facing South");
		}
		else if(player1.getDirection() == 4) {
			System.out.println("Player 1 you are facing West");
		}
		System.out.println("Player 1 Position " + (player1.currentPosX()+1) + "," + (player1.currentPosY()+ 1));
		System.out.println("**************************************");
		pauseTimer(2);
		int choice = player1.displayActions(gameScan);
		switch (choice) {
		case 0:
			player1.Move(player2);
			break;
		case 1:
			player1.attack(player2,1);
			break;
		case 2:
			player1.changeDirection(gameScan);
			break;
		case 3:
			player1.SpecialAbility(player2);
			break;
		}
		if(player2.getDirection() == 1) {
			System.out.println("Player 2 you are facing North");
		}
		else if(player2.getDirection() == 2) {
			System.out.println("Player 2 you are facing East");
		}
		else if(player2.getDirection() == 3) {
			System.out.println("Player 2 you are facing South");
		}
		else if(player2.getDirection() == 4) {
			System.out.println("Player 2 you are facing West");
		}
		System.out.println("Player 2 Position " + (player2.currentPosX()+1) + "," + (player2.currentPosY()+1));
		System.out.println("**************************************");
		pauseTimer(2);
		choice = player2.displayActions(gameScan);
		switch (choice) {
		case 0:
			player2.Move(player1);
			break;
		case 1:
			player2.attack(player1,1);
			break;
		case 2:
			player2.changeDirection(gameScan);
			break;
		case 3:
			player2.SpecialAbility(player1);
			break;
		}
		}
		
	}
	
	private Character characterSelect(int playerNumber) {
		int choice = 0;
		System.out.println("Choose a Character: 1, 2, 3");
		System.out.println("1 is Standard Chicken");
		System.out.println("2 is Defensive Chicken Classes");
		System.out.println("3 is Offensive Chicken Classes");
		int secondChoice = 0;
		choice = gameScan.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("You are playing Traditional Chicken!");
			return new Chicken(true, 5, 2, 2, "Player " + playerNumber);
		
		case 2:
			System.out.println("Choose a Character: 1, 2, 3");
			System.out.println("1 is Headless Chicken");
			System.out.println("2 is Mind-Control Chicken");
			System.out.println("3 is Chicken Cordon Bleu");
			secondChoice = gameScan.nextInt();
			switch(secondChoice) {
			case 1:
				System.out.println("You are playing Headless Chicken!");
				return new HeadlessChicken(true, 5, 4, 2, "Player " + playerNumber);
			case 2:
				System.out.println("You are playing Mind-Control Chicken!");
				return new MindControlChicken(true, 5, 2, 2, "Player " + playerNumber);
			case 3:
				System.out.println("You are playing Chicken Cordon Bleu");
				return new ChickenCordonBleu(true, 5, 2, 2, "Player " + playerNumber);
			}
		
		case 3:
			System.out.println("Choose a Character: 1, 2, 3");
			System.out.println("1 is Buffalo Chicken");
			System.out.println("2 is Chicken Chaser");
			System.out.println("3 is Poultrygeist(Work-in-progress)");
			secondChoice = gameScan.nextInt();
			switch(secondChoice) {
			case 1:
				System.out.println("You are playing Buffalo Chicken!");
				return new BuffaloChicken(true, 5, 2, 2, "Player " + playerNumber);
			case 2:
				System.out.println("You are playing Chicken Chaser!");
				return new ChickenChaser(true, 5, 2, 2, "Player " + playerNumber);
			case 3:
				System.out.println("You are playing Poultrygeist");
				return new Poultrygeist(true, 5, 2, 2, "Player " + playerNumber);
			}
		}
		return null;
		
	}
	
	private void pauseTimer(int seconds) {
		int timeFrame = seconds * 1000;
		try {
			Thread.sleep(timeFrame);
		} 
		catch (InterruptedException ie) {
		System.out.println("I had a pausing error");		
		}
	}
}
