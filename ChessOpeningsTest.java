import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;
/**
 * JUnit Tests for ChessOPenings
 */

public class ChessOpeningsTest {
	/**
	 * BInary tree used for testing
	 * */
	public static BinaryTree Sicilian = new BinaryTree();
		

	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		Sicilian.addRight("pawn e2 to e4"); 
		Sicilian.addRight("knight g1 to f3"); 
		Sicilian.addLeft("knight b1 to c3"); 
		Sicilian.addRight("pawn d2 to d4"); 
		Sicilian.addRight("knight f3 to d4"); 
		Sicilian.addRight("knight b1 to c3");
		Sicilian.addLeft("pawn g2 to g3"); 
		Sicilian.addLeft("bishop f1 to g2"); 
		Sicilian.addLeft("pawn d2 to d3");
		Sicilian.addLeft("bishop f1 to b5", 1);
		return;
	}
	
	/**
	 * tests that stringEquality works
	 * every time the user gives input string equality is called 
	 * its the only inportant method 
	 * also tests that values are added to the stacks answers and incorrect answers
	 */
	@Test 
	public void Test(){		
		assertTrue(ChessOpenings.stringEquality(Sicilian.root(), "pawn e2 to e4"));
		assertFalse(ChessOpenings.stringEquality(Sicilian.root(), "Hello world!"));
		assertEquals(ChessOpenings.answers.toString(), "[pawn e2 to e4]");
		assertEquals(ChessOpenings.incorrectanswers.toString(), "[Hello world!]");
		
		
	}
	/**
	 * tests that values can be continuously add to the stack answers
	 *  
	 * */
	@Test
	public void Test2 () {
		assertTrue(ChessOpenings.stringEquality(Sicilian.root().getRight(), "knight g1 to f3"));
		assertEquals(ChessOpenings.answers.toString(), "[pawn e2 to e4, knight g1 to f3]");
	}
	/**
	 * tests that values can be continuously add to the stack incorrectanswers
	 * */
	@Test
	public void Test3 () {
		assertFalse(ChessOpenings.stringEquality(Sicilian.root().getLeft(), "Hi there"));
		assertEquals(ChessOpenings.incorrectanswers.toString(), "[Hello world!, Hi there]");
	}
	/**
	 * tests that both stacks can be cleared 
	 * and when the stacks are empty the code does not break
	 * */
	@Test
	public void Test4 () {
		ChessOpenings.clearanswers();
		assertEquals(ChessOpenings.answers.toString(), "[]");
		assertEquals(ChessOpenings.incorrectanswers.toString(), "[]");
		ChessOpenings.clearanswers();
		assertEquals(ChessOpenings.answers.toString(), "[]");
		assertEquals(ChessOpenings.incorrectanswers.toString(), "[]");
	}
	/**
	 * tests that user inputing quit will quit the program 
	 * and not log any answers
	 * */
	@Test
	public void Test5 () {
		assertTrue(ChessOpenings.stringEquality(Sicilian.root(), "quit"));
		assertEquals(ChessOpenings.answers.toString(), "[]");
		assertEquals(ChessOpenings.incorrectanswers.toString(), "[]");
	}
}
