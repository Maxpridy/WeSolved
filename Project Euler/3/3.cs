class program
{
    static void Main(string[] args)
    {
        ArrayList Primes = new ArrayList();

        var rear = 600851475143;
        while (rear != 1)
        {
            var front = 2;

            while (true)
            {
                if (rear % front == 0)
                {
                    rear /= front;
                    Primes.Add(front);
                    break;
                }
                front = front + 1;

            }
        }

        foreach (var prime in Primes)
        {
            Console.WriteLine(prime);
        }

    }
}