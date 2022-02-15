//@author Alex Musselman

import java.util.*;
import java.io.*;

public class Blackjack {
	
	public static void main (String[] args) throws FileNotFoundException {
		int wins = 0;
		int gp = 0;
		Scanner console = new Scanner(System.in);
		System.out.println("This is the game of blackjack you start with $1000");
		int money = 1000;
		String[] carddeck = new String[52];
		
		//This section of code creates the deck of cards that will be used throughout.
		carddeck[0] = "Ace of Spades";
		for(int i = 1; i<10; i++) {
			carddeck[i] = (i+1 + " of Spades");
			}
		carddeck[10] = "Jack of Spades";
		carddeck[11] = "Queen of Spades";
		carddeck[12] = "King of Spades";
		carddeck[13] = "Ace of Hearts";
		for (int j = 14; j<23; j++) {
			carddeck[j] = (j-12 + " of Hearts"); 
			}
		carddeck[23] = "Jack of Hearts";
		carddeck[24] = "Queen of Hearts";
		carddeck[25] = "King of Hearts";
		carddeck[26] = "Ace of Clubs";
		for (int l = 27; l<36; l++) {
			carddeck[l] = (l-25 + " of Clubs"); 
			}
		carddeck[36] = "Jack of Clubs";
		carddeck[37] = "Queen of Clubs";
		carddeck[38] = "King of Clubs";
		carddeck[39] = "Ace of Diamonds";
		for (int z = 40; z<49; z++) {
			carddeck[z] = (z-38 + " of Diamonds"); 
			}
		carddeck[49] = "Jack of Diamonds";
		carddeck[50] = "Queen of Diamonds";
		carddeck[51] = "King of Diamonds";
		int p = 1;
		
		//this is the start of the game.
		//the cardx deck is shuffled 
		do{shuffle(carddeck);
			
			//the bet is placed 
			int bet = bet(money);
			
			//then the game starts
			int r = play(carddeck, money, bet);
			//gp is games plaed and wins tracks the wins
			if(r == 0) {
				//0 means loss
				money = money - bet;
				gp++;
			}else if(r == 1) {
				//1 means win
				money = money + bet;
				wins++;
				gp++;
			}else if(r == 2) {
				//2 means 21 or double down win
				money = money + (bet * 2);
				wins++;
				gp++;
			}else if(r == 3) {
				//3 means double split loss
				money = money - (bet *2);
				wins++;
				gp++;
			}else if (r == 5) {
				//5 means single split win
				money = money;
				wins++;
				gp++;
			}else if (r == 6) {
				//6means double split win
				money = money + (bet *2);
				wins = wins + 2;
				gp++;
				}
				//tells you how much money you have left
			System.out.println("\nYou have $" + money + " left");
			if(money < 1) {
				//if you run out of money the game ends 
				System.out.println("You've run out of money, better luck next time");
			}else{ 
				//end of play the palyer is asked if they would like to play again
			System.out.print("would you like to play again? (1 for yes, any other number for no):");
			p = console.nextInt(); 
			//if yes play continues
			}}while(p == 1 && money > 0);
			//code for file printing, prints times won and remaning money
			System.out.println("The amount of times you won, and your remaning amount of money has been printed to the file \"ending information\"");
		PrintStream stats = new PrintStream(new File("ending information"));
		stats.println("Spliting counts as one game, however, wining one out of two counts as one win, winning both counts as two wins. \namount of games won:" + wins);
		stats.println("amount of money: " + money + "\namount of money gained/lost: " + (money - 1000));
	}
	
