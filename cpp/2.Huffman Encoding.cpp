/*
Assignment No: 2
Write a program to implement Huffman Encoding using a greedy strategy.
Time complexity: O(nlogn)
Space complexity: O(n)
*/
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>
using namespace std;

class HuffmanNode
{
public:
    char c;
    int item;
    HuffmanNode *left;
    HuffmanNode *right;
    HuffmanNode(char c, int item)
    {
        this->c = c;
        this->item = item;
        left = right = nullptr;
    }
};

// Function to print the Huffman Codes
void printCode(HuffmanNode *root, string s)
{
    if (root->left == nullptr && root->right == nullptr)
    {
        cout << root->c << "   |  " << s << endl;
        return;
    }

    printCode(root->left, s + "0");
    printCode(root->right, s + "1");
}

int main()
{
    cout << "Enter the String: ";
    string str;
    cin >> str;

    // Calculate frequency of each character in the input string
    unordered_map<char, int> map;
    for (char ch : str)
    {
        map[ch]++;
    }

    // Priority Queue to store nodes based on frequency
    auto cmp = [](HuffmanNode *left, HuffmanNode *right)
    {
        return left->item > right->item;
    };
    priority_queue<HuffmanNode *, vector<HuffmanNode *>, decltype(cmp)> pq(cmp);

    // Insert characters and their frequencies into the priority queue
    for (auto &pair : map)
    {
        pq.push(new HuffmanNode(pair.first, pair.second));
    }

    // Create Huffman Tree
    HuffmanNode *root = nullptr;
    while (pq.size() > 1)
    {
        HuffmanNode *x = pq.top();
        pq.pop();

        HuffmanNode *y = pq.top();
        pq.pop();

        HuffmanNode *temp = new HuffmanNode('-', x->item + y->item);
        temp->left = x;
        temp->right = y;
        root = temp;

        pq.push(temp);
    }

    // Print the Huffman Codes
    cout << " Char | Huffman code " << endl;
    cout << "--------------------" << endl;
    printCode(root, "");

    return 0;
}