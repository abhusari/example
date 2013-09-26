package org.anupam.test.collections;

import java.util.ArrayList;

public class SortSwap {
	static int[] arr = {100,56,65,56,65,7,5,1,23,45,45};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int out, in;
		int nElems = arr.length;
		System.out.println("Unsorted");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println("");
		// Bubble sort
		/*for(out=nElems-1; out>1; out--) {// outer loop (backward)
			System.out.println("out = "+out);
			for(in=0; in<out; in++){ // inner loop (forward)
				System.out.println("in = "+in);
				if( arr[in] > arr[in+1] ){ // out of order?
					System.out.println("Before Swap i= "+arr[in]+" and i+1="+arr[in+1]);
					swap(in, in+1); // swap them
					System.out.println("Before Swap i= "+arr[in]+" and i+1="+arr[in+1]);
				}
			}
		}*/
		int min;
		for(out=0; out<nElems-1; out++) // outer loop
		{
			min = out; // minimum
			for(in=out+1; in<nElems; in++) // inner loop
				if(arr[in] < arr[min] ) // if min greater,
					min = in; // we have a new min
			swap(out, min);
		}

		for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+",");
			}
		}

		private static void swap(int one, int two)
		{
			int temp = arr[one];
			arr[one] = arr[two];
			arr[two] = temp;
		}

	}
