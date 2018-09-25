package edu.iastate.cs228.proj1.tests;

/*
 * @author Sam Shifflett
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.proj1.DNASequence;

public class DNASequenceTest {
	
	String testString = new String("AATGCCAGTCAGCATAGCGTAGACT");
	private char[] testArray = testString.toCharArray();
	DNASequence Tester;
	
	@Before
    public void setUp() {
        Tester = new DNASequence(testArray);
    }
	
	@After
    public void tearDown() {
        Tester = null;
    }
	/*
	 * test constructor
	 */
	@Test
	public void TestDNASequenceConstructor()
	{
		new DNASequence(testArray);
	}
	
	@Test
	public void TestisValidLetter()
	{
		assertTrue(Tester.isValidLetter('g'));
		assertTrue(Tester.isValidLetter('G'));
		assertFalse(Tester.isValidLetter('p'));
	}

}
