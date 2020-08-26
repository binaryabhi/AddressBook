package com.info;

import java.io.*;
import java.util.*;

public interface AddressBookInterface {
	public HashMap<String, ArrayList<Person>>  addperson(String fileuse) throws IOException;

	public String editperson(String fileuse) throws FileNotFoundException, IOException;

	public String deleteperson(String fileuse) throws IOException;

	public String searchperson(String fileuse) throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException;

	public String sortbyzipperson(String fileuse) throws FileNotFoundException, IOException;

	public String sortbynameperson(String fileuse) throws FileNotFoundException, IOException;
	
	public String Display(String fileuse) throws IOException;
 
	public String acess() throws FileNotFoundException, IOException;
}

