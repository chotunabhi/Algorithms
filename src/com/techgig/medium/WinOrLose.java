package com.techgig.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WinOrLose {
/*
 * WIN or LOSE (100 Marks)
 * A new fighting game has become popular. There are N number of villains with each having some strength. There are N players in the game with each having some energy. The energy is used to kill the villains. The villain can be killed only if the energy of the player is greater than the strength of the villain.
 * Maxi is playing the game and at a particular time wants to know if it is possible for him to win the game or not with the given set of energies and strengths of players and villains. Maxi wins the game if his players can kill all the villains with the allotted energy.
 * 
 * Input Format
 * The first line of input consist of number of test cases, T.
 * The first line of each test case consist of number of villains and player, N.
 * The second line of each test case consist of the N space separated strengths of Villains.
 * The third line of each test case consist of N space separated energy of players.
 * 
 * Constraints
 * 1<= T <=10
 * 1<= N <=1000
 * 1<= strength , energy <=100000
 * 
 * Output Format
 * For each test case, Print WIN if all villains can be killed else print LOSE in separate lines.
 * 
 * Sample TestCase 1
 * Input
 * 1
 * 6
 * 112 243 512 343 90 478
 * 500 789 234 400 452 150
 * 
 * Output
 * WIN
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int numberOfTests = Integer.parseInt(bufferedReader.readLine());
			
			for(int i = 0; i < numberOfTests; i++) {
				int numberOfVillians = Integer.parseInt(bufferedReader.readLine());
				
				int villianEnergy[] = new int[numberOfVillians];
				int playerEnergy[] = new int[numberOfVillians];
				
				String villianEnergySequence = bufferedReader.readLine();
				String playerEnergySequence = bufferedReader.readLine();
				
				int j = 0;
				for(String ve : villianEnergySequence.split(" "))
					villianEnergy[j++] = Integer.parseInt(ve);
				
				j = 0;
				for(String pe : playerEnergySequence.split(" "))
					playerEnergy[j++] = Integer.parseInt(pe);
				
				System.out.println(isWin(villianEnergy,playerEnergy,numberOfVillians));
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String isWin(int[] villianEnergy, int[] playerEnergy,int numberOfVillains) {
		String gameStatus = "WIN";
		
		Arrays.sort(villianEnergy);
		Arrays.sort(playerEnergy);
		
		while(numberOfVillains-- > 0) {
			if(villianEnergy[numberOfVillains] > playerEnergy[numberOfVillains]) {
				gameStatus="LOSE";
				break;
			}
		}
		
		return gameStatus;
	}

}
