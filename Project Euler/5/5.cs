
class program
{
    static int count = 0;
    static void Main(String[] args)
    {

        for (int i = 1; i < 1000000000; i++)
        {
            count = 0;
            for (int j = 11; j < 21; j++)
            {
                if (i % j == 0)
                {
                    count++;
                }
                else
                {
                    break;
                }
                if (count == 10)
                {
                    Console.WriteLine(i + "");
                }
            }
        }
    }
}