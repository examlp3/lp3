#include <iostream> 
using namespace std; 
void printFib(int prev1, int prev2, int n) { 
if (n == 0) return; 
int curNum = prev1 + prev2; 
cout << curNum << " "; 
printFib(curNum, prev1, n - 1); 
} 
int main() { 
int n; 
cout << "Enter the Number: "; 
cin >> n; 
if (n == 0) return 0; 
cout << 0 << " "; 
if (n == 1) return 0; 
cout << 1 << " "; 
 
    printFib(1, 0, n - 2); 
 
    return 0; 
}