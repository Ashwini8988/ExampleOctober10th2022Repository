package com.sgtesting.p1;

public class Example2 {

	public static void main(String[] args) {
		int count=0;
	      for(int i=121;i>=91;i--)
	      {
	        if(i%2!=0)
	        {
	           count++;
	        }
	      }
	         System.out.println("# of odd number:"+ count);
	         int arr[]=new int[count];
	         int k=0;
	         for(int j=121;j>=91;j--)
	         {
	           if(j%2!=0)
	           {
	              arr[k]=j;
	              k++;
	           }
	         }
	          for(int x=arr.length-1;x>=0;x--)
	      {
	         System.out.println(arr[x]);
	      }

	}

}
