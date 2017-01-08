import java.util.*;
import java.math.*;

public class ConfidenceCalc
{
	static int sampleSize;
	static double pHat;
	static double qHat;
	static double marginError;
	
	public static double findLevel(int sSize, double probSuc, double probFail, double mE)
	{
		double critVal = mE/Math.sqrt(((probSuc*probFail)/sSize));
		return NormalCdf(critVal, critVal*-1);
	}
	
	
	private static double NormalCdf(double a, double b)
	{
		double ans = integrate(a,b,1000);
		ans *= -100;
		System.out.println("The confidence level of this poll is approximately: " + Math.round(ans) + "%");
		return ans;
	}
	
	public static void main (String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the sample size: ");
		sampleSize = in.nextInt();
		System.out.println("Please enter the percent of voters supporting your candidate: ");
		pHat = in.nextDouble()/100;
		qHat = (1-pHat);
		System.out.println("Please enter the margin of error: ");
		marginError = in.nextDouble()/100;
		findLevel(sampleSize, pHat, qHat, marginError);
			
	}
	
	/**
	 * Code from: http://introcs.cs.princeton.edu/java/93integration/TrapezoidalRule.java.html
	 */
	static double densityFunc(double x)
	{
		return Math.exp(- x * x / 2) / Math.sqrt(2 * Math.PI);
	}
	
	/**
	 * Code from: http://introcs.cs.princeton.edu/java/93integration/TrapezoidalRule.java.html
	 */
	static double integrate(double a, double b, int N)
	{
		double h = (b - a) / N; // step size
		double sum = 0.5 * (densityFunc(a) + densityFunc(b)); // area
		for (int i = 1; i < N; i++)
		{
			double x = a + h * i;
			sum = sum + densityFunc(x);
		}

		return sum * h;
	}
	
	

}
