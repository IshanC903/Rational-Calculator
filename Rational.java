//Ishan Chaurasia
//NET 3004 - Assignment 1
//Ishan Chaurasia
//Oct 1, 2019

public class Rational {
	
	//Secure Variables
	private int numberator;
	private int denominator;
	
	//Constructors
	public Rational () 
	{
		this.numberator = 0;
		this.denominator = 1;
	}
	
	public Rational (int i)
	{
		this.numberator = i;
		this.denominator = 1;
	}
	
	public Rational (Rational r)
	{
		this.numberator = r.numberator;
		this.denominator = r.denominator;
	}
	
	public Rational (int num, int den)
	{
		this.numberator = num;
		this.denominator = den;
	}
	
	//Functions
	
	//returns a rational that holds sum of current and r rational.
	public Rational plus (Rational r)
	{		
		int tempNum = this.numberator + r.numberator;
		int tempDen = this.denominator + r.denominator;
		
		Rational sendR = new Rational(tempNum, tempDen);
		return sendR;
	}
	
	//returns a rational that holds product of current and r rational.
	public Rational times (Rational r)
	{
		int tempNum = (this.numberator * r.numberator);
		int tempDen = (this.denominator * r.denominator);
		
		Rational sendR = new Rational(tempNum, tempDen);
		return sendR;
	}
	
	//returns a rational that holds divident of current and r rational.
	public Rational dividedBy (Rational r)
	{
		int tempNum = (this.denominator * r.numberator);
		int tempDen = (this.numberator * r.denominator);
		
		Rational sendR = new Rational(tempNum, tempDen);
		return sendR;
	}
	
	public float toFloat()
	{
		return ((float) this.numberator/this.denominator);
	}
	
	private void reduce()
	{
		//This function is adapted from the of Jatin Thakur in link mentioned below.
		//http://www.codebytes.in/2014/07/program-for-reducing-fractions-to.html
		
		int smaller = this.numberator < this.denominator ? this.numberator : this.denominator;
        int HCF = -1;
        for (int i = smaller; i > 0; --i) {
            if (this.numberator%i==0&&this.denominator%i==0) {
                HCF = i;
                System.out.print((this.numberator/HCF)+"/"+(this.denominator/HCF));
                break;
            }
        }
	}
	
	public String toString()
	{
		String num = Integer.toString(this.numberator);
		String den = Integer.toString(this.denominator);
		
		return (num + "/" + den);
	}
	
	public boolean equals (Rational r)
	{
		boolean same = false;
		float testOne = this.numberator/this.denominator;
		float testTwo = r.numberator/r.denominator;
		
		if(testOne == testTwo)
		{
			same = true;
		}
		else {same = false;}
		
		return same;
	}
	
	public int compareTo (Rational r)
	{
		float a = this.numberator;
		float b = this.denominator;
		
		float x = r.numberator;
		float y = r.denominator;
		
		float fracOne = a/b;
		float fracTwo = x/y;
		
		
		if(fracOne == fracTwo){return 0;}
		else if (fracOne < fracTwo){return -1;}
		else if (fracOne > fracTwo){return 1;}
		else {return 404;}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Rational r1 = new Rational(1,2);
		
		System.out.print("Rational r1 is ");
		System.out.print(r1);
		System.out.print(" and evaluates to ");
		System.out.print(r1.toFloat() + "\n"); //Testing toFloat function
		
		Rational r2 = new Rational(2,3);
		System.out.print("Rational r2 is " + r2 + " and evaluates to " + r2.toFloat());
		
		if (!r1.equals(r2)) //Testing Equals Function
		{
			System.out.print("\nr1 is not equal to r2");
		}
		else 
		{
			System.out.print("\nr1 is equal to r2");
		}
		
		Rational r3 = new Rational(2,4);
		System.out.print("\nRational r3 is " + r3 + " and evaluates to " + r3.toFloat());
		
		if (r1.equals(r3))
		{
			System.out.print("\nr1 is equal to r3");
		}
		else
		{
			System.out.print("\nr1 is not equal to r3");
		}

		//Testing Plus Function
		System.out.print("\nRational r1 + r2 = " + r1.plus(r2));

		//Testing Times Function
		System.out.print("\nRational r1 x r2 = " + r1.times(r2));

		//Testing Divide Function
		System.out.print("\nRational r1 / r2 = " + r1.dividedBy(r2));

		//Testing To String Function
		System.out.print("\nRational r3 in string = " + r3.toString());

		//Testing Reduce Function
		Rational r4 = new Rational(12,4);
		System.out.print("\nRational r4 = " + r4 + " = ");
		r4.reduce();

		//Testing Compare to Function
		System.out.print("\nRational r3 compared to r4 = " + r3.compareTo(r4));


	}

}
