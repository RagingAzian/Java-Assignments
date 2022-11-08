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

public class HolidayBonus {
	private final static int HIGHEST_STORE_BONUS = 5000;
	private final static int LOWEST_STORE_BONUS = 1000;
	private final static int OTHER_STORE_BONUS = 2000;

	public static double[] calculateHolidayBonus(double[][] data) {
		double[][] bonus = new double[data.length][];
		for (int i = 0; i < data.length; i++) {
			bonus[i] = new double[data[i].length];
		}
		for (int i = 0; i < bonus.length; i++) {
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			for (int j = 0; j < bonus[i].length; j++) {
				if (i < bonus[j].length) {
					bonus[highIndex][i] = HIGHEST_STORE_BONUS;
					bonus[lowIndex][i] = LOWEST_STORE_BONUS;
					if (j != lowIndex && j != highIndex)
						bonus[j][i] = OTHER_STORE_BONUS;
				}
			}
		}
		double[] storeBonus = new double[data.length];
		for (int i = 0; i < bonus.length; i++) {
			for (int j = 0; j < bonus[i].length; j++) {
				storeBonus[i] += bonus[i][j];
			}
		}
		return storeBonus;
	}

	public static double calculateTotalHolidayBonus(double[][] data) {
		double[][] holidayBonusArr = new double[data.length][];
		for (int i = 0; i < data.length; i++) {
			holidayBonusArr[i] = new double[data[i].length];
		}
		for (int i = 0; i < holidayBonusArr.length; i++) {
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			for (int j = 0; j < holidayBonusArr[i].length; j++) {
				if (i < holidayBonusArr[j].length) {
					holidayBonusArr[highIndex][i] = HIGHEST_STORE_BONUS;
					holidayBonusArr[lowIndex][i] = LOWEST_STORE_BONUS;
					if (j != highIndex && j != lowIndex)
						holidayBonusArr[j][i] = OTHER_STORE_BONUS;
				}
			}

		}
		double holidayTotal = 0.0;
		for (int i = 0; i < holidayBonusArr.length; i++) {
			for (int j = 0; j < holidayBonusArr[i].length; j++) {
				holidayTotal += holidayBonusArr[i][j];
			}
		}
		return holidayTotal;
	}
}
