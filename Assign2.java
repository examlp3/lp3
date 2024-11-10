/*
Assignment No: 2
Write a program to implement Huffman Encoding using a greedy strategy.

Time complexity: O(nlogn)
Space complexity: O(n) 
*/


import java.util.*;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}

public class Assign2 {
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null) {
      System.out.println(root.c + "   |  " + s);
      return;
    }


    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the String : ");
    String str = sc.next();

    Map<Character, Integer> map = new HashMap<>();
    
    for(char ch : str.toCharArray()){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    
    int n = map.size();
    char[] charArray = new char[n];
    int[] charfreq = new int[n];
    
    int ind = 0;
    for(char key : map.keySet()){
        charArray[ind] = key;
        charfreq[ind] = map.get(key);

        ind++;
    }

    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a,b) -> a.item - b.item);

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = charArray[i];
      hn.item = charfreq[i];

      hn.left = null;
      hn.right = null;

      pq.add(hn);
    }

    HuffmanNode root = null;

    while (pq.size() > 1) {

      HuffmanNode x = pq.peek();
      pq.poll();

      HuffmanNode y = pq.peek();
      pq.poll();

      HuffmanNode temp = new HuffmanNode();

      temp.item = x.item + y.item;
      temp.c = '-';
      temp.left = x;
      temp.right = y;
      root = temp;

      pq.add(temp);
    }
    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    printCode(root, "");
  }
}