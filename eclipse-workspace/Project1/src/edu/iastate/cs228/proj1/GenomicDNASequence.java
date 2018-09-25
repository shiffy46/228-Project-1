package edu.iastate.cs228.proj1;

/*
 * @author Sam Shifflett
*/

public class GenomicDNASequence extends DNASequence
{
  private boolean[] iscoding;

  /**
   If the character array argument has a character on which the method 
   {@link #isValidLetter(char)} returns {@code false}, then it throws 
   \{@link java.lang.IllegalArgumentException} with the message 
   {@code "Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence"}.
    Otherwise, the constructor saves a copy of the character array argument in the field 
    of its superclass {@code Sequence}. And it create a {@code boolean} array of the same 
    length as {@code gdnaarr}, saves its reference in the field {@code iscoding}, and sets 
    the {@code boolean} array to {@code false} at each index.
   
   @param gdnaarr See {@link #GenomicDNASequence(char[])}   
   @throws IllegalArgumentException See {@link #GenomicDNASequence(char[])}   
  */  
  public GenomicDNASequence(char[] gdnaarr)
  {
    super(gdnaarr);
    boolean[] Falses = new boolean[gdnaarr.length];
    for(int k = 0; k < gdnaarr.length; k++)
    {
    	if(!isValidLetter(gdnaarr[k]))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.proj1.GenomicDNASequence");
    	}
    	else
    	{
    		seqarr[k] = gdnaarr[k];
    	}
    }
    iscoding = Falses;
  }

  
  /**
   The method throws an {@link java.lang.IllegalArgumentException} exception with 
   the message {@code "Coding border is out of bound"} if {@code first} is greater 
   than {@code last}, or {@code first} is less than 0, or {@code last} is greater than 
   or equal to the length returned by the {@link #seqLength()} method. Otherwise, 
   it sets the {@code boolean} array {@code iscoding} to {@code true} at each index between 
   {@code first} and {@code last} inclusive.
   
   @param first See {@link #markCoding(int, int)}
   @param last See {@link #markCoding(int, int)}
   @throws IllegalArgumentException See {@link #markCoding(int, int)}   
  */
  public void markCoding(int first, int last)
  {
    if(first > last || first < 0 || last > seqLength())
    {
    	throw new IllegalArgumentException("Coding border is out of bound");
    }
    else
    {
	    for(int i = first; i < last+1; i++)
	    {
	    	iscoding[i] = true;
	    }
    }
  }

  
  /**
   The integer array argument {@code exonpos} is used to specify the start 
   and end positions of every coding exon in the genomic sequence. The method 
   throws an {@link java.lang.IllegalArgumentException} exception with the 
   message {@code "Empty array or odd number of array elements"} if the length 
   of {@code exonpos} is 0 or an odd number. It throws an {@link java.lang.IllegalArgumentException} 
   with the message {@code "Exon position is out of bound"} if an element in the {@code exonpos} is 
   less than 0 or is greater than or equal to the length returned by the {@link #seqLength()} method. 
   It throws an {@link java.lang.IllegalArgumentException} exception with the message 
   {@code "Exon positions are not in order"} if an element in {@code exonpos} is greater 
   than its right neighbor element. It throws an {@link java.lang.IllegalStateException} 
   exception with the message {@code "Noncoding position is found"} if the {@code boolean} 
   array {@code iscoding} is {@code false} at a coding exon position. Otherwise, 
   the method takes all the coding exons  specified by the array {@code exonpos}, 
   concatenates them in order, and returns the resulting sequence in a new character array. 
   Note that the array length is the length of the resulting sequence.

   For example, 
   <blockquote><pre>
   
    seqarr =   {A, A, T, G, C, C, A, G, T, C,  A,  G,  C,  A,  T,  A,  G,  C,  G,  T,  A}
    iscoding = {F, T, T, T, T, T, T, T, T, T,  T,  T,  T,  T,  T,  T,  T,  F,  F,  F,  F}
    index:      0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
   
    Note that we use A for 'A', F for false, and T for true to save space.
   
    exonarr = {1, 5, 8, 10, 13, 16}
   
    The first exon is given by the subarray of seqarr 
	from index 1 to index 5, which is {A, T, G, C, C}.

    The second exon is given by the subarray of seqarr 
	from index 8 to index 10, which is {T, C, A}.

    The third exon is given by the subarray of seqarr 
	from index 13 to index 16, which is {A, T, A, G}.

    The returned array is the concatenation of the three 
	subarrays in order: {A, T, G, C, C, T, C, A, A, T, A, G}
   
   </pre></blockquote>
   @param exonpos See {@link #extractExons(int[])}
   @return See {@link #extractExons(int[])}
   @throws IllegalArgumentException See {@link #extractExons(int[])}
   @throws IllegalStateException See {@link #extractExons(int[])}
  */
  public char[] extractExons(int[] exonpos)
  {
	  int g = 0;
	  
	  if(exonpos.length % 2 != 0 || exonpos.length == 0)
	  {
		  throw new IllegalArgumentException("Empty array or odd number of array elements");
	  }
	  while(g < exonpos.length)
	  {
		  if(exonpos[g] < 0 || exonpos[g] > seqLength())
		  {
			  throw new IllegalArgumentException("Exon position is out of bound");
		  }
		  g++;
	  }
	  
	  for(int f = 0; f < exonpos.length-1; f++)
	  {
		  if(exonpos[f] > exonpos[f+1])
		  {
			  throw new IllegalArgumentException("Exon positions are not in order");
		  }
	  }
	  for(int h = 0; h < exonpos.length; h++)
	  {
		  if(iscoding[exonpos[h]] == false)
		  {
			  throw new IllegalStateException("Noncoding position is found");
		  }
	  }
	  //Exception check done  
	  char[] subArray;
	  
	  int totalChar = 0;
	  
	  int h = 0;
	  int i = 0;
	  int j = exonpos.length-1;
	  while(j >= 0)
	  {
		  totalChar = totalChar + (exonpos[j] - (exonpos[j-1]-1));
		  j = j -2;
	  }
	  subArray = new char[totalChar];
	  while(i < exonpos.length-1)
	  {
		  for(int k = exonpos[i]; k < exonpos[i+1]+1; k++)
		  {
			  subArray[h] = seqarr[k];
			  h++;
		  }
		  i = i + 2;
	  }
	  return subArray;
  }

}
