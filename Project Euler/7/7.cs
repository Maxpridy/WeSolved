class program
{
    static void Main(String[] args)
    {
        int aim = 10001;
        for (int i = 2, count = 0; count < aim; i++)
        {
            int front = 2;
            int rear = i;

            for (;;)
            {
                if (rear == front)
                {
                    count++;
                    Console.WriteLine(count + " : " + i);
                    break;
                }
                else if (rear % front == 0)
                {
                    break;
                }
                if (front == 2) front++;
                else front += 2;
            }
        }
    }
}