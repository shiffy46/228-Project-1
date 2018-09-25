package edu.iastate.cs228.proj1.tests;

/*
 * @author Sam Shifflett
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.proj1.ProteinSequence;

public class ProtienSequenceTest {
	
	String testString = new String("AATGCCAGTCAGCATAGCGTAGACT");
	private char[] testArray = testString.toCharArray();
	ProteinSequence Tester;
	
	@Before
    public void setUp() {
        Tester = new ProteinSequence(testArray);
    }
	
	@After
    public void tearDown() {
        Tester = null;
    }
	/*
	 * test constructor
	 */
	@Test
	public void TestProteinSequenceConstructor()
	{
		new ProteinSequence(testArray);
	}
	
	@Test
	public void TestisValidLetter()
	{
		assertTrue(Tester.isValidLetter('g'));
		assertTrue(Tester.isValidLetter('T'));
		assertFalse(Tester.isValidLetter('Z'));
		assertFalse(Tester.isValidLetter('!'));
	}

}
