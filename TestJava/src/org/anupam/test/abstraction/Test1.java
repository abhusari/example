package org.anupam.test.abstraction;

public class Test1 extends Test {

	@Override
	public void getAbstractData() {
		System.out.println("getAbstractData Test1");
	}
	public void getAbstractData4() {
	}
	
	public void getData(){
		System.out.println("getData");
	}
	@Override
	public void getAbstractData1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAbstractData2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAbstractData3() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.getAbstractData();
	}
}

abstract class Testabstract {
	public abstract void getAbstractData();
	public abstract void getAbstractData1();
	public abstract void getAbstractData2();
	public abstract void getAbstractData3();
	public void getData(){
		System.out.println("getData");
	}
}

abstract class  Test extends Testabstract {

	@Override
	public void getAbstractData() {
		System.out.println("getAbstractData");
	}
	public abstract void getAbstractData4();
	
	public void getData(){
		System.out.println("getData");
	}
}


