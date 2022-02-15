import java.util.*;

/**
 * ChessOenings
 * 
 * */
public class ChessOpenings {
	/**
	 * scanner for the whole class
	 * **/
	public static Scanner scan = new Scanner(System.in);
	/**
	 * two stcks that fill with the given answers
	 * */
	public static Stack<String> answers = new Stack<>(); /**correct answers**/
	public static Stack<String> incorrectanswers = new Stack<>(); /**incorrect answers**/
	
	/**
	 * main method 
	 * creates and fill binary trees
	 * starts the openings or study
	 * @param args nothing passed
	 * */
	public static void main (String[] args) {
			BinaryTree RuyLopez = new BinaryTree();
			BinaryTree Nimzoindiandefence = new BinaryTree();
			BinaryTree Sicilian = new BinaryTree();
			RuyLopez.addRight("pawn e2 to e4");
			RuyLopez.addRight("Knight g1 to f3");
			RuyLopez.addRight("Bishop f1 to b5");
			RuyLopez.addRight("Bishop b5 to c6");
			RuyLopez.addLeft("bishop b5 to a4", 2);
			RuyLopez.addLeft("Castle", 2);
			RuyLopez.addLeft("bishop a4 to b3", 2);
			Nimzoindiandefence.addRight("pawn d2 to d4"); 
			Nimzoindiandefence.addRight("pawn c2 to c4"); 
			Nimzoindiandefence.addRight("knight b1 to c3"); 
			Nimzoindiandefence.addRight("pawn e2 to e3"); 
			Nimzoindiandefence.addRight("bishop b1 to d3"); 
			Nimzoindiandefence.addRight("knight g1 to f3"); 
			Nimzoindiandefence.addRight("castle");
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
			
			int t = 55;
			while(t != 1 && t != 0) { /**if given a number that is not accepted user is asked again**/
				System.out.print("This progam is used to help learn chess openings \nwould you like to study or test yourself? \n1 for study 0 for test ");
				t = scan.nextInt();
			}
			if(t == 1) {
				testsetup(RuyLopez, Nimzoindiandefence, Sicilian);
				}
				int x = 55;
				while(x != -2) {
				clearanswers();	
				System.out.print("Which opening would you like to test yourself in? \n1 = Ruy Lopez  2 = Nimzo Indian Defence  3 = Sicilian  0 = random opening  -1 = back to study  -2 = quit");
				x = scan.nextInt();
				if(x != -2) {
					if(x == -1) {
						testsetup(RuyLopez, Nimzoindiandefence, Sicilian);
					}else{
						if(x == 0) {
							Random r = new Random();
							int a = r.nextInt(3);
							if(a == 0) {
								rlt(RuyLopez);
							}
							if(a == 1) {
								nidt(Nimzoindiandefence);
							}
							if(a == 2) {
								st(Sicilian);
							}
						}else{
							 if(x == 1) {
								rlt(RuyLopez); 
							 }else{
								 if(x == 2) {
									 nidt(Nimzoindiandefence);
									}else{
										if(x == 3) {
											st(Sicilian);
										}
									}
								}
							}
						}
					}
				}
			}
	/**
	 * starts the study process and tells which tree to pass
	 * @param RuyLopez Ruy Lopez opening 
	 * @param Nimzoindiandefence Nimzo indian defence opening
	 * @param Sicilian Sicilian defence opening 
	 * */ 
	public static void testsetup (BinaryTree RuyLopez, BinaryTree Nimzoindiandefence, BinaryTree Sicilian) {
		System.out.print("Which opening would you like to study? \n0 = Ruy Lopez  1 = Nimzo Indian Defence  2 = Sicilian");
			int q = scan.nextInt();
			if(q == 0) { 	 
				study(RuyLopez, q);
			}
			if(q == 1) {
				study(Nimzoindiandefence, q);
			}
			if(q == 2) {
				study(Sicilian, q);
			}
	}
	/**
	 * tests the user's knowlege of the sicilian defence opening
	 * @param tree Sicilian binary tree to be used 
	 * */
	public static void st (BinaryTree tree) {
		int x = 55;
		System.out.print("Sicilian Defence \nwhat is the first move white? (enter answer as \"piece name original position to position after move\") ");
		String a = scan.nextLine();
		a = scan.nextLine();
		String test = a.toLowerCase();
		a = test(tree.root(), test);
		if(!a.equals("quit")) { /**user can type quit at any time to go back to the begining options**/
			System.out.println("Yes!!! \nblack moves pawn c7 to c5");
			while(x != 0 && x!= 1) { /**if given a number that is not accepted user is asked again**/
				System.out.print("Which variation are you playing? \n0 for open sicilian, 1 for Alapin Variation "); //user selects which variation of sicilian to be tested on
				 x = scan.nextInt();
			}
			System.out.print("What is the next move for white?");
			a = scan.nextLine();
			a = scan.nextLine();
			test = a.toLowerCase();
			if(x == 0) {
				a = test(tree.root().getRight(), test);
				if(!a.equals("quit")) {
					System.out.println("Yes!!! \nblack moves pawn d5 to d6");
					x = 55;
					while(x != 0 && x!= 1) {
						System.out.print("Which variation are you playing? \n0 for open sicilian, 1 for Moscow Variation ");
						x = scan.nextInt();
					}
					System.out.print("What is the next move for white?");
					a = scan.nextLine();
					a = scan.nextLine();
					test = a.toLowerCase();
					if(x == 0) {
						a = test(tree.root().getRight().getRight(), test);
						if(!a.equals("quit")) {
							System.out.println("Yes!!!! \n black movesd pawn c5 to d4");
							System.out.print("What is the next move for white?");
							a = scan.nextLine();
							test = a.toLowerCase();
							a = test(tree.root().getRight().getRight().getRight(), test);
							if(!a.equals("quit")){
								System.out.println("Yes!!!! \n black movesd knight g8 to f6");
								System.out.print("What is the next move for white?");
								a = scan.nextLine();
								test = a.toLowerCase();
								a = test(tree.root().getRight().getRight().getRight().getRight(), test);
								if(!a.equals("quit")) {
									System.out.println("Yes!!!! \n opening Complete!!!");
									System.out.println("\nincorrect answers:  " + incorrectanswers); 
									System.out.println("\ncorrect answers:  " + answers);
								}
							}
						}
					}else{
						a = test(tree.root().getRight().getLeft(), test);
						if(!a.equals("quit")) {
							System.out.println("Yes!!!! \nopening complete!!!");
							System.out.println("\nincorrect answers:  " + incorrectanswers); 
							System.out.println("\ncorrect answers:  " + answers);
						}
					}
				}
			}else{
				a = test(tree.root().getLeft(), test);
				if(!a.equals("quit")) {
					System.out.println("Yes!!!! \n black movesd knight b8 to c6");
					System.out.print("What is the next move for white?");
					a = scan.nextLine();
					test = a.toLowerCase();
					a = test(tree.root().getLeft().getLeft(), test);
					if(!a.equals("quit")) {
						System.out.println("Yes!!!! \n black movesd pawn g7 to g6");
						System.out.print("What is the next move for white?");
						a = scan.nextLine();
						test = a.toLowerCase();
						a = test(tree.root().getLeft().getLeft().getLeft(), test);
						if(!a.equals("quit")) {
							System.out.println("Yes!!!! \n black movesd bishop f8 to g7 ");
							System.out.print("What is the next move for white?");
							a = scan.nextLine();
							test = a.toLowerCase();
							a = test(tree.root().getLeft().getLeft().getLeft().getLeft(), test);
							if(!a.equals("quit")) {
								System.out.println("Yes!!!! \n opening complete!!!");
								System.out.println("\nincorrect answers:  " + incorrectanswers); 
								System.out.println("\ncorrect answers:  " + answers);
							}
						}
					}
				}
			}
		}
	}
	/**
	 * tests the knowlege of the Nimzo indian defence opening
	 * @param tree Nimzoidiandefence binary tree to be used 
	 * */
	public static void nidt (BinaryTree tree) {
		System.out.print("Nimzo-Indian Defence \nwhat is the first move white? (enter answer as \"piece name original position to position after move\") ");
		String a = scan.nextLine();
		a = scan.nextLine();
		String test = a.toLowerCase();
		a = test(tree.root(), test);
		if(!a.equals("quit")) { 
			System.out.println("Yes!!! \nblack moves knight g8 to f6");
			System.out.print("What is the next move for white?");
			a = scan.nextLine();
			test = a.toLowerCase();
			a = test(tree.root().getRight(), test);
			if(!a.equals("quit")) {
				System.out.println("Yess!! \nblack moves pawn e7 to e6");
				System.out.print("What is the next move for White ");
				a = scan.nextLine();
				test = a.toLowerCase();
				a = test(tree.root().getRight().getRight(), test);
				if(!a.equals("quit")) {
					System.out.println("Yess!! \nblack moves bishop f8 to b4");
					System.out.print("What is the next move for White ");
					a = scan.nextLine();
					test = a.toLowerCase();
					a = test(tree.root().getRight().getRight().getRight(), test);
					if(!a.equals("quit")) {
						System.out.println("Yess!! \nblack moves castle");
						System.out.print("What is the next move for White ");
						a = scan.nextLine();
						test = a.toLowerCase();
						a = test(tree.root().getRight().getRight().getRight().getRight(), test);
						if(!a.equals("quit")) {
							System.out.println("Yess!! \nblack moves pawn d7 to d5");
							System.out.print("What is the next move for White ");
							a = scan.nextLine();
							test = a.toLowerCase();
							a = test(tree.root().getRight().getRight().getRight().getRight().getRight(), test);
							if(!a.equals("quit")) {
								System.out.println("Yess!! \nblack moves pawn c7 to c5");
								System.out.print("What is the next move for White ");
								a = scan.nextLine();
								test = a.toLowerCase();
								a = test(tree.root().getRight().getRight().getRight().getRight().getRight().getRight(), test);
								if(!a.equals("quit")) {
									System.out.println("Yess!! \nopening complete!!!!");
									System.out.println("\nincorrect answers:  " + incorrectanswers); 
									System.out.println("\ncorrect answers:  " + answers);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * tests the knowlege of the Ruy Lopez opening
	 * @param RuyLopez RuyLopez binary tree to be used 
	 * */
	public static void rlt (BinaryTree RuyLopez) {
		System.out.print("Ruy Lopez Opening \nwhat is the first move for white? (enter answer as \"piece name original position to position after move\") ");
		String a = scan.nextLine();
		a = scan.nextLine();
		String test = a.toLowerCase();
		a = test(RuyLopez.root(), test);
		if(!a.equals("quit")) {
			System.out.println("Yes!!!!! \nblack moves pawn e8 to e5");
			System.out.print("What is the next move for white? ");
			a = scan.nextLine();
			test = a.toLowerCase();
			a = test(RuyLopez.root().getRight(), test);
			if(!a.equals("quit")) {
				System.out.println("Yes!!!! \n black moves Knight b8 to c6");
				System.out.print("What is the next move for white? ");
				a = scan.nextLine();
				test = a.toLowerCase();
				a = test(RuyLopez.root().getRight().getRight(), test);
				if(!a.equals("quit")) {
					System.out.println("Yes!!!! \nblack moves pawn a7 to a6");
					System.out.print("which variation are you playing? \n1 for exchange variation, 0 for Steinitz Defence Deferred ");
					int v = -1;
					v = scan.nextInt();
					while(v != 0 && v != 1){
						System.out.println("not a correct number \n1 for exchange variation, 0 for Steinitz Defence Deferred");
						v = scan.nextInt();
					}	
					System.out.print("What is the next move for white? ");
					a = scan.nextLine();
					a = scan.nextLine();
					test = a.toLowerCase();
					if(v == 1) {
						a = test(RuyLopez.root().getRight().getRight().getRight(), test); 
						if(!a.equals("quit")) {
							System.out.println("Yes!!! \nblack moves pawn d7 to c6 opening complete!");
							System.out.println("\nincorrect answers:  " + incorrectanswers); 
							System.out.println("\ncorrect answers:  " + answers);
							}
					}else{
						a = test(RuyLopez.root().getRight().getRight().getLeft(), test);
						if(!a.equals("quit")) {
							System.out.println("Yes!! \nblack moves pawn d7 to d6");
							System.out.print("What is the next move for white? ");
							a = scan.nextLine();
							test = a.toLowerCase();
							a = test(RuyLopez.root().getRight().getRight().getLeft().getLeft(), test);
							if(!a.equals("quit")) {
								System.out.print("Yes!! \nblack moves knight g8 to f6 opening comnplete!! \ncontinue to Arkhangelsk Defence? \n1 for yes, 0 for no ");
								v = scan.nextInt();
								while(v != 0 && v != 1){
									System.out.println("not a correct number \n1 for yes, 0 for no");
									v = scan.nextInt();
									}
								if(v == 1) {
									System.out.print("what is the next move for white? ");
									a = scan.nextLine();
									a = scan.nextLine();
									test = a.toLowerCase();
									a = test(RuyLopez.root().getRight().getRight().getLeft().getLeft().getLeft(), test);
									if(!a.equals("quit")) {
										System.out.println("Yes!!! \nopening complete!!!");
										System.out.println("\nincorrect answers:  " + incorrectanswers); 
										System.out.println("\ncorrect answers:  " + answers);
										}
									}
								
								}
							}
						}
					}
				}
			}
		}
	/**
	 * method that prints the trees and the moves in order
	 * @param study Binary tree to be used 
	 * @param q int that tells which tree is passed 
	 * */
	public static void study (BinaryTree study, int q) {
		int a = 55;
		System.out.println("first move  " + study.root().getData());
		if(q == 2) {
			while(a != 1 && a!= 0) { 
			System.out.print("which variation are you studying? \n1 for open sicilian, 0 for Alapin Variation ");
			a = scan.nextInt();
			}
			if(a == 1) {
				System.out.println("\nsecond move  " + study.root().getRight().getData());
				a = 55;
				while(a != 1 && a!= 0) {
				System.out.print("which variation are you studying? \n1 for open sicilian, 0 for Moscow Variation ");
				a = scan.nextInt();
				}
				if(a == 1) {
					System.out.println("\nthird move  " + study.root().getRight().getRight().getData());
					System.out.println("\nfourth move  " + study.root().getRight().getRight().getRight().getData());
					System.out.println("\nfifth move  " + study.root().getRight().getRight().getRight().getRight().getData());
				}else{
					System.out.println("\nthird move  " + study.root().getRight().getLeft().getData());
				}  
			}else{
				System.out.println("\nsecond move  " + study.root().getLeft().getData());
				System.out.println("\nthird move  " + study.root().getLeft().getLeft().getData());
				System.out.println("\nfourth move  " + study.root().getLeft().getLeft().getLeft().getData());
				System.out.println("\nfifth move  " + study.root().getLeft().getLeft().getLeft().getLeft().getData());
			}
		}else{
		System.out.println("\nsecond move  " + study.root().getRight().getData());
		System.out.println("\nthird move  " + study.root().getRight().getRight().getData());
		if(q == 0) {
			a = 55;
			while(a != 1 && a!= 0) {
			System.out.print("which variation are you studying? \n1 for exchange variation, 0 for Steinitz Defence Deferred ");
			 a = scan.nextInt();
			}
			if(a == 1) {
				System.out.println("\nfourth move  " + study.root().getRight().getRight().getRight().getData());
			}else {
				System.out.println("\nfourth move  " + study.root().getRight().getRight().getLeft().getData());
				System.out.println("\nfifth move  " + study.root().getRight().getRight().getLeft().getLeft().getData());
				System.out.println("\nsixth move (only aplicable for Arkhangelsk Defence)  " + study.root().getRight().getRight().getLeft().getLeft().getLeft().getData());
			}
		}
		if(q == 1) {
			System.out.println("\nfourth move  " + study.root().getRight().getRight().getRight().getData());
			System.out.println("\nfifth move  " + study.root().getRight().getRight().getRight().getRight().getData());
			System.out.println("\nsixth move  " + study.root().getRight().getRight().getRight().getRight().getRight().getData());
			System.out.println("\nseventh move  " + study.root().getRight().getRight().getRight().getRight().getRight().getRight().getData());
		}
	}
	}
	/**
	 * method that clears both stacks before each opening test
	 * */ 
	public static void clearanswers () {
		if(answers.size() > 0){
			int s = answers.size();
			for(int x = 0; x < s; x++) {
				answers.pop();
				}
			}
		if(incorrectanswers.size() > 0) {
			int a = incorrectanswers.size();
			for (int y = 0; y < a; y++) {
				incorrectanswers.pop();
				}
			}
		}
	
	
	
	
	

	 /**
	  * method that tests if the users input was correct and pushes the user inpu into corresponding stack
	  * @param test tree node whos data is being tested against
	  * @param a user input
	  * @return if the data of the tree node and the string are equal
	  * */
	public static boolean stringEquality (TreeNode test, String a) {
		if(!a.equals("quit")) {
			if(!a.equals(test.getData().toLowerCase())) {
				System.out.println("no, check your spelling and spacing");
				incorrectanswers.push(a);
				return false;
			}
			answers.push(a);
		}
		
		return true;
	}
	/** 
	 * starts the test on the user input
	 * recursively repeats the user prompt 
	 * @param test tree node to be tested against
	 * @param a user input
	 * @return user input 
	 * */
	public static String test (TreeNode test, String a) {
		if(!stringEquality(test, a)) {
			System.out.print("What is the next move for white? (\"quit\" to quit) ");
			a = scan.nextLine();
			a = a.toLowerCase();
			test(test, a);
		}
		return a;	
	} 
}

