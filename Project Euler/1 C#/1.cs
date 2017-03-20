using System;


namespace Csharpselfstudy
{
    class program
    {
        static void Main(string[] args)
        {
            int sum=0;
            for(int i=1 ;i<1000;i++)
            {
                if(i%5==0 || i%3==0)
                {
                    sum += i;
                }

            }

            Console.WriteLine(sum);
        }
    }
}

//Hangeul is broken down here. It ues only English

