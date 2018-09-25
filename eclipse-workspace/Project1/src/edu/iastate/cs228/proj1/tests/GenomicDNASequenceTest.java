package edu.iastate.cs228.proj1.tests;

/*
 * @author Sam Shifflett
*/

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.proj1.GenomicDNASequence;

public class GenomicDNASequenceTest {
	
	String testString = new String("AATGCCAGTCAGCATAGCGTAGACT");
	private char[] testArray = testString.toCharArray();
	GenomicDNASequence Tester;
	int[] spots = {1, 5, 8, 10, 13, 16};
	int[] badSpots = {1, 5, 8, 10, 13};
	int[] badSpots2 = {};
	int[] badSpots3 = {-2,0,2,4};
	int[] badSpots4 = {1,3,100};
	int[] badSpots5 = {1,4,2};
	
	@Before
    public void setUp() {
        Tester = new GenomicDNASequence(testArray);
    }
	
	@After
    public void tearDown() {
        Tester = null;
    }
	/*
	 * test constructor
	 */
	@Test
	public void TestGenomicDNASequenceConstructor()
	{
		new GenomicDNASequence(testArray);
	}
	
	@Test
	public void TestmarkCoding() 
	{
		Tester.markCoding(1, 16);
		
		
		assertTrue(Tester.isValidLetter('A'));
		assertFalse(Tester.isValidLetter('B'));
		assertFalse(Tester.isValidLetter('!'));
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestmarkCodingIllegal1() throws IllegalArgumentException 
	{
		Tester.markCoding(13, 8);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestmarkCodingIllegal2() throws IllegalArgumentException 
	{
		Tester.markCoding(-1, 8);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestmarkCodingIllegal3() throws IllegalArgumentException 
	{
		Tester.markCoding(13, 100);
	}
	
	@Test
	public void TestextractExons1()
	{
		String comparer = "ATGCCTCAATAG";
		Tester.markCoding(1, 16);
		assertArrayEquals(comparer.toCharArray(),Tester.extractExons(spots));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestextractExonsIllegal1() throws IllegalArgumentException 
	{
		Tester.markCoding(1, 16);
		Tester.extractExons(badSpots);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestextractExonsIllegal2() throws IllegalArgumentException 
	{
		Tester.markCoding(1, 16);
		Tester.extractExons(badSpots2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestextractExonsIllegal3() throws IllegalArgumentException 
	{
		Tester.markCoding(1, 16);
		Tester.extractExons(badSpots3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestextractExonsIllegal4() throws IllegalArgumentException 
	{
		Tester.markCoding(1, 16);
		Tester.extractExons(badSpots5);
	}
	
	@Test(expected=IllegalStateException.class)
	public void TestextractExonsIllegal5() throws IllegalStateException 
	{
		Tester.markCoding(5, 16);
		Tester.extractExons(spots);
	}
}
