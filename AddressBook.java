package com.info;

import java.io.*;
import java.util.*;

public class AddressBook implements AddressBookInterface {
//variable Declaration
	public String firstname;
	public String lastname;
	public String city;
	public String state;
	public int zipcode;
	public String phonenumber;
	public String fileuse;
	public static File file;
	public FileReader fr;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public BufferedReader br;
	public PrintWriter pw;
	public String regexphone = "[0-9]{10}";
	public String dumyphonenumber;
	int flag = 0;
	public static String path = "E:\\Pradip\\AddressBookUsingOops\\csv\\";
	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Person> personarraylist1 = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personarraylist11 = new HashMap<>(100);

	/* Add New Person */
	@Override
	public HashMap<String, ArrayList<Person>> addperson(String fileuse) throws IOException {
		System.out.println("How many data want to save in AddressBook :" + fileuse);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter First Name :");
			firstname = sc.next();
			System.out.println("Enter Last Name :");
			lastname = sc.next();
			System.out.println("Enter City :");
			city = sc.next();
			System.out.println("Enter State :");
			state = sc.next();
			System.out.println("Enter Zip Code :");
			zipcode = sc.nextInt();
			System.out.println("Enter Phone Number :");
			phonenumber = sc.next();
			boolean flag1 = phonenumber.matches(regexphone);
			while (flag1 == false) {
				System.out.println("Enter Phone Number with 10 digit between 0-9 :");
				phonenumber = sc.next();
				flag1 = phonenumber.matches(regexphone);
			}
			personarraylist1.add(
					new Person(firstname + ",", lastname + ",", city + ",", state + ",", zipcode, "," + phonenumber));
			personarraylist11.put(fileuse, personarraylist1);
		}
		return personarraylist11;
	}

	/* Edit person */
	@Override
	public String editperson(String fileuse) throws FileNotFoundException, IOException {
		System.out.println("Enter number for edit person data\n");
		String lineToFind = sc.next();
		File inFile = new File((path + fileuse + ".csv"));
		File tempFile = new File(path + fileuse + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		bw = new BufferedWriter(new FileWriter(tempFile));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.trim().contains(lineToFind)) {
				System.out.println("Data found for given number\n" + line);
				String[] persondrtails = line.split(",");
				String firstname = persondrtails[0];
				String lastname = persondrtails[1];
				System.out.println("enter the city");
				String c = sc.next();
				System.out.println("enter the State");
				String s = sc.next();
				System.out.println("enter the Zipcode");
				int z = sc.nextInt();
				String phonenumber = persondrtails[5];
				bw.write(firstname);
				bw.write("," + lastname);
				bw.write("," + c);
				bw.write("," + s);
				bw.write("," + z);
				bw.write("," + phonenumber);
				bw.newLine();
				flag++;
			} else {
				bw.write(line);
				bw.newLine();
			}

		}
		bw.close();
		br.close();
		inFile.delete();
		tempFile.renameTo(inFile);
		if (flag == 0) {
			System.out.println("Data not found in AddressBook :" + fileuse);
		} else {
			System.out.println("Data Modified Successfully..");
		}

		return null;
	}

	/* Delete Person */
	@Override
	public String deleteperson(String fileuse) throws IOException {
		System.out.println("Enter NaNumber for Delete");
		String lineToRemove = sc.next();
		File inFile = new File((path + fileuse + ".csv"));
		File tempFile = new File(path + fileuse + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;
		while ((line = br.readLine()) != null) {
			if (!line.trim().contains(lineToRemove)) {
				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();

		inFile.delete();
		System.out.println("Data deleted From AddressBook");
		tempFile.renameTo(inFile);
		System.out.println(" ");

		return null;
	}

	/* Search Person */
	@Override
	public String searchperson(String fileuse)
			throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException {
		File input = new File((path + fileuse + ".csv"));
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);
		String search, str;
		System.out.println("Please enter number for search :");
		search = ob.nextLine();
		fr = new FileReader(input);
		br = new BufferedReader(fr);
		while ((str = br.readLine()) != null) {
			if (str.contains(search))

				System.out.println("Data found: \n" + str);
			System.out.println("-------------------------------");
		}
		System.out.println("wrong Number not data found try another way ");

		fr.close();
		br.close();
		return null;
	}

	/* Sort By Zip */
	@Override
	public String sortbyzipperson(String fileuse) throws FileNotFoundException, IOException {
		File inFile = new File((path + fileuse + ".csv"));
		File inFile2 = new File((path + fileuse + "SortByzip.csv"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<Person> lines2 = new ArrayList<Person>();
		String currentLine1 = reader.readLine();
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));
		writer.write(currentLine1);
		writer.newLine();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			String[] persondrtails = currentLine.split(",");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines2.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		Collections.sort(lines2, new Sortbyzip());
		System.out.println("Data after Sort By Zip: ");
		for (Person P : lines2) {
			System.out.println(P.getFirstname() + " " + P.getLastname() + " " + P.getCity() + " " + P.getState() + " "
					+ P.getZipcode() + " " + P.getPhonenumber());
			writer.write(P.firstname);
			writer.write("," + P.lastname);
			writer.write("," + P.city);
			writer.write("," + P.state);
			writer.write("," + P.zipcode);
			writer.write("," + P.phonenumber);
			writer.newLine();
		}
		System.out.println("");
		writer.close();
		reader.close();
		return null;
	}

	/* Sort By Name */
	@Override
	public String sortbynameperson(String fileuse) throws FileNotFoundException, IOException {
		File inFile = new File((path + fileuse + ".csv"));
		File inFile2 = new File((path + fileuse + "SortByname.csv"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<Person> lines = new ArrayList<Person>();
		String currentLine1 = reader.readLine(); // for ignore the first Line
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));
		writer.write(currentLine1);
		writer.newLine();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			String[] persondrtails = currentLine.split(",");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		Collections.sort(lines, new SortByname());
		System.out.println("Data after Sort By Name: ");
		for (Person P : lines) {
			System.out.println(P.getFirstname() + " " + P.getLastname() + " " + P.getCity() + " " + P.getState() + " "
					+ P.getZipcode() + " " + P.getPhonenumber());
			writer.write(P.firstname);
			writer.write("," + P.lastname);
			writer.write("," + P.city);
			writer.write("," + P.state);
			writer.write("," + P.zipcode);
			writer.write("," + P.phonenumber);
			writer.newLine();
		}
		System.out.println("");
		writer.close();
		reader.close();
		return null;
	}

	/* Display Data */
	@Override
	public String Display(String fileuse) throws IOException {
		System.out.println("Data Present in System :");
		Scanner scanner = new Scanner(new File(path + fileuse + ".csv"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}
		System.out.println(" \n\n");
		file.exists();
		scanner.close();

		return null;
	}

	/* AddressBook Access Code */
	@Override
	public String acess() throws FileNotFoundException, IOException {
		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("======================");
		System.out.println("In which AddressBook You want to Perform Operation\n");
		fileuse = sc.next();
		file = new File(path + fileuse + ".csv");
		if (file.isFile()) {
			return fileuse;
		} else

			return null;
	}

}
