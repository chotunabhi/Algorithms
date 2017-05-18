package com.techgig.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * From last many years, militants infiltration keep on increasing day by day in
 * various different places especially in J & K sector. It was during one of the
 * battle between militants and Indian soldier's whose team named Alpha, one of
 * our soldier mistakenly entered into Pakistan sector after following one of
 * the militant. After some time he realized that he entered to other country
 * territory but it is too late till that time. As he can't gosame way, he tried
 * to found out a way to reach to his country. After hiding almost a dayone
 * place to another, he finally able to make a contacthis team via a satellite
 * phone. <br>
 * Alpha team uses a very unique and tricky pattern for finding a place in case
 * of search operations. Soldier know the pattern and uses his encoding trick
 * for telling his team about his location so that his location can't be easily
 * traced by the enemies. Soldier sends his location altitude and longitude in
 * small chunks and each chunk is difficult to crack. When his team get first
 * chunk, they started work on solving it and cracked the first digit of his
 * location. <br>
 * He sends his team 2 strings with glyphs, first is a special word W formed
 * with g glyphs and another sequence S ofglyphs. By finding the count of number
 * of possible appearances of the word W in sequence S, they will be able to get
 * the first digit of his location. Similarly he keeps on sending multiple times
 * this encoding chunk so that full location can be tracked by his team. <br>
 * You have given the glyphs for <b>W</b> and the sequence <b>S</b> of glyphs in
 * the message. <b>You need to help them count the number of possible
 * appearances of W in S</b>
 * 
 * @author abhi
 *
 */
public class CandidateCode1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2 = Integer.parseInt(in.nextLine().trim());
		String ip3 = in.nextLine().trim();
		String ip4 = in.nextLine().trim();
		
		System.out.println(appearanceCount(ip1, ip2, ip3, ip4));
	}

	/**
	 * 
	 * @param input1
	 *            <div>It will be the integer which tells the number of glyphs
	 *            in <b>W</b>1&lt;= <b>g </b>&lt;= 3000</div>
	 * @param input2
	 *            <div>It will be the integer which tells the number of glyphs
	 *            in the sequence <b>S</b>,<b>g</b> &lt;= |<b>S</b>| &lt;=
	 *            3000000</div>
	 * @param input3
	 *            <div>It will be a string which contains g consecutiveacters
	 *            that represent the glyphs in <b>W</b>. Validacters are a - z
	 *            and A - Z ; uppercase and lowercaseacters are considered
	 *            different.</div>
	 * @param input4
	 *            <div>It will be a string which contains |<b>S</b>|
	 *            consecutiveacters that represent the glyphs in the message.
	 *            Validacters are a - z and A - Z ; uppercase and
	 *            lowercaseacters are considered different.</div>
	 * @return <div>It will be the integer which tells the count of possible
	 *         appearances of <b>W </b>in<b> S</b>.</div>
	 */
	public static int appearanceCount(int input1, int input2, String input3, String input4) {
		int count = 0;
		char[] ip3 = input3.toCharArray();
		Arrays.sort(ip3);
		
		for (int i = 0; i < input2 - input1; i++) {
			char subString[] = input4.substring(i, i + input1).toCharArray();
			Arrays.sort(subString);
			
			if(Arrays.equals(ip3,subString)){
				count++;
			}
		}

		return count;
	}
}
