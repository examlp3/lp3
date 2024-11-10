#include <iostream> 
using namespace std; 
 
int main() { 
    int n; 
    cout << "Enter the Number: "; 
    cin >> n; 
 
    if (n == 0) return 0; 
    cout << 0 << " "; 
    if (n == 1) return 0; 
    cout << 1 << " "; 
 
    int prev2 = 0; 
    int prev1 = 1; 
 
    for (int i = 2; i < n; i++) { 
        int curNum = prev1 + prev2; 
        prev2 = prev1; 
        prev1 = curNum; 
 
        cout << curNum << " "; 
    } 
 
    return 0; 
} 
 