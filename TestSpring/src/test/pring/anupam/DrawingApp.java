package test.pring.anupam;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle= new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//Triangle triangle=  (Triangle) context.getBean("triangle");
		//Triangle triangle=  (Triangle) context.getBean("triangle-alias");
		Triangle triangle=  (Triangle) context.getBean("triangle-alias1");
		triangle.draw();
		System.out.println(triangle.toString());
	}

}
