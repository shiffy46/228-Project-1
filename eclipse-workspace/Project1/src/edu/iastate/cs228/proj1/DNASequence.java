package edu.iastate.cs228.proj1;

/*
 * @author Sam Shifflett
*/

public class DNASequence extends Sequence
{
  /**
   If the character array argument has a character on which the method {@link #isValidLetter(char)} 
   returns {@code false}, then it throws an {@link java.lang.IllegalArgumentException} with the message
{@code "Invalid sequence letter for class X"} where {@code X} denotes {@code "edu.iastate.cs228.proj1.DNASequence"}
or the name of a subclass of which an object is created. Otherwise, the constructor saves a copy of the character 
array argument in the field of its superclass.
   
   @param dnaarr See {@link #DNASequence(char[])}.
   @throws IllegalArgumentException See {@link #DNASequence(char[])}.
  */
  public DNASequence(char[] dnaarr)
  {
    super(dnaarr);
    
    String sequence = "";
    
    for(int i = 0; i < dnaarr.length; i++)
    {
    	if(!(isValidLetter(dnaarr[i])))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.proj1.DNASequence");
    	}
    }
    
    for(int i = 0; i < dnaarr.length; i++)
    {
    	sequence += dnaarr[i]; 
    }
    seqarr = sequence.toCharArray();
  }

  /**
   The method returns {@code true} if the character argument is equal 
   to one of the eight characters {@code 'a', 'A', 'c', 'C', 'g', 'G', 't', and 'T'}. 
   Otherwise, it returns {@code false}. This method overrides the one in its superclass.
   
   @param let See {@link #isValidLetter(char)}.
   @return {@link #isValidLetter(char)}.
  */
  @Override
  public boolean isValidLetter(char let)
  {
	  if(let == 'a')
	  {
		  return true;
	  }
	  else if(let == 'A')
	  {
		  return true;
	  }
	  else if(let == 'c')
	  {
		  return true;
	  }
	  else if(let == 'C')
	  {
		  return true;
	  }
	  else if(let == 'g')
	  {
		  return true;
	  }
	  else if(let == 'G')
	  {
		  return true;
	  }
	  
	  else if(let == 't')
	  {
		  return true;
	  }
	  else if(let == 'T')
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }

}
