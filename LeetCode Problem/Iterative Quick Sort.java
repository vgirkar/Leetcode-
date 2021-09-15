import java.util.Stack;

//Time Compexity : O(N2);
//Space Complexity : O(logn)

class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    {
        int pivot = arr[h];
        int i = (l - 1);
        for(int j = l; j <= h-1; j++ ) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivot);
        return (i + 1);


        }

  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    {  int[] stack = new int[h - l + 1];

        //initialize the top of the stack
        int top = -1;
        //push elements into the stack
        stack[++top] = l;
        stack[++top] = h;

        // pop elements from the stack while stack is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];


            int p = partition(arr, l, h);

            //Push the left subarray elements to the left of the stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            //Push the right subarray elements to the right of the stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }

        }
        //Try using Stack Data Structure to remove recursion.
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 