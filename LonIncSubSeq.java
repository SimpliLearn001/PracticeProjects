package Package01;

import java.util.Scanner;

public class LonIncSubSeq {
	static int incre_subseq(int my_arr[], int arr_len){
	      int seq_arr[] = new int[arr_len];
	      int i, j, max = 0;
	      for (i = 0; i < arr_len; i++)
	         seq_arr[i] = 1;
	      for (i = 1; i < arr_len; i++)
	    	  for (j = 0; j < i; j++)
	    		  if (my_arr[i] > my_arr[j] && seq_arr[i] < seq_arr[j] + 1)
	      seq_arr[i] = seq_arr[j] + 1;
	      for (i = 0; i < arr_len; i++)
	    	  if (max < seq_arr[i])
	    		  max = seq_arr[i];
	      return max;
	   }
	   public static void main(String args[]){
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter the number of elements");
		  int arr_len = scanner.nextInt();
		  System.out.println("Enter the elements");
		  int[] my_arr = new int[arr_len];
		  for(int i=0;i<arr_len;i++)
			  my_arr[i] = scanner.nextInt();
		  scanner.close();
	      System.out.println("The length of the longest increasing subsequence is " +  incre_subseq(my_arr, arr_len));
	   }
}
