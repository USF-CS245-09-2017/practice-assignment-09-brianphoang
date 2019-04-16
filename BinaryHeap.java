public class BinaryHeap
{
	private int[] arr;
	private int size;
	
	//constructor
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
			growArray();
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
	
    private void swap(int pos1, int pos2)
    {
		int tmp;
		tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

    private void growArray()
    {
		int[] new_arr = new int[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}
    
    private void shiftDown(int pos)
    {
        if (leftChild(pos) >= size)
        {
            return;
        }

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