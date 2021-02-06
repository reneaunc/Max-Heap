import java.util.*;

class HeapMax {
    // we go with arraylist instead of array for size flexibility
    private ArrayList<Integer> data;

    // default constructor
    public HeapMax() {
      data = new ArrayList<Integer>(0);
    }

    // DO NOT MODIFY THIS METHOD
    public ArrayList<Integer> getData() {
      return data;
    }

    // insert a new element and restore max heap property
    public void insert(int element) {
      data.add(element);
      int i = data.size() - 1;
      fixMax(i);
  }

    // return max
    public int getMax() {
      // remove this line
      if(!data.isEmpty()){
        return data.get(0);
      }
     else{
       //returns min value of integer if data is empty
        System.out.println("Heap is empty");
        return Integer.MIN_VALUE;
    } 
  }

    // remove max and restore max heap property
    public int removeMax() {
      // remove this line
      if(data.isEmpty()){
        //returns min value of integer if data is empty
        System.out.println("Heap is empty");
        return Integer.MIN_VALUE;
      }
      else{
        int val = data.get(0);
        data.remove(0);
        heapify(0);
        return val;
      }
    }

    // heap builder
    public void build(int[] arr) {
      for(int num: arr){
        data.add(num);
      }
      //heapify
      for(int i = data.size()/2 - 1; i >= 0; i--){
        heapify(i);
      }
    }

    // print out heap as instructed in the handout
    public void display(){
      System.out.print("Current Heap is: ");
      if (data.size() == 0){
        System.out.print("Heap is empty");
        System.out.println(".");
      }
      int level = 1;
      for (int i = 0; i < data.size(); i++){
        if(i + 1 == data.size()){
          System.out.print(data.get(i));
        }
        else{
          if(data.size() > 1){
            System.out.print(data.get(i));
            if(i + 2 == (int)Math.pow(2, level)){
              System.out.print(", ");
              level = level + 1;
            }
            else{
              System.out.print(" ");
            }
          }
        }
      }
      if (data.size() > 0){
      System.out.print(".");
      }
      System.out.println("");
    }
    // you are welcome to add any supporting methods
    //maintains max heap quality of array list data
    public int heapify(int i){
        while(2*i+1 < data.size()){ //Checks if parent node has a left child
            int maxChildIndex = maxChild(i);
            if(data.get(i) < data.get(maxChildIndex)){
                int temp = data.get(maxChildIndex);
                data.set(maxChildIndex, data.get(i));
                data.set(i, temp);
            }
            i = maxChildIndex;
    }
        return i;
  }
  //finds max child of element at index i
    public int maxChild(int i){
        int cl = 2*i+1; //left child
        int cr = 2*i + 2; //right child 
        if (cr >= data.size() || data.get(cl) > data.get(cr)){
            return cl;
        }
        else{
            return cr;
        }
    }
    //moves value at index i to top if neccesary
    public void fixMax(int i){
      while (i > 0 && (i-1)/2 >= 0) {
        if (data.get(i) > data.get((i-1)/2)) {
            int tmp = data.get(i);
            data.set(i, data.get((i-1)/2));
            data.set((i-1)/2, tmp);
        }       
        i = (i-1)/2;
    }
  }
}