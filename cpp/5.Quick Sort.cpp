/*
Assignment No: 5
Write a program for analysis of quick sort by using deterministic and randomized variant.
Time Complexity  : O(n log n)
Space Complexity : O(1)
*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;
// Function to swap two elements
void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}
// Deterministic partition
int deterministicPartition(vector<int> &arr, int low, int high)
{
    int pivot = arr[low];
    int i = low;
    int j = high;
    while (i < j)
    {
        while (arr[i] <= pivot && i < high)
            i++;
        while (arr[j] > pivot && j > low)
            j--;
        if (i < j)
            swap(arr[i], arr[j]);
    }
    swap(arr[low], arr[j]);
    return j;
}

// Randomized partition
int randomizedPartition(vector<int> &arr, int low, int high)
{
    int randomPivotIndex = rand() % (high - low + 1) + low;
    swap(arr[low], arr[randomPivotIndex]);

    int pivot = arr[low];
    int i = low;
    int j = high;

    while (i < j)
    {
        while (arr[i] <= pivot && i < high)
            i++;
        while (arr[j] > pivot && j > low)
            j--;
        if (i < j)
            swap(arr[i], arr[j]);
    }
    swap(arr[low], arr[j]);
    return j;
}

// Deterministic QuickSort
void deterministicQuickSort(vector<int> &arr, int low, int high)
{
    if (low < high)
    {
        int pIndex = deterministicPartition(arr, low, high);
        deterministicQuickSort(arr, low, pIndex - 1);
        deterministicQuickSort(arr, pIndex + 1, high);
    }
}

// Randomized QuickSort
void randomizedQuickSort(vector<int> &arr, int low, int high)
{
    if (low < high)
    {
        int pIndex = randomizedPartition(arr, low, high);
        randomizedQuickSort(arr, low, pIndex - 1);
        randomizedQuickSort(arr, pIndex + 1, high);
    }
}

int main()
{
    int n;
    cout << "Enter the Size of the Array N: ";
    cin >> n;

    vector<int> arr1(n), arr2(n);
    cout << "Enter the " << n << " elements of the array:\n";
    for (int i = 0; i < n; i++)
    {
        cin >> arr1[i];
        arr2[i] = arr1[i];
    }

    deterministicQuickSort(arr1, 0, n - 1);
    cout << "Sorted Array Using Deterministic Quick Sort: ";
    for (int i = 0; i < n; i++)
    {
        cout << arr1[i] << " ";
    }
    cout << endl;
    randomizedQuickSort(arr2, 0, n - 1);
    cout << "Sorted Array Using Randomized Quick Sort: ";
    for (int i = 0; i < n; i++)
    {
        cout << arr2[i] << " ";
    }
    cout << endl;
    return 0;
}
