
public class BinaryHeap {
	int size;
	int max;
	int[] arr;
	
	public BinaryHeap(){
	//max = 100000;
	size = 1;
	arr = new int[size];
	}
	
	//add function
	public void add(int priority){
		if(arr.length == size){
			grow_heap();
		}
		arr[size++] = priority;
		int index = size -1;
		
		while(index > 0 && arr[index] < arr[parent(index)]){
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	//remove function
	public int remove(){
		//int temp = arr[0];
		swap(1, size);
		size--;
		if(size != 0){
		
			bubbledown(1);}
		
		return arr[size+1];
	}
	
	public int Lchild(int index){
		return (index*2);
	}
	
	public int Rchild(int index){
		return (index*2)+1;
	}
	private boolean isleaf(int pos){
		return ((pos > size/2) && (pos <= size)); 
	}
	public int parent(int index){
		return (index/2);	
	}
	
	//bubbledown function
	public void bubbledown(int index){
		boolean swapped = true;
		
		while(swapped && Lchild(index) < size){
			
			swapped = false;
			int child = Lchild(index);
		if(Rchild(index) < size && arr[Rchild(index)] < arr[child]){
			child = Rchild(index);
		}
		if(arr[index] > arr[child]){
			swap(index, child);
			index = child;
			swapped = true;
		}
		bubbledown(child);
		}
		
	}
	
	//swap function
	private void swap(int i, int j) {
		  int temp;
		  temp = arr[i];
		  arr[i] = arr[j];
		  arr[j] = temp;
		}
	//grow heap function
	private void grow_heap(){
		int[] newarr = new int[arr.length * 100];
		System.arraycopy(arr, 0, newarr, 0, arr.length);
		arr = newarr;
	}
	
		
	
	
}
