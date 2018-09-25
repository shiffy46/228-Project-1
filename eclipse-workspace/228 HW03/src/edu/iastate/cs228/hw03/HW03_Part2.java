package edu.iastate.cs228.hw03;

/**
 * 
 * @author Sam Shifflett
 *
 */
public class HW03_Part2
{
 /*
  * Answers to short questions:
  * 
  * 1.O(n)
  * 
  * 2.O(n)
  * 
  * 3.O(n^2)
  * 
  * 4.O(n^2)
  * 
  * 5.O(n)
  * 
  */
	
	/*
	 In all of the following methods you can assume that
	 array will always have elements (ints) in it.
	 And will have proper integers as defined in the 
	 description of HW03, i.e., in first two it will be
	 in the range, and in last two it will be composed of
	 negative and positive values only.
	*/
	
	public static int findMissingInt_a_On2(int [] array)
	{
		int count = 1;
		boolean isThere = false;
		
		for(int j = 0; j < array.length+1; j++)
		{
			for(int k = 0; k < array.length; k++)
			{
				if(count == array[k])
				{
					isThere = true;
					break;
				}
				else
				{
					isThere = false;
				}
			}
			if(isThere == false)
			{
				return count;
			}
			count++;
		}
		return -1;
	}
	
	public static int findMissingInt_b_On1(int [] array)
	{
		int total1 = 0;
		int total2 = 0;
		
		int count = array.length+1;
		
		while(count > 0)
		{
			total1 = total1 + count;
			if(count >= 2)
			{
				total2 = total2 + array[count-2];
			}
			count--;
		}
		//Part (b) of subsection 2.2.2 of HW03.		
		return (total1 % total2);
	}
	
	public static void rearrange_a_On2(int [] array)
	{
		int[] storeArray = new int[array.length];
		
		int i = 0;
		int j = array.length-1;
		
		for(int k = 0; k < array.length;k++)
		{
				if(array[k] > 0 && j > 1)
				{
					storeArray[j] = array[k];
					j--;
				}
				else
				{
					storeArray[i] = array[k];
					i++;
				}
				if(k == array.length-1)
				{
					for(int l = 0; l < array.length; l++)
					{
						array[l] = storeArray[l];
					}
				}
			
		}
		
		//Part (a) of subsection 2.2.2 of HW03.		
		return;
	}
	
	public static void rearrange_b_On1(int [] array)
	{
		int[] storeArray = new int[array.length];
		
		int i = 0;
		int j = array.length-1;
		
		for(int k = 0; k < array.length;k++)
		{
				if(array[k] > 0 && j > 1)
				{
					storeArray[j] = array[k];
					j--;
				}
				else
				{
					storeArray[i] = array[k];
					i++;
				}
			
		}
		for(int l = 0; l < array.length;l++)
		{
			array[l] = storeArray[l];
		}
		
		//Part (a) of subsection 2.2.2 of HW03.		
		return;
	}
}
