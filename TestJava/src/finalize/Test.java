package finalize;

public abstract class  Test {
	//String count;
	public void display(Object obj){
		System.out.println(" Object");
	}
	public void display(String str){
		System.out.println("String");
		
	}
	
	public Test(String count) {
		// TODO Auto-generated constructor stub
	//	this.count = count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Test o =new Test();
		o.display(new String(""));*/
	}
	
	public static void main(int[] args) {
		/*Test o =new Test();
		o.display(new String(""));*/
	}
	
	
	/*@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println();
	}*/
}

class BCD extends Test implements EFG {

	public BCD(String count) {
		super(count);
		System.out.println(BCD.count); 
		// TODO Auto-generated constructor stub
	}
	
}

interface EFG{
	int count=0;
}

interface EFGH{
	int count=0;
}




