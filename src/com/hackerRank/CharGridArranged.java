package com.hackerRank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a square grid of characters in the range ascii[a-z], rearrange elements
 * of each row alphabetically, ascending. Determine if the columns are also in
 * ascending alphabetical order, top to bottom. Return YES if they are or NO if
 * they are not.
 * 
 * Example
 * 
 * The grid is illustrated below.
 * 
 * a b c a d e e f g The rows are already in alphabetical order. The columns a a
 * e, b d f and c e g are also in alphabetical order, so the answer would be
 * YES. Only elements within the same row can be rearranged. They cannot be
 * moved to a different row.
 * 
 * Function Description
 * 
 * Complete the gridChallenge function in the editor below.
 * 
 * gridChallenge has the following parameter(s):
 * 
 * string grid[n]: an array of strings Returns
 * 
 * string: either YES or NO Input Format
 * 
 * The first line contains , the number of testcases.
 * 
 * Each of the next sets of lines are described as follows: - The first line
 * contains , the number of rows and columns in the grid. - The next lines
 * contains a string of length
 * 
 * Constraints
 * 
 * 
 * 
 * Each string consists of lowercase letters in the range ascii[a-z]
 * 
 * Output Format
 * 
 * For each test case, on a separate line print YES if it is possible to
 * rearrange the grid alphabetically ascending in both its rows and columns, or
 * NO otherwise.
 * 
 * Sample Input
 * 
 * STDIN Function ----- -------- 1 t = 1 5 n = 5 ebacd grid = ['ebacd', 'fghij',
 * 'olmkn', 'trpqs', 'xywuv'] fghij olmkn trpqs xywuv Sample Output
 * 
 * YES Explanation
 * 
 * The x grid in the test case can be reordered to
 * 
 * abcde fghij klmno pqrst uvwxy This fulfills the condition since the rows 1,
 * 2, ..., 5 and the columns 1, 2, ..., 5 are all alphabetically sorted.
 * 
 * @author abks
 *
 */
public class CharGridArranged {
	/*
	 * Complete the 'gridChallenge' function below.
	 *
	 * The function is expected to return a STRING. The function accepts
	 * STRING_ARRAY grid as parameter.
	 */

	public static String gridChallenge(List<String> grid) {
		char[][] charGrid = new char[grid.size()][grid.size()];

		for (int i = 0; i < grid.size(); i++) {
			String str = grid.get(i);
			charGrid[i] = str.toCharArray();

			Arrays.sort(charGrid[i]);
		}

		boolean resultGrid[][] = new boolean[grid.size()][];

		for (int i = 0; i < grid.size(); i++) {
			resultGrid[i] = new boolean[charGrid[i].length];
			for (int j = 0; j < charGrid[i].length; j++) {
				if (i == 0)
					resultGrid[i][j] = true;
				else if (j == 0)
					resultGrid[i][j] = resultGrid[i - 1][j] && (charGrid[i][j] >= charGrid[i - 1][j]);
				else
					resultGrid[i][j] = resultGrid[i - 1][j - 1] && resultGrid[i - 1][j] && resultGrid[i][j - 1]
							&& (charGrid[i - 1][j] <= charGrid[i][j]);
			}
		}

		return resultGrid[grid.size() - 1][charGrid[0].length - 1] ? "YES" : "NO";
	}

	public static void main(String[] args) throws IOException {
		int num = '1'-'0';
		
		System.out.println(num);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileDescriptor.out));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<String> grid = IntStream.range(0, n).mapToObj(i -> {
					try {
						return bufferedReader.readLine();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				}).collect(Collectors.toList());

				String result = gridChallenge(grid);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
