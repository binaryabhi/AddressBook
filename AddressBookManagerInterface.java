package com.info;

import java.io.*;
import java.util.*;

public interface AddressBookManagerInterface {

	public File newaddressbook() throws IOException;

	public HashMap<String, ArrayList<Person>> openaddressbook() throws ReflectiveOperationException, RuntimeException, IOException;

	public void saveaddressbook(String key,ArrayList<Person> personarraylist13) throws IOException;

	public void saveasaddressbook();

	public void closeaddressbook(FileWriter fwriter) throws IOException;

	public void quit();
	
	public void showAddressBook();

}
