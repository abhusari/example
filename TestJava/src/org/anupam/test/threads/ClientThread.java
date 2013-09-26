package org.anupam.test.threads;

public class ClientThread {
	public static void main(String[] args) {
		System.out.println("Method main() runs in thread " +
				Thread.currentThread().getName()); // (5) Current thread
		CounterThread counterA = new CounterThread("Counter A"); // (6) Create a thread.
		CounterThread counterB = new CounterThread("Counter B"); // (7) Create a thread.
		System.out.println("Exit from main() method.");
	}
}