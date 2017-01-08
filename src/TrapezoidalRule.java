public class TrapezoidalRule
{

	/**********************************************************************
	 * Standard normal distribution density function. Replace with any
	 * sufficiently smooth function.
	 **********************************************************************/
	static double f(double x)
	{
		return Math.exp(-x/2) / Math.sqrt(2 * Math.PI);
	}

	/**********************************************************************
	 * Integrate f from a to b using the trapezoidal rule. Increase N for more
	 * precision.
	 **********************************************************************/
	static double integrate(double a, double b, int N)
	{
		double h = (b - a) / N; // step size
		double sum = 0.5 * (f(a) + f(b)); // area
		for (int i = 1; i < N; i++)
		{
			double x = a + h * i;
			sum = sum + f(x);
		}

		return sum * h;
	}

	// sample client program
	public static void main(String[] args)
	{
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		System.out.println(integrate(a, b, 1000));
	}

}
