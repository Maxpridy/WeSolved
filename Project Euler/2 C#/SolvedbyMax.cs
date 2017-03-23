using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Runtime.InteropServices;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Markup;

namespace Csharpselfstudy
{
    class program
    {
            
        static void Main(string[] args)
        {
            List<int> ar = new List<int>();
            ar.Add(1);
            ar.Add(2);
            int sum = 0;
            int index = 1;

            for(int i=2; ; i++)
            {
                ar.Add(0);
                ar[i] += ar[i-1] + ar[i - 2];
                if (ar[i] > 4000000)
                {
                    Console.WriteLine("index : {0}", index);
                    break;
                }

                index++;
            }

            for (int i = 0; i < ar.Count-1; i++)
            { 
                if(ar[i]%2==0)
                    sum += ar[i];
                Console.WriteLine(ar[i]);
            }

            Console.WriteLine("sum : {0}", sum);
        }
        
    }
}