	//this method runs the game as a whole.
	public static int play (String[] carddeck, int money, int bet) {
		Scanner s = new Scanner(System.in);
		int cp = 5;
		
		//the cards are "delt" and printed to the terminal
		String dfc = carddeck[1];
		String dsc = carddeck[3];
		String yfc = carddeck[2];
		String ysc = carddeck[4]; 
		String ync = carddeck[cp];
		String dnc = carddeck[cp];
		int ys = 0;
		int ds = 0;
		char c = yfc.charAt(0);
		char v = ysc.charAt(0);
		char b = dfc.charAt(0);
		char n = dsc.charAt(0);
		String yc = yfc + " and " + ysc;
		String dc = dfc + " and " + dsc;
		ys = yintScore(ys, c, v, yc);
		ds = dintscore(ds, b, n, dc);
		System.out.println("Your cards are: " + yc);
		System.out.println("your total card value " + ys);
		System.out.println("The dealer is showing a " + dsc);
		
		//if the dealer has 21 or you have gone over 21 the game ends with a loss
		if (ys > 21 || ds == 21) {
			System.out.println("you lose");
			System.out.println("The dealers cards are " + dc);
			System.out.println("The dealers score is " + ds);
			return 0;
			} 
			
			//if you have 21 the game ends with a win.
		if(ys == 21){
			System.out.println("you win with 21!!!!!!");
			return 2;
			}
			
		//if you can double your bet you are asked if you would like to double down	
		if((bet*2) < money) { 
			System.out.print("would you like to double down? (1 for yes 0 for no) ");
			int z = s.nextInt();
			
			//if yes the games shifts to the doubling down method.
			if(z == 1) {
			int d = doublingDown(ync, carddeck, cp, yc, ys, dc, ds, dnc);
			//returns outcome
			return d;
				}
			}		 
		int a = 1;
		
		//if you have a pair your are asked if you would like to split your hand.
		if(v == c) {
			System.out.print("You have a pair would you like to split your hand? (1 for yes 0 for no) ");
			int x = s.nextInt();
			
			//if yes the game shifts to the split method
			if(x == 1){ 
				int w = split(c, v, carddeck, cp, yfc, dsc, ysc, ds, dc);
				if(w == 3){
					//return 3 means double loss
					return 3;
				}else if(w == 1) {
					//return 5 means single win
					return 5;
				}else if(w == 6) {
					//return 6 means double win
					return 6;
				}else{
					}
				}else {
					}
		}
		
		/*if the player did not double down or split the game continues
		they are asked if they would like to hit or stay
		until they stay or go over 21 this continues */	
		do{ System.out.print("Would you like to hit or stay? (input 1 for hit, 0 for stay):");
			a = s.nextInt();
			if (a == 1) {
				ync = carddeck[cp];
				cp++;
				yc = yc + " and " + ync;
				ys = youScoring(ys, ync, yc);
				System.out.println("Your cards are: " + yc);
				System.out.println("your total card value " + ys);
				}
		}while(a == 1 && ys < 21);
		
		//if the player gets 21 they win and the game resets.
		if(ys == 21){
			System.out.println("you win with 21!!!!!!");
			return 2;
			}
		 
		 //if the player goes over 21 they lose and the game resets.
		if( ys > 21) {
			System.out.println("you lose");
			return 0;
			}
			
		//the dealers cards are printed and the dealer gets more cards until their score goes above 17. 	
		System.out.println("Dealers cards are " + dc);
		System.out.println("Dealers total card value " + ds); 
		while (ds < 17) {
			dnc = carddeck[cp];
			cp++;
			dc = dc + " and " + dnc;
			ds = dealerScoring(ds, dnc, dc);
			System.out.println("Dealers cards are " + dc);
			System.out.println("Dealers total card value " + ds);  
			}
			
		//if the dealer goes above 21 the player wins. 	 
		if (ds > 21) {
			System.out.println("You win!!");
			return 1; 
			}
		//if the player has a lower score then the dealer and the dealer has less then 21 the player loses	
		if (ds > ys && ds < 21) {
			System.out.println("you lose");
			return 0;
			}
		// if the dealer and the player tie and the dealer has less then 21 the player loses.	
		if(ds == ys || ds == 21) {
			System.out.println("you lose");
			return 0;
			}
		//if the player has a higher score then the dealer and the player has less the 21 the player wins.	
		if(ds< 21 && ys > ds && ys < 21) {
			System.out.println("You Win!");
			return 1;	
			}
	//this is an extra return statement that is required for the code to compile, it can never be reached unless the code is broken.		
	return 4;
	}


//this shuffles the carddeck
	public static void shuffle (String[] carddeck) {
		Random r = new Random();
		for(int i = 0; i<carddeck.length; i++) {
			int f = r.nextInt(carddeck.length);
			String t = carddeck[i];
			carddeck[i] = carddeck[f];
			carddeck[f] = t;
		}
	}
	
	//this adds the score of all of your cards together 
	public static int youScoring (int ys, String ync, String yc) {
		//finds value based on first character of cards
		char c = ync.charAt(0);
		if(c == 'A') {
			ys = ys + 11;
		}else if(c == 'K' || c == 'Q'|| c == 'J') {
				ys = ys + 10;
		}else if(Character.isDigit(c)) {
			if(c == 49) {
				ys = ys + (c - 39); 
			}else
				ys = ys + (c - 48);
				}
				//checks for aces and if the score is over 21 makes ace worth 1 instead of 11
		if (ys > 21) {
			for(int p = 0; p < yc.length(); p++) {
				if(yc.charAt(p) == 'A') {
					ys = ys - 10;
				}
			} 
		}
		//retuns score		
		return ys;	
	}
	
