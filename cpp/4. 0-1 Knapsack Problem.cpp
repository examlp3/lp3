#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;

// Function to solve the 0-1 Knapsack problem
int knapsack(int n, int W, vector<int> &wt, vector<int> &val)
{
    // Create a 1D array to store the previous row's results
    vector<int> prev(W + 1, 0);

    // Initialize the values for the first item
    for (int w = wt[0]; w <= W; w++)
    {
        prev[w] = val[0];
    }

    // Iterate through the items
    for (int ind = 1; ind < n; ind++)
    {
        vector<int> cur(W + 1, 0);

        for (int w = 0; w <= W; w++)
        {
            // Not taking the current item
            int notTake = prev[w];

            // Taking the current item if it fits
            int take = INT_MIN;
            if (wt[ind] <= w)
            {
                take = val[ind] + prev[w - wt[ind]];
            }

            // Store the maximum of taking or not taking the item
            cur[w] = max(take, notTake);
        }
        prev = cur;
    }

    // The answer will be in prev[W] for the full capacity
    return prev[W];
}

int main()
{
    int n, w;
    cout << "Enter the Size of the Array N: ";
    cin >> n;

    cout << "Enter the Weight Capacity W: ";
    cin >> w;
    cout << endl;

    vector<int> wt(n), val(n);
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the " << (i + 1) << " Value: ";
        cin >> val[i];

        cout << "Enter the " << (i + 1) << " Weight: ";
        cin >> wt[i];
    }

    int result = knapsack(n, w, wt, val);
    cout << "Maximum value in Knapsack = " << result << endl;

    return 0;
}
