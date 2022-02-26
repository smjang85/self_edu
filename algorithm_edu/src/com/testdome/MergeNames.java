package com.testdome;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

	public static String[] uniqueNames(String[] names1, String[] names2) {
		Set<String> data = new HashSet<>();

        for(String spell: names1){
        	data.add(spell);
        }
        
        for(String spell: names2){
        	data.add(spell);
        }
        String[] result = data.toArray(new String[data.size()]);
    	return result;
    }

	public static void main(String[] args) {
		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma,
																						// Olivia, Sophia
	}
}