	//this ads the score of all the dealers cars together
	public static int dealerScoring (int ds, String dnc, String dc) {
		//finds value based on first character of cards
		char c = dnc.charAt(0);
		if(c == 'A') {
			ds = ds + 11;
		}else if(c == 'K' || c == 'Q'|| c == 'J') {
				ds = ds + 10;
		}else if(Character.isDigit(c)) {
			if(c == 49) {
					ds = ds + (c - 39); 
				}else
					ds = ds + (c - 48);
			}
			//checks for aces and if the score is over 21 makes ace worth 1 instead of 11
		if (ds > 21) {
			for(int p = 0; p < dc.length(); p++) {
				if(dc.charAt(p) == 'A') {
					ds = ds - 10;
				}
			} 
		}
		//returns score				
		return ds;
	}
	
	//this gives the initail score of your first two cards.
	public static int yintScore (int ys, char c, char v, String yc) {
		//finds value based on first character of cards
		if(c == 'A') {
			ys = ys + 11;
		}else if(c == 'K' || c == 'Q'|| c == 'J') {
				ys = ys + 10;
		}else if(Character.isDigit(c)) {
			if(c == 49) {
					ys = ys + (c - 39); 
				}else
					ys = ys + (c - 48);
			}
		if(v == 'A') {
			ys = ys + 11;
		}else if(v == 'K' || v == 'Q'|| v == 'J') {
				ys = ys + 10;
		}else if(Character.isDigit(v)) {
				if(v == 49) {
					ys = ys + (v - 39); 
				}else
					ys = ys + (v - 48);
			}
			//checks for aces and if the score is over 21 makes ace worth 1 instead of 11
		if (ys > 21) {
			for(int p = 0; p < yc.length(); p++) {
				if(yc.charAt(p) == 'A') {
					ys = ys - 10;
				}
			} 
		}		
		int score = ys;
		//returns score
		return score;
	}
	
	//this gives the initail score of the dealers first two cards.
	public static int dintscore (int ds, char b, char n, String dc) {
		//finds value based on first character of cards
		if(b == 'A') {
			ds = ds + 11;
		}else if(b == 'K' || b == 'Q'|| b == 'J') {
				ds = ds + 10;
		}else if(Character.isDigit(b)) {
			if(b == 49) {
					ds = ds + (b - 39); 
				}else
					ds = ds + (b - 48);
			}
		if(n == 'A') {
			ds = ds + 11;
		}else if(n == 'K' || n == 'Q'|| n == 'J') {
				ds = ds + 10;
		}else if(Character.isDigit(n)) {
			if(n == 49) {
					ds = ds + (n - 39); 
				}else
					ds = ds + (n - 48);
			}
			//checks for aces and if the score is over 21 makes ace worth 1 instead of 11
		if (ds > 21) {
			for(int p = 0; p < dc.length(); p++) {
				if(dc.charAt(p) == 'A') {
					ds = ds - 10;
				}
			} 
		}		
		int score = ds;
		//returns score
		return score;		
	}
	
