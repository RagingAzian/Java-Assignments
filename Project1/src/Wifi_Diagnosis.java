/*
 * Class: CMSC203 
 * Instructor: David Kuijt
 * Description: Build an application that will step through some possible problems to restore internet connectivity.  
Assume that your computer uses wi-fi to connect to a router which connects to an Internet Service Provider (ISP) 
which connects to the Internet.

 * Due: 9/12/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Justin Nguyen
*/

import java.util.Scanner;

public class Wifi_Diagnosis {
	public static void main(String[] args) {
		final String[] prompts = { "Reboot the computer and try to connect", "Reboot the router and try to connect",
				"Make sure cables connecting the router are firmly plugged in and power is getting to the router",
				"Move the computer closer to the router and try to connect", "Contact your ISP" };
		Scanner scan = new Scanner(System.in);
		for (int x = 0; x < prompts.length; x++) {
			System.out.println(prompts[x]);
			System.out.print("Did that fix the problem?");
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("yes")) {
				System.exit(0);
			} else if (answer.equalsIgnoreCase("no")) {
				continue;
			} else {
				System.out.print("That is an invalid option");
				System.exit(0);
			}
		}
		scan.close();
	}
}