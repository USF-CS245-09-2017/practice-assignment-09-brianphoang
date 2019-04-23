public class BinaryHeap
{
	public int[] arr;
  public int size;
  
  public BinaryHeap()
  {
		arr = new int[1];
		size = 0;
  }
  
  //get parent index
  int parent(int index)
  {
    return (index - 1) / 2;
  }
  
  //get left child index
  int leftChild(int index)
  {
    return (index * 2) + 1;
  }
  
  //get right child index
  int rightChild(int index)
  {
    return (index * 2) + 2;
  }
  
  public void add(int item)
  {
    if(arr.length <= size)
    {
      grow();
    }
    arr[size++] = item;
    int index = size - 1;
    while(arr[index] < arr[parent(index)])
    {
      swap(index, parent(index));
      index = parent(index);
    }
  }
  
  public int remove()
  {
    int remove = arr[0];
    swap(0, --size);
    if (size != 0)
    {
      shiftDown(0);
    }
    return remove;
  }

  public void grow()
  {
		int[] newArray = new int[arr.length * 2];
		System.arraycopy(arr, 0, newArray, 0, arr.length);
		arr = newArray;
  }
  
  public void swap(int i, int j)
  {
    int temporary;
		temporary = arr[i];
		arr[i] = arr[j];
    arr[j] = temporary;
  }
  
  public void shiftDown(int pos)
  {
    if (leftChild(pos) >= size)
    {
      return;
    }
    
    //begin on left position
    int child = leftChild(pos);
    
    //set index with right child if R < L
    if (rightChild(pos) < size && arr[rightChild(pos)] < arr[child])
    {
      child = rightChild(pos); 
    }
    
    //swap index with smaller child
    //move down to smaller child
    if (arr[child] < arr[pos])
    {
      swap(child, pos);
      shiftDown(child);
    }
	}
}