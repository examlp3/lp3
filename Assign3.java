/*
Assignment No: 3
Write a program to solve a fractional Knapsack problem using a greedy method.

Time Complexity  : O(n log n)
Space Complexity : O(1)
*/

import java.util.*;
class Assign3{

	static class Item {
	    int value, weight;
	    Item(int x, int y){
	        this.value = x;
	        this.weight = y;
	    }
	}

	static double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr ,new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1= (double)(a.value) / (double)(a.weight);
                double r2= (double)(b.value) / (double)(b.weight);
                
                if(r1 < r2) return 1;
                else if(r1 > r2) return -1;
                else return 0;
            }
        });
        
        
        double totalValue = 0.0;
        int curWeight = 0;
        
        for(int i=0; i<n; i++){
            
            if(curWeight + arr[i].weight <= W){
                curWeight += arr[i].weight;
                totalValue += arr[i].value;
            }
            else{
                int remain = W - curWeight;
                totalValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
              }
        }
        
        return totalValue;
    }

	public static void main(String[] args){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the Size of the Array : ");
		int n = io.nextInt();

		System.out.print("Enter the Weight : ");
		int w = io.nextInt();

		System.out.println();

		Item[] item = new Item[n];
		for(int i=0; i<n; i++){
			System.out.print("Enter the "+(i+1)+" Value : ");
			int value = io.nextInt();

			System.out.print("Enter the "+(i+1)+" Weight : ");
			int weight = io.nextInt();

			item[i] = new Item(value, weight);


		}

		double ans = fractionalKnapsack(w, item, n);

		System.out.println(ans);
	}
}