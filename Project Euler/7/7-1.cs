class program
{
    static void Main(String[] args)
    {
        int[] array = new int[100000000];
        int length = array.Length;
        int count = 0;

        for (int i = 0; i < length; i++)
        {
            array[i] = i + 2;
        }

        for (int i = 0; i < length; i++)
        {
            if (array[i] == 0)
            {
                continue;
            }

            for (int j = 2 * i + 2; j < length; j += i + 2)
            {
                array[j] = 0;
            }
        }

        for (int i = 0; i < length; i++)
        {
            if (array[i] != 0)
            {
                count++;
                Console.WriteLine(count + " " + array[i]);
            }
        }
    }
}