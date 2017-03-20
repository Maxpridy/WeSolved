using System;


namespace Csharpselfstudy
{
    class program
    {
        static void Main(string[] args)
        {
            string str1;
            int a, b;

            str1 = Console.ReadLine();

            if (str1.Length > 3)
            {
                return;
            }

            a = str1[0] - 48;
            b = str1[2] - 48;



            Console.WriteLine(a + b);
        }
    }
}

