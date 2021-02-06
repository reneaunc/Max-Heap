import java.util.*;

public class HeapMaxTest{
	public static void main(String[] args) {

		// test one
		System.out.println("Testing of HeapMax starts.");
		HeapMax h = new HeapMax();
		int[] arr = {5, 6, 3, 4};
		for (int num : arr) {
			System.out.println("Insert " + num);
			h.insert(num);
			h.display();
		}
		System.out.println("Remove Max");
		h.removeMax();
		h.display();
		System.out.println("Testing of HeapMax ends.");

		// test two
 		System.out.println("Testing of HeapMax starts.");
		HeapMax A = new HeapMax();
		int[] arr1 = {8, 7, 9, 10, 2, 4, 7};
		for (int num : arr1) {
			System.out.println("Insert " + num);
			A.insert(num);
			A.display();
			if(num % 2 == 0){
				System.out.println("Remove Max");
				A.removeMax();
				A.display();
			}
		}
		System.out.println("Testing of HeapMax ends.");
		//test three
		System.out.println("Testing of HeapMax starts.");
		HeapMax B = new HeapMax();
		int count = 0;
		int[] arr2 = {2, 5, 7, 2, 5, 8, 4, 1, 5, 8};
		for (int num : arr2) {
			System.out.println("Insert " + num);
			B.insert(num);
			B.display();
			count = count + arr2[num];
			if(count > 15){
				System.out.println("Remove Max");
				B.removeMax();
				B.display();
				count = count - num;
			}
		}
		System.out.println("Testing of HeapMax ends.");
	}
}
