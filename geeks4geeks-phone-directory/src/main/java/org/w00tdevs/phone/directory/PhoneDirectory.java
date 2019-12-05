package org.w00tdevs.phone.directory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author agisbert
 *
 */
public class PhoneDirectory{

	private Set<String> contacts;

	public PhoneDirectory() {
		super();
		this.contacts = new TreeSet<String>();
	}

	public void addContact(String contact) {
		this.contacts.add(contact);
	}

	public void addAllContacts(String[] contactsArray) {
		this.contacts.addAll(Arrays.asList(contactsArray));
	}

	public List<String> getMatchesAndRemove(String prefix){
		List<String> auxList = new ArrayList<String>();
		boolean found = false;
		for(String contact : contacts){
			if(contact.startsWith(prefix)) {
				auxList.add(contact);
				found = true;
			} else {
				if(found) {
					break;
				}
			}
		}
		this.contacts.retainAll(auxList);
		return auxList;
	}

}