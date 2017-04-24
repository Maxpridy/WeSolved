class program
{
    static void Main(String[] args)
    {
        int sumsq = 0;
        int sqsum = 0;

        Func<int, int> square = x => x * x;

        for (int i = 1; i < 101; i++)
        {
            sumsq += i;

            sqsum += square(i);
        }

        sumsq = square(sumsq);

        Console.WriteLine("sumsq : " + sumsq);
        Console.WriteLine("sqsum : " + sqsum);
        Console.WriteLine("subtract : " + (sumsq - sqsum));
    }
}