package com.sgtesting.p1;

public class Diviby6example1 {

	public static void main(String[] args) 
	{
		 int count=0;
	      for(int i=150;i>=100;i--)
	      {
	        if(i%6==0)
	        {
	           count++;
	        }
	      }
	         System.out.println("Divisible by 6:"+ count);
	         int arr[]=new int[count];
	         int k=0;
	         for(int j=150;j>=100;j--)
	         {
	           if(j%6==0)
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
