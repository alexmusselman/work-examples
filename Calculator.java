import java.util.*;
public class Calculator {
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("This program is a calculator,\nif you would like instructions on how to use the program input y\nto continue to the program input n ");
		String i = s.nextLine();
		i.toLowerCase();
		instructions(i);
		choice();
		
	}
	public static void choice () {
		Scanner s = new Scanner(System.in);
		System.out.print("Which calculator would you like to use?  ");
		String c = s.nextLine();
		c.toLowerCase();
		if(c.equals("basic")){
			bcalculator();
		}else{
			if(c.equals("trig")){
				tcalculator();
		}else{
			if(c.equals("sqrt")){
				sqrtcalculator();
		}else{
			System.out.print("not a valid calculator, input either basic, trig or sqrt");
			choice();
			}
			}
			}
		System.out.print("would you like to keep using this program ");
		String a = s.nextLine();
		a.toLowerCase();
		if(a.equals("y")) {
			choice();
		}	
	}
	public static void instructions (String i) {
		Scanner s = new Scanner(System.in);
		if(i.equals("y")) {
			System.out.println("this program will first ask you what sort of operations you will be doing");
			System.out.println("it will give you the options basic, trig, or sqrt\n");
			System.out.print("which calculator would you like instructions on basic, trig, sqrt, or all? ");
			String f = s.nextLine();
			f.toLowerCase();
			 while(options(f) == 1) {
				 System.out.print("invalid input, enter either basic, trig, or sqrt \n");
				 f = s.nextLine();
				 options(f);
			 }
			
		}
		System.out.println("");
	}
	
	public static int options (String f) {
		f.toLowerCase();
		int x = 1;
		if(f.equals("basic")) {
				basici();
				x = 0;
			}
			if(f.equals("trig")) {
				trigi();
				x = 0;
			} 
			if(f.equals("sqrt")) {
				sqrti();
				x = 0;
			}
		return x;
	}
	public static void basici () {
		Scanner s = new Scanner(System.in);
		System.out.println("for the basic calculator \nThis is a calculator for dealing with basic oporators eg. + - * /");
		System.out.println("it will ask for a number then it will ask for an mathmatical operator \nthen it will ask for a second number");
		System.out.println("the answer will be shown and you will be asked for a second operator\nto stop using to calculator input = or input another operator\n\n"); 
		System.out.print("would you like to see other instructions? y for yes n for no ");
		String x = s.nextLine();
		instructions(x);
		
	}
	
	public static void trigi () {
		Scanner s = new Scanner(System.in);
		System.out.println("for the trig calculator\nThis is a calculator for trigonometry calculations eg. cosine sine tangent cotanget secant cosecant");
		System.out.println("the system will ask for a number, this will be the number inside the functions it will be in degrees\n you will then input the trig function to use");
		System.out.print("would you like to see other instructions? y for yes n for no ");
		String x = s.nextLine();
		instructions(x);
		 
	}
	
	public static void sqrti () {
		Scanner s = new Scanner(System.in);
		System.out.println("This calculator gives the square root of a given number\nthe system will ask for a number and it will return its square root");
		System.out.print("would you like to see other instructions? y for yes n for no ");
		String x = s.nextLine();
		instructions(x); 
	}
	public static void tcalculator () {
		Scanner s = new Scanner(System.in);
		System.out.print("input a number ");
		double x = number();
		x = Math.toRadians(x);
		x = functions(x);
		System.out.println(x);
		System.out.print("would you like to calculate another trig value y/n");
		String c = s.nextLine();
		c.toLowerCase();
		if(c.equals("y")){
			tcalculator();
		}
		
	}
	
	public static double functions (double x) {
		Scanner s = new Scanner(System.in);
		System.out.print("which trig function would you like to use ");
		String f = s.nextLine();
		if(f.equals("sin")) {
			return sinf(x);
		}
		if(f.equals("cos")) {
			return cosf(x);
		}
		if(f.equals("tan"))  {
			return tanf(x);
		}
		if(f.equals("sec")) {
			return secant(x);
		}
		if(f.equals("csc")) {
			return cosecant(x);
		}
		if(f.equals("cot")) {
			return cot(x);
		}
		System.out.println("not a valid function, input either sin, cos, tan, sec, csc, cot");
		return functions(x);
	}
	public static double sinf (double x) {
		x = Math.sin(x);
		return x;
	}
	
	public static double cosf (double x) {
		x = Math.cos(x);
		return x;
	}
	
	public static double tanf (double x) {
		x = Math.tan(x);
		return x;
	}
	
	public static double secant (double x) {
		x = Math.cos(x);
		x = 1/x;
		return x;
	}
	
	public static double cosecant (double x) {
		x = Math.sin(x);
		x = 1/x;
		return x;
	}
	
	public static double cot (double x) {
		x = Math.tan(x);
		x = 1/x;
		return x;
	}
	
	public static void bcalculator () {
		System.out.print("imput first number: ");
		Scanner s = new Scanner(System.in); 
		double x = number();
		String o = operator();
		while(o.equals("=")) {
			System.out.println("not a valid equation \n");
			o = operator();
		}
		System.out.print("input second number ");
		double y = number();
		x = answer1(x, o, y);
		System.out.println(x);
		x = answer2(x);
		System.out.println(x);
		System.out.print("\n would you like to continue using the calculator input y for yes n for no ");
		String a = s.nextLine();
		if(a.equals("y")) {
			bcalculator();
		}
	}
	 
	public static Double number () {
		Scanner s = new Scanner(System.in);
		double x = s.nextDouble();
		return x;
	}
	
	public static String operator () {
		Scanner s = new Scanner(System.in);
		System.out.print("input mathmatical operator ");
		String o = s.nextLine();
		if(o.equals("+")){
			return o;
		}
		if(o.equals("-")) {
			return o;
		}
		if(o.equals("*")) {
			return o;
		}
		if(o.equals("/")){
			return o;
		}
		if(o.equals("=")) {
			return o;
		}
		System.out.print("not a valid operator input y to see instructions input anythig else to continue ");
		String i = s.nextLine();
		i.toLowerCase();
		if(i.equals("y")){
			instructions(i);
		}
		return operator();
	}

	public static double answer1 (double x, String o, double y) {
		if(o.equals("+")) {
			return x+y;
		}
		if(o.equals("-")) {
			return x-y;
		}
		if(o.equals("*")) {
			return x*y;
		}
		if(o.equals("/")) {
			return x/y;
		}
		return 0.000000000000000001809 ;
	}
	public static double answer2 (double x) {
		String o = operator();
		if(o.equals("=")) {
			return x;
		}
		System.out.print("input number ");
		double n = number();
		x = answer1(x, o, n);
		System.out.println(x);
		return answer2(x);
	}
	public static void sqrtcalculator () {
		Scanner s = new Scanner(System.in);
		System.out.print("input a number");
		double x = number();
		x = Math.sqrt(x);
		System.out.println(x);
		System.out.println("Would you like to keep using this calculator ");
		String c = s.nextLine();
		c.toLowerCase();
		if(c.equals("y")) {
			sqrtcalculator();
		}
	}
	  
}

