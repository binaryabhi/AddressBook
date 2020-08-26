package com.info;


import java.util.Comparator;

public class SortByname  implements  Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return (o1.getFirstname()).compareTo(o2.getFirstname());
	}

}
