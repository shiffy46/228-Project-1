package edu.iastate.cs228.proj1.tests;

/*
 * @author Sam Shifflett
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.proj1.CodingDNASequence;
import edu.iastate.cs228.proj1.GenomicDNASequence;
import edu.iastate.cs228.proj1.ProteinSequence;

public class CodingDNASequenceTest {
	
	String testString = new String("AATGCCAGTCAGCATAGCGTAGACT");
	private char[] testArray = testString.toCharArray();
	CodingDNASequence Tester;
	String testString2 = new String("ATGCCAGTCAGCATAGCGTAGACTA");
	private char[] testArray2 = testString2.toCharArray();
	CodingDNASequence Tester2 = new CodingDNASequence(testArray2);
	String testString3 = new String("AT");
	private char[] testArray3 = testString3.toCharArray();
	CodingDNASequence Tester3 = new CodingDNASequence(testArray3);
	int[] spots = {1, 5, 8, 10, 13, 16};
	
	@Before
    public void setUp() {
        Tester = new CodingDNASequence(testArray);
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
		new CodingDNASequence(testArray);
	}
	
	@Test
	public void TestcheckStartCodon()
	{
		assertFalse(Tester.checkStartCodon());
		assertTrue(Tester2.checkStartCodon());
		assertFalse(Tester3.checkStartCodon());
	}
	
	@Test(expected=RuntimeException.class)
	public void TesttranslateExecption() throws RuntimeException
	{
		Tester.translate();
	}
	
	@Test
	public void Testtranslate()
	{
		String comparer = "MPQ";
		GenomicDNASequence Geno = new GenomicDNASequence(testArray);
		Geno.markCoding(1, 16);
		CodingDNASequence coding = new CodingDNASequence( Geno.extractExons(spots) );
	    ProteinSequence proteinSeq = new ProteinSequence( coding.translate() );
	    String comparer2 = proteinSeq.toString();
	    System.out.println(comparer2);
		assertTrue(comparer2.equals(comparer));
	}

}
