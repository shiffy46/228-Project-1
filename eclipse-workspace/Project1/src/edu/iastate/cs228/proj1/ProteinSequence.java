package edu.iastate.cs228.proj1;

/*
 * @author Sam Shifflett
*/

public class ProteinSequence extends Sequence
{
  /**
   If the character array argument {@code psarr} 
   contains a character on which the method {@link #isValidLetter(char)}
    returns {@code false}, then it throws an {@link java.lang.IllegalArgumentException} 
    exception with the message {@code 
    "Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence"}. 
    Otherwise, the constructor saves a copy of the character array argument in the 
    field of its superclass {@link Sequence}.
  
   @param psarr See {@link #ProteinSequence(char[])}.
   @throws IllegalArgumentException See {@link #ProteinSequence(char[])}.
  */  
  public ProteinSequence(char[] psarr)
  {
    super(psarr);
        
    String sequence = "";
    
    for(int i = 0; i < psarr.length; i++)
    {
    	if(!(isValidLetter(psarr[i])))
    	{
    		throw new IllegalArgumentException("Invalid sequence letter for class edu.iastate.cs228.proj1.ProteinSequence");
    	}
    }
    
    for(int i = 0; i < psarr.length; i++)
    {
    	sequence += psarr[i]; 
    }
    seqarr = sequence.toCharArray();
  }

  
  /**
   The method returns {@code true} if the character argument is equal to one of the 
   20 English letters that are not in the set {@code {B, b, J, j, O, o, U, u, X, x, Z, z}}. 
   Otherwise, it returns {@code false}. This method overrides the one in its superclass.
  
   @param aa See {@link #isValidLetter(char)}.
  */
  @Override
  public boolean isValidLetter(char aa)
  {
	  if(aa == 'B')
	  {
		  return false;
	  }
	  else if(aa == 'b')
	  {
		  return false;
	  }
	  else if(aa == 'J')
	  {
		  return false;
	  }
	  else if(aa == 'j')
	  {
		  return false;
	  }
	  else if(aa == 'O')
	  {
		  return false;
	  }
	  else if(aa == 'o')
	  {
		  return false;
	  }
	  
	  else if(aa == 'U')
	  {
		  return false;
	  }
	  else if(aa == 'u')
	  {
		  return false;
	  }
	  else if(aa == 'X')
	  {
		  return false;
	  }
	  else if(aa == 'x')
	  {
		  return false;
	  }
	  else if(aa == 'Z')
	  {
		  return false;
	  }
	  else if(aa == 'z')
	  {
		  return false;
	  }
	  else if(Character.isLetter(aa))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
}
