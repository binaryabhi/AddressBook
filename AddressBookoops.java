package com.info;

import java.io.*;
import java.util.*;

public class AddressBookoops {
	static File ob;
	static File file;
	static FileWriter fwriter;
	public FileReader fr;
	public static String key;
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Person> personarraylist13 = new ArrayList<Person>(100);
	public static HashMap<String, ArrayList<Person>> personarraylist17 = new HashMap<>(100);

	public static void main(String[] args) throws IOException, ReflectiveOperationException, RuntimeException {
		while (true) {
			System.out.println("1) create new Address Book \n" + "2) Open Address Book \n" + "3) Save Address Book \n"
					+ "4) Save As Address Book \n" + "5) Close Address Book \n" + "6) Quit \n"
					+ "7) Show AddressBooks\n");
			System.out.println("Please Enter Your Choice \n");
			int ch = sc.nextInt();
			AddressBookManager AddressbookManagerImplementation = new AddressBookManager();
			switch (ch) {
			case 1:
				AddressbookManagerImplementation.newaddressbook();
				break;
			case 2:
				personarraylist17 = AddressbookManagerImplementation.openaddressbook();
				Iterator it = personarraylist17.entrySet().iterator();
				while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				key=(String) pair.getKey();
				personarraylist13=(ArrayList<Person>) pair.getValue();
				}
				break;
			case 3:
				AddressbookManagerImplementation.saveaddressbook(key,personarraylist13);
				break;
			case 4:
				AddressbookManagerImplementation.saveasaddressbook();
				break;
			case 5:
				AddressbookManagerImplementation.closeaddressbook(fwriter);
				break;
			case 6:
				AddressbookManagerImplementation.quit();
				break;
			case 7:
				AddressbookManagerImplementation.showAddressBook();
				break;
			default:
				System.out.println("Wrong choice please enter choice from above menu");

			}

		}
	}
}