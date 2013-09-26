package org.anupam.test.threads;

import java.util.Map;
import java.util.HashMap;

/**
 * JavaHeapLeakSimulator
 * @author Pierre-Hugues Charbonneau
 * http://javaeesupportpatterns.blogspot.com
 */
public class JavaHeapLeakSimulator {

	private final static int NB_ITERATIONS = 5000000;

	// ~1 KB data footprint
	private final static String LEAKING_DATA_PREFIX = "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

	// Map used to stored our leaking String instances
	private static Map<String, String> leakingMap;

	static {
		leakingMap = new HashMap<String, String>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Java Heap Leak Simulator 1.0");
		System.out.println("Author: Pierre-Hugues Charbonneau");
		System.out.println("http://javaeesupportpatterns.blogspot.com/");

		try {

			for (int i = 0; i < NB_ITERATIONS; i++) {

				String data = LEAKING_DATA_PREFIX + i;
				
				// Add data to our leaking Map data structure...
				leakingMap.put(data, data);
				
				// Slowdown the Java program so we can monitor the leak before the OutOfMemoryError condition
				//Thread.sleep(1);
			}

		} catch (Throwable any) {
			if (any instanceof java.lang.OutOfMemoryError) {
				System.out.println("OutOfMemoryError triggered! "
						+ any.getMessage() + " [" + any + "]");

			} else {
				System.out.println("Unexpected Exception! " + any.getMessage()
						+ " [" + any + "]");
			}
		}

		System.out.println("JavaHeapLeakSimulator done!");
	}
}