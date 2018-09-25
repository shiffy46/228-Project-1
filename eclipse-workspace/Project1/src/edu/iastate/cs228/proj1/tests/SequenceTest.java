package edu.iastate.cs228.proj1.tests;

/*
 * @author Sam Shifflett
*/


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.proj1.Sequence;

public class SequenceTest{
	
	String testString = new String("AATGCCAGTCAGCATAGCGTAGACT");
	private char[] testArray = testString.toCharArray();
	Sequence Tester;
	
	@Before
    public void setUp() {
        Tester = new Sequence(testArray);
    }
	
	@After
    public void tearDown() {
        Tester = null;
    }
	/*
	 * test constructor
	 */
	@Test
	public void TestSequenceConstructor()
	{
		new Sequence(testArray);
	}
	
	@Test
	public void TestisValidLetter()
	{
		assertTrue(Tester.isValidLetter('A'));
		assertTrue(Tester.isValidLetter('B'));
		assertFalse(Tester.isValidLetter('!'));
	}
	
	@Test
	public void TestgetSeq()
	{
		assertArrayEquals(testArray, Tester.getSeq());
	}
	
	@Test
	public void TesttoString()
	{
		String compare = new String("AATGCCAGTCAGCATAGCGTAGACT");
		assertTrue(compare.equals(Tester.toString()));
	}
	
	@Test
	public void Testequals()
	{
		assertFalse(Tester.equals(null));
		assertFalse(Tester.equals(testString));
		assertTrue(Tester.equals(Tester));
	}
	
	@Test
	public void TestseqLength()
	{
		assertEquals(25,Tester.seqLength());
	}
	
}	
