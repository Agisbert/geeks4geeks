package org.w00tdevs.phone.directory;
import java.util.List;
import java.util.Scanner;


/**
 * @author agisbert
 * 
 * Solution for -> https://practice.geeksforgeeks.org/problems/phone-directory/0
 *
 */
public class PhoneDirectoryProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int directoryLength = sc.nextInt();
			PhoneDirectory phoneDir = new PhoneDirectory();
			while(directoryLength > 0) {
				String contact = sc.next();
				phoneDir.addContact(contact);
				directoryLength--;
			}
			String query = sc.next();
			for(int j = 1; j < query.length() + 1 ; j++) {
				List<String> matches = phoneDir.getMatchesAndRemove(query.substring(0, j));
				if(matches.size() == 0) {
					System.out.println("0");
				}else {				
					System.out.println(String.join(" ", matches));
				}
			}
		}
		sc.close();
	}

}
