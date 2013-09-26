package org.anupam.test.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoubleBraceInitialization {
	
	public static  void testIntShort(int i){
		System.out.println("Its integer");
	}
	
	public static void testIntShort(short i){
		System.out.println("Its Short");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> tempList = new ArrayList<String>(Arrays.asList("One",
				"Two", "Three"));
		System.out.println(tempList);
		
		/*
		 * The first brace creates a new AnonymousInnerClass, the second
		 * declares an instance initializer block that is run when the anonymous
		 * inner class is instantiated. This type of initializer block is
		 * formally called an "instance initializer", because it is declared
		 * within the instance scope of the class -- "static initializers" are a
		 * related concept where the keyword static is placed before the brace
		 * that starts the block, and which is executed at the class level as
		 * soon as the class loader completes loading the class (specified at
		 * http://docs.oracle.com/javase/specs/jls/se5.0/html/classes.html#8.6)
		 * The initializer block can use any methods, fields and final variables
		 * available in the containing scope, but one has to be wary of the fact
		 * that initializers are run before constructors (but not before
		 * superclass constructors). This only works only for non-final classes
		 * because it creates an anonymous subclass.
		 */
		Set<String> VALID_CODES = new HashSet<String>() {
			{
				add("XZ13s");
				add("AB21/X");
				add("YYLEX");
				add("AR2D");
			}
		};

		List<String> list = new ArrayList<String>() {
			{
				add("XZ13s");
				add("AB21/X");
				add("YYLEX");
				add("AR2D");
			}
		};
		System.out.println(list);
		testIntShort(5);
		testIntShort((short)5);
		
	}

}
