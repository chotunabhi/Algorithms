package com.hackerRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class ClimbUpRank {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = climbingLeaderboard(ranked, player);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
		List<Integer> result = new LinkedList<>();
		List<Integer> distinctRanks = ranked.stream().distinct().collect(toList());

		int i = distinctRanks.size() - 1;
		int j = 0;
		int currentScore = 0;
		
		while (j < player.size() && i >= 0) {
			currentScore = player.get(j);
			
			if (currentScore == distinctRanks.get(i)) {
				result.add(i + 1);
				j++;
			} else if (currentScore < distinctRanks.get(i)) {
				result.add(i + 2);
				j++;
			} else {
				i--;
			}
		}
		
		int prevScore = currentScore;
		
		while (j < player.size()) {
			result.add(1);
			
			j++;
		}

		return result;
	}
}
