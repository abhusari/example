package test.pring.anupam;

import org.hibernate.type.SetType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Required;

public class Triangle implements BeanFactoryAware{
	private String type;
	private int height;
	private Point a;
	private Point b;
	private Point c;
	private BeanFactory beanFactory;
	
	public Triangle() {
	}
	
	public Triangle(int height) {
		super();
		this.height = height;
	}

	public Triangle(String type) {
		super();
		this.type = type;
	}

	
	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}

	public String getType() {
		return type;
	}
	
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public int getHeight() {
		return height;
	}

//	public void setHeight(int height) {
//		this.height = height;
//	}

	public Point getA() {
		return a;
	}
	
	@Required
	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return this.beanFactory.getBean("b",Point.class);
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	public void draw(){
		System.out.println(getType()+" Triangle Drawn. "+getHeight());
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Triangle [type=" + type + ", height=" + height + ", a=" + a
				+ ", b=" + b + ", c=" + c + "]";
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		
	}

}
