/**
 * @author Abdullah Shamsan
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTreeStudentTest {
	MorseCodeTree morseTree = new MorseCodeTree();
	ArrayList<String> morseList = new ArrayList<>();

	@Test

	public void testFetch() {	
		String tst = morseTree.fetch("-..");
		assertEquals("d",tst);
	}
	
	@Test
	public void testGetRoot() {	
		assertEquals("",MorseCodeConverter.morseTree.getRoot().getData());
	}
	
	@Test
	public void testSetRoot() {	
		TreeNode<String> testRoot = new TreeNode<String>("?");
		MorseCodeConverter.morseTree.setRoot(testRoot);
		assertEquals("?",MorseCodeConverter.morseTree.getRoot().getData());
	}
	

	@Test
	public void testTree() {	
		String str = "";
		morseList = morseTree.toArrayList();
		for(int i = 0;i<morseTree.toArrayList().size();i++) {
			if(i!=morseTree.toArrayList().size()-1)
				str+=morseTree.toArrayList().get(i) + " ";
			else
				str+=morseTree.toArrayList().get(i);
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", str);

	}
	@Test
	public void testinsert() {	
		MorseCodeConverter.morseTree.insert("..--", "?");
		MorseCodeConverter.morseTree.insert(".-.-", "!");
		String converter1 = MorseCodeConverter.convertToEnglish(".-.. --- .-.. / .-- .... .- - ..-- .-.-");
		assertEquals("lol what?!", converter1);
	}
	
	

}




	
	
	
