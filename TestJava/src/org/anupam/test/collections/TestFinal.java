package org.anupam.test.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class TestFinal implements Cloneable{
    public static String name = "Anupam";
    static  {
    	System.out.println("Invoked static block");
    }
    int num;
	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Invoked main block");
		System.out.println(TestFinal.name);
		TestFinal final1 = new TestFinal();
		final1.num = 5;
		TestFinal final2 = (TestFinal) final1.clone();
		System.out.println(final2.num);
		
		Hashtable hashtable = new Hashtable();
		//hashtable.put(null, "asdfasdf");
		//hashtable.put("afsasf", null);
		System.out.println(hashtable);
		HashMap hashMap = new HashMap();
		hashMap.put(null, "asdad");
		hashMap.put("afsasf", null);
		System.out.println(hashMap);
		//TestFinal.name = "Origin";
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(2);
		
		Set<Integer> set1 = new HashSet<Integer>();
		set.add(4);
		set.add(2);
		set.add(6);
		set.add(8);
		set.add(0);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.addAll(set1);
		set2.addAll(set);
		System.out.println(set2);
		
		FreeMaker freeMaker = new FreeMaker() {
		};
		
	}

}
