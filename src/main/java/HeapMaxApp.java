import java.util.*;

public class HeapMaxApp{
	public static void main(String[] args) {
  // in case if you want to test your solution
  //test case 1
  int[][] test1 = {{1,2,3},{4,5,6},{3,5,8}};
  int k1 = 3;
  kthBiggest(test1, k1);
  printStatement(test1, k1);

  //test case 2	
  int[][] test2 = {{3,4,7,8},{2,4,6,9},{1,5,8,2},{2,4,12,35}};
  int k2 = 5;
  kthBiggest(test2, k2);
  printStatement(test2, k2);
}

  // return the kth largest element from matr
  // you can assume that k is between 1 and matr.length * matr[0].length
  public static int kthBiggest(int[][] matr, int k) {
    //creates a counter to count number of times max is removed
    int times = 0;
    // creates new heap
    HeapMax heap = new HeapMax();
    //builds heap out of 2d array
    for(int i = 0; i < matr.length; i++){
      for(int x = 0; x < matr[i].length; x++){
        heap.insert(matr[i][x]);
      }
    }
    //creates a condition on whhich to keep removing max k-1 times to find the kth largest element
   while(times != k - 1){
      heap.removeMax();
      times += 1;
    }
    return heap.getMax();
}
  public static void printStatement(int[][] matr, int k){
    System.out.println("Testing of kthBiggest starts.\nThe given matrix is:");
    for(int i = 0;i < matr.length;i++){
      for(int j = 0;j < matr.length-1;j++){
        System.out.print(matr[i][j]+",");
      }
      System.out.print(matr[i][matr.length-1]+"\n");
      }
    int result = kthBiggest(matr, k);
    //prints out desired print statements with correpsonding values of result and k
    if(k==1){
    System.out.println("The 1st biggest element is "+result+".");
    }
    else if(k==2){
    System.out.println("The 2nd biggest element is "+result+".");
    }
    else if(k==3){
    System.out.println("The 3rd biggest element is "+result+".");
    }
    else{
    System.out.println("The "+k+"th biggest element is "+result+".");
    }
    System.out.println("Testing of kthBiggest ends.\n");
  }
}