	//this collectes the players bet and stores it for later use
	public static int bet (int money) {
		Scanner b = new Scanner(System.in);
		System.out.print("How much would you like to bet? ");
		int bet = b.nextInt();
		//if bet exceeds money does not except
		while (bet > money) {
			System.out.print("You don't have thet much money \nHow much would you like to bet ");	
			bet = b.nextInt();
			}
		return bet;
	}
	//this method runs the doubling down portion of the game it gives you one more cardand finishes the game.
	public static int doublingDown (String ync, String carddeck[], int cp, String yc, int ys, String dc, int ds, String dnc) {
		ync = carddeck[cp];
		cp++;
		yc = yc + " and " + ync;
		ys = ddscoring(ys, ync, yc);
		System.out.println("Your cards are: " + yc);
		System.out.println("your total card value " + ys);
		//outcome of player getting 21
		if(ys == 21){
			System.out.println("you win with 21!!!!!!");
			return 2;
			}else{
			} 
			//outcome of player getting over 21
		if( ys > 21) {
			System.out.println("you lose");
			return 3;
		}else{
			//outcome of player getting below 21 and giving the dealer cards 
		System.out.println("Dealers cards are " + dc);
		System.out.println("Dealers total card value " + ds); 
		while (ds < 17) {
			dnc = carddeck[cp];
			cp++;
			dc = dc + " and " + dnc;
			ds = dealerScoring(ds, dnc, dc);
			System.out.println("Dealers cards are " + dc);
			System.out.println("Dealers total card value " + ds);  
			} 
		//outcome of dealer getting over 21
		if (ds > 21) {
			System.out.println("You win!!");
			return 2; 
		}else{
		}
		//outcome of dealer getting a higher score but not over 21
		if (ds > ys && ds < 21) {
		System.out.println("you lose");
		return 3;
		}else{
		}
		//out come of the dealer tying with the player
		if(ds == ys || ds == 21) {
			System.out.println("you lose");
			return 3;
		}else{
			//outcome of player getting a higher score then the dealer but lower then 21.
		if(ds< 21 && ys > ds && ys < 21) {
			System.out.println("You Win!");
			return 2;	
			}
		}
		}
		//extra retun statement required.
	return 4;
	}
	//scoring method for doubling down 
	public static int ddscoring (int ys, String ync, String yc) {
		//calculates score of card based on first character
		char c = ync.charAt(0);
		if(c == 'A') {
			ys = ys + 11;
		}else if(c == 'K' || c == 'Q'|| c == 'J') {
				ys = ys + 10;
		}else if(Character.isDigit(c)) {
			if(c == 49) {
					ys = ys + (c - 39); 
				}else
					ys = ys + (c - 48);
				}
				//if score is above 21 but there is an ace in your cards ace's score goes from 11 to 1
		if (ys > 21) {
			for(int p = 0; p < yc.length(); p++) {
				if(yc.charAt(p) == 'A') {
					ys = ys - 10;
				}
			} 
		}
		//returns score		
		return ys;
	}
	//method used for spliting
	public static int split (char c, char v, String carddeck[], int cp, String yfc, String dsc, String ysc, int ds, String dc) {
		int w = 0;
		//method for the first hand gets value of hand to comparew to dealer
		int fhv = splitfh(c, carddeck, cp, yfc, dsc);
		//method for the second hand gets value of hand to comparew to dealer
		int shv = splitsh(v, carddeck, cp, ysc, dsc);
		//prints dealers cards 
		System.out.println("Dealers cards are " + dc);
		System.out.println("Dealers total card value " + ds);
		//if both hands are above 21 return a loss
		if(fhv > 21) {
			if(shv > 21) {
				w = 3;
			}
			//if bnoth hands got 21 return a win
		}else if(fhv == 21) {
			if(shv == 21) {
				w = 6;
			}
			//second check
		}else if(shv > 21) {
			if(fhv > 21) {
				w = 3;
			}
			//second check
		}else if(shv == 21) {
			if(fhv == 21) {
				w = 6;
			}
		} 
		//dealer getting more cards until score reaches 17 
		while (ds < 17) {
			String dnc = carddeck[cp];
			cp++;
			dc = dc + " and " + dnc;
			ds = dealerScoring(ds, dnc, dc);
			System.out.println("Dealers cards are " + dc);
			System.out.println("Dealers total card value " + ds);  
			}
			//if dealer getrs above 21
		if(ds > 21) {
			System.out.println("you win both hands!!");
			w = 6;
			//if both hands the dealer gets a hiogher score that is less then 21
		}else if(ds > fhv && ds > shv && ds < 21 && fhv < 21 && shv < 21) {
			System.out.println("You lose both hands");
			w = 3;
			//if both hands the player gets a higher score that is leaaa then 21
		}else if(ds < fhv && ds < shv && ds < 21 && fhv < 21 && shv < 21) {
			System.out.println("You win both hands");
			w = 6;
			//if first hand is won by player with a higher score buty second hand is won by dealer 
		}else if(ds < fhv && ds > shv && ds < 21 && fhv < 21 && shv < 21) {
			System.out.println("You win your first hand but lose your second");
			w = 1;
			//if first hand is won by dealer with a higher score and second hand is won by player
		}else if(ds > fhv && ds < shv && ds < 21 && fhv < 21 && shv < 21) {
			System.out.println("You lose your first hand but win your second");
			w =1;
			//if first hand goes over 21 and second hand is won by player with hier score.
		}else if(fhv > 21 && ds < shv && shv < 21) {
			System.out.println("You lost your first hand but won your second");
			w = 1;
			//if first hand is won by player with a higher score and second hand goes over 21
		}else if(shv > 21 && ds < fhv && fhv < 21) {
			System.out.println("You won your first hand but lost your second");
			w = 1;
			//if first hand goes over 21 and second hand is won by dealer with a higher score
		}else if(fhv > 21 && ds > shv && shv < 21 && ds < 21) { 
			System.out.println("You lost both hands");
			w = 3;
			//if first hand is won by dealer and second hand goes over 21
		} else if(shv > 21 && ds > fhv && fhv < 21 && ds < 21) { 
			System.out.println("You lost both hands");
			w = 3; 
		}
		//return ending situation
		return w;
	} 	
	//method for the first hand in splitting
	public static int splitfh (char c, String carddeck[], int cp, String yfc, String dsc) {
		Scanner s = new Scanner(System.in);
		int fhs = 0;
		String ync = carddeck[cp];
		cp++;
		//prints your hand
		String yfh = (yfc + " and " + ync);
		System.out.println("Your first hand is: " + yfh);
		//scores your hand
		fhs = youSplitScoring(ync, yfh, fhs, yfc);
		System.out.println("your first hand total card value is " + fhs);
		System.out.println("The dealer is showing a " + dsc);
		//finishes if you go over 21
		if (fhs > 21) {
			System.out.println("you lose your first hand");
			return fhs;
			}else {
				//finishes if you get 21
				}if(fhs == 21){
			System.out.println("you win your first hand with 21!!!!!!");
			return fhs;
			}
			//play, hitting or staying, until stay or over 21	 
		int o = 1;
		do{ System.out.print("Would you like to hit or stay? (input 1 for hit, 0 for stay):");
			o = s.nextInt();
			if (o == 1) {
				ync = carddeck[cp];
				cp++;
				yfh = yfh + " and " + ync;
				fhs = youSplitScoring(ync, yfh, fhs, yfc);
				System.out.println("Your first hand cards are: " + yfh);
				System.out.println("your total first hand card value is " + fhs);
			}
		}while(o == 1 && fhs < 21);
		//ends if gotten 21
		if(fhs == 21){
			System.out.println("you win your first with 21!!!!!!");
			return fhs;
			}else{
		} 
		//ends if over 21
		if( fhs > 21) {
			System.out.println("you lose your first hand");
			return fhs;
		}
		//returns hand value
		return fhs; 
	}
//method for second hand in split
	public static int splitsh (char v, String carddeck[], int cp, String dsc, String ysc ) {
		cp++;
		Scanner s = new Scanner(System.in);
		int shs = 0;
		String ync = carddeck[cp];
		cp++;
		//prints your hand
		String ysh = (ysc + " and " + ync);
		System.out.println("Your second hand is: " + ysh);
		//scores your hand
		shs = youSplitScoring(ync, ysh, shs, ysc);
		System.out.println("your second hand total card value is " + shs);
		System.out.println("The dealer is showing a " + carddeck[3]);
		//finishes if you go over 21
		if (shs > 21) {
			System.out.println("you lose your second hand");
			return shs;
			}else
			//finishes if you get 21
			if(shs == 21){
			System.out.println("you win your second hand with 21!!!!!!");
			return shs;
			}	 
		int o = 1;
		//play, hitting or staying, until stay or over 21	
		do{ System.out.print("Would you like to hit or stay? (input 1 for hit, 0 for stay):");
			o = s.nextInt();
			if (o == 1) {
				ync = carddeck[cp];
				cp++;
				ysh = ysh + " and " + ync;
				shs = youSplitScoring(ync, ysh, shs, ysc);
				System.out.println("Your first hand cards are: " + ysh);
				System.out.println("your total first hand card value is " + shs);
			}
		}while(o == 1 && shs < 21);
		//ends if gotten 21
		if(shs == 21){
			System.out.println("you win your second with 21!!!!!!");
			return shs;
			} 
			//ends if over 21
		if( shs > 21) {
			System.out.println("you lose your second hand");
			return shs;
			}
			//returns hand value
	return shs;
	}
	//scoring method for spliting
	public static int youSplitScoring (String ync, String yfh, int fhs, String yfc) {
		//finds value based on first character of string
		if(fhs == 0) {
		char a = yfc.charAt(0);
		if(a == 'A') {
			fhs = fhs + 11;
		}else if(a == 'K' || a == 'Q'|| a == 'J') {
				fhs = fhs + 10;
		}else if(Character.isDigit(a)) {
			if(a == 49) {
					fhs = fhs + (a - 39); 
				}else
					fhs = fhs + (a - 48);
				}	
		}
		char c = ync.charAt(0);
		if(c == 'A') {
			fhs = fhs + 11;
		}else if(c == 'K' || c == 'Q'|| c == 'J') {
				fhs = fhs + 10;
		}else if(Character.isDigit(c)) {
			if(c == 49) {
					fhs = fhs + (c - 39); 
				}else
					fhs = fhs + (c - 48);
				}
				//if score over 21 and there is an ace, ace goes from an 11 to a 1
		if (fhs > 21) {
			for(int p = 0; p < yfh.length(); p++) {
				if(yfh.charAt(p) == 'A') {
					fhs = fhs - 10;
				}
			} 
		}		
		//returns score		
		return fhs;
	}
}
