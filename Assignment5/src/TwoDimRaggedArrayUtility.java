/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: Holiday Bonus
 * Due: 11/7/2022
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Justin Nguyen
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	public static double[][] readFile(File file) {
		double[][] raggedArr = new double[6][];
		String line;
		int i = 0;
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				String[] data = line.split(" ");
				raggedArr[i] = new double[data.length];
				for (int x = 0; x < data.length; x++) {
					raggedArr[i][x] = Double.parseDouble(data[x]);
				}
				i++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		return raggedArr;
	}

	public static void writeToFile(double[][] data, File outputFile) {
		try {
			FileWriter file = new FileWriter(outputFile);
			for (int x = 0; x < data.length; x++) {
				for (int y = 0; y < data[x].length; y++) {
					file.write(data[x][y] + " ");
				}
				file.write("\n");
			}
			file.close();
		} catch (Exception e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}

	public static double getTotal(double[][] data) {
		double total = 0;
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[x].length; y++) {
				total += data[x][y];
			}
		}
		return total;
	}

	public static double getAverage(double[][] data) {
		double total = 0;
		int numOfElements = 0;
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[x].length; y++) {
				total += data[x][y];
				numOfElements++;
			}
		}
		return (total / numOfElements);
	}

	public static double getRowTotal(double[][] data, int rowIndex) {
		double total = 0;
		for (int x = 0; x < data[rowIndex].length; x++) {
			total += data[rowIndex][x];
		}

		return total;
	}

	public static double getColumnTotal(double[][] data, int colIndex) {
		double total = 0;
		for (int x = 0; x < data.length; x++)
			if (colIndex <= data[x].length - 1)
				total += data[x][colIndex];
		return total;
	}

	public static double getHighestInRow(double[][] data, int rowIndex) {
		double max = data[rowIndex][0];
		for (int x = 0; x < data[rowIndex].length; x++) {
			if (data[rowIndex][x] > max)
				max = data[rowIndex][x];
		}
		return max;
	}

	public static int getHighestInRowIndex(double[][] data, int rowIndex) {
		double max = data[rowIndex][0];
		int maxIndex = 0;
		for (int x = 0; x < data[rowIndex].length; x++) {
			if (data[rowIndex][x] > max) {
				max = data[rowIndex][x];
				maxIndex = x;
			}
		}
		return maxIndex;
	}

	public static double getLowestInRow(double[][] data, int rowIndex) {
		double min = data[rowIndex][0];
		for (int x = 0; x < data[rowIndex].length; x++) {
			if (data[rowIndex][x] < min)
				min = data[rowIndex][x];
		}
		return min;
	}

	public static int getLowestInRowIndex(double[][] data, int rowIndex) {
		double min = data[rowIndex][0];
		int minIndex = 0;
		for (int x = 0; x < data[rowIndex].length; x++) {
			if (data[rowIndex][x] < min) {
				min = data[rowIndex][x];
				minIndex = x;
			}
		}
		return minIndex;
	}

	public static double getHighestInColumn(double[][] data, int colIndex) {
		double max = 0;
		for (int x = 0; x < data.length; x++) {
			if (data[x].length > colIndex) {
				max = data[x][colIndex];
				break;
			}
		}

		for (int x = 0; x < data.length; x++) {
			if (colIndex < data[x].length) {
				if (data[x][colIndex] > max) {
					max = data[x][colIndex];
				}
			}

		}
		return max;
	}

	public static int getHighestInColumnIndex(double[][] data, int colIndex) {
		double max = 0;
		int maxIndex = 0;
		for (int x = 0; x < data.length; x++) {
			if (data[x].length >= colIndex) {
				maxIndex = x;
				break;
			}
		}

		for (int x = 0; x < data.length; x++) {
			if (colIndex < data[x].length) {
				if (data[x][colIndex] > max) {
					max = data[x][colIndex];
					maxIndex = x;
				}
			}
		}
		return maxIndex;
	}

	public static double getLowestInColumn(double[][] data, int colIndex) {
		double min = 0;
		for (int x = 0; x < data.length; x++) {
			if (data[x].length > colIndex) {
				min = data[x][colIndex];
				break;
			}
		}

		for (int x = 0; x < data.length; x++) {
			if (colIndex < data[x].length) {
				if (data[x][colIndex] < min) {
					min = data[x][colIndex];
				}
			}
		}
		return min;
	}

	public static int getLowestInColumnIndex(double[][] data, int colIndex) {
		double min = 0;
		int minIndex = 0;
		for (int x = 0; x < data.length; x++) {
			if (data[x].length > colIndex) {
				minIndex = x;
				break;
			}
		}
		for (int x = 0; x < data.length; x++) {
			if (colIndex < data[x].length) {
				if (data[x][colIndex] < min) {
					min = data[x][colIndex];
					minIndex = x;
				}
			}
		}
		return minIndex;
	}

	public static double getHighestInArray(double[][] data) {
		double max = data[0][0];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[x].length; y++) {
				if (data[x][y] > max)
					max = data[x][y];
			}
		}
		return max;
	}

	public static double getLowestInArray(double[][] data) {
		double min = data[0][0];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[x].length; y++) {
				if (data[x][y] < min)
					min = data[x][y];
			}
		}
		return min;
	}
}