package suanfas;

public class MedianofTwoSortedArrays {

	
	
	
	/**  
	 * 2011-03-27
	 * 
	 * There are two sorted arrays A and B of size m and n respectively. Find the median of 
	 * the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 * 
	 * Note that the definition of the Median:
     * (1) If the size of the sequence N is odd: N/2+1th element is median.
     * (1) If the size of the sequence N is even:  average of the N/2th and N/2+1th element is median.
	 * 
	 * *************Solution*********************
	 * #1. run time O(m+n), space O(m+n), by using a external array C size of A+B 
	 * 
	 * #2. run time O(m+n), space O(1), by using pre and last two external storage
	 * 
	 * 
	 * #3. run time O(lg(m+n)), space O(1), binary search
	 * 
	 */
	 public static double findMedianSortedArrays (int A[], int B[]) {
		 
		 
		 
		 int m = A.length;
		 int n = B.length;
		 
		 double[] C = new double[m+n];
		 
		 int i = 0, j = 0, k = 0;
		 
		 while (i < m && j < n) {
			 
			 if(A[i] <= B[j]) {
				 C[k] = A[i];
				 i++;
			 } else {
				 C[k] = B[j];
				 j++;
			 }
			 
			 k++;	 
		 }
		 
		 if(i == m) {
			 while (j < n) {
				 C[k] = B[j];
				 j++;
				 k++;
			 }
		 } else if (j == n) {
			 while (i < m) {
				 C[k] = A[i];
				 i++;
				 k++;
			 }
		 }
		 
		 if(C.length % 2 == 1)
			 return C[C.length/2];
		 else
			 return (C[C.length/2] + C[C.length/2-1])/2;

	 }	
 
	 
	 // suppose B is the bigger array
	 public static double findMedianSortedArrays2 (int A[], int B[]) {
		 
		 int i = 0;
		 int j = 0;
		 int m = A.length; int n = B.length;
		 int sum = m + n;
		 double pre = 0, last = 0;
		 
		if(sum < 2) {
			if(m == 0 && n == 0) 
				return 0;
			if(m == 1) 
				return A[0];
			else 
				return B[0];
		}
		
		while ( (i+j) <= sum/2 ) {
			
			pre = last;
			
			if(i >= m) {
				last = B[j];
				j++;
			} else if (j >= n) {
				last = A[i];
				i++;
			} else if (A[i] < B[j]) {
				last = A[i];
				i++;
			} else {
				last = B[j];
				j++;
			}
		
		}
		
		
		 if(sum%2 == 1)
			 return last;
		 else
			 return (pre+last)/2;
	 }
	 
	 
	 
	 
	
	public static void main(String[] args) {
//		int A[] = {1,3,5,7,9};
//		int B[] = {2,4,8,10,12,14,16,18,19};
		
		int A[] = {};
		int B[] = {2,3};
		
		
//		int A[] = {1,3};
//		int B[] = {1};
		
		
		//System.out.println(findMedianSortedArrays(A, B));
		
		//System.out.println(findMedianSortedArrays2(A, 5, B, 8));
		System.out.println(findMedianSortedArrays2(A, B));
	}

}














