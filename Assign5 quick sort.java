/*
Assignment No: 5
Write a program for analysis of quick sort by using deterministic and randomized variant.

Time Complexity  : O(n log n)
Space Complexity : O(1)
*/


import java.util.*;

class Assign5{

	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int deterministicPartition(int[]arr, int low, int high){
		int pivot = arr[low];  

		int i = low;
		int j = high;

		while(i < j){
			while(arr[i] <= pivot && i < high) i++;
			while(arr[j] > pivot && j > low) j--;

			if(i < j) swap(arr, i, j);
		}

		swap(arr, low, j);

		return j;
	}

	static int randomizedPartition(int[]arr, int low, int high){
		Random rand = new Random();
        int randomPivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, low, randomPivotIndex);
		
		int pivot = arr[low];  

		int i = low;
		int j = high;

		while(i < j){
			while(arr[i] <= pivot && i < high) i++;
			while(arr[j] > pivot && j > low) j--;

			if(i < j) swap(arr, i, j);
		}

		swap(arr, low, j);

		return j;
	}

	static void deterministicQuickSort(int[] arr, int low, int high){
		if(low < high){
			int pIndex = deterministicPartition(arr, low, high);

			deterministicQuickSort(arr, low, pIndex-1);
			deterministicQuickSort(arr, pIndex+1, high);
		}
	}

	static void randomizedQuickSort(int[] arr, int low, int high){
		if(low < high){
			int pIndex = randomizedPartition(arr, low, high);

			randomizedQuickSort(arr, low, pIndex-1);
			randomizedQuickSort(arr, pIndex+1, high);
		}
	}


	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the Size of the Array N : ");
		int n = sc.nextInt();

		System.out.println("Enter the "+n+" Element of Array : ");
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		for(int i=0; i<n; i++){
			arr1[i] = sc.nextInt();
			arr2[i] = arr1[i];
		}

		deterministicQuickSort(arr1, 0, n-1);

		System.out.print("Sorted Array Using Deterministic Quick Sort : ");
		for(int i=0; i<n; i++){
			System.out.print(arr1[i] + " ");
		}


		System.out.println();

		randomizedQuickSort(arr2, 0, n-1);

		System.out.print("Sorted Array Using Randomized Quick Sort : ");
		for(int i=0; i<n; i++){
			System.out.print(arr2[i] + " ");
		}
	}
}



