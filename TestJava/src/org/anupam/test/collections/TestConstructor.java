package org.anupam.test.collections;

import org.anupam.test.abstraction.PrivateConstructor;
import org.anupam.test.abstraction.TestInterface;

public class TestConstructor extends PrivateConstructor implements TestInterface{

	public TestConstructor(String i, int z) {
		super(i,z);
		// TODO Auto-generated constructor stub
	}
	
	 protected void get(){
		 System.out.println("Clild");
	 }

	public static void main(String[] args) {
		TestInterface constructor = new TestConstructor("5", 5);
		TestInterface constructor1 = new TestInterface() {

			@Override
			public String getData() {
				return "Hi";
			}
		};
		System.out.println(constructor1.getData());
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "";
	}
}
