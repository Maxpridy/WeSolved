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



// 비동기 이해하기 힘든예제 그나마 나은거
/*
public static int a = 0;
static object lo = new object();

static void Main(string[] args)
{
    for (int j = 0; j < 5; j++)
    {
        add();
        Console.WriteLine(a);
    }

    Console.WriteLine(a);

}

static async void add()
{
    var task = Task.Factory.StartNew(() =>
    {
        a = a + 1;
    });

    await task;

}
*/

//비동기화 Task 예제
/*
 * public static int a;

        static void Main(string[] args)
        {

            Task<int> task1 = add();
            a = task1.Result;

            Task<int> task2 = add();
            a = task2.Result;
        

            Console.WriteLine(a);
        }

        static async Task<int> add()
        {
            int temp = a;
            Task<int> task1 = Task.Factory.StartNew<int>(() =>
            {
                temp++;
                return temp;
            });

            await task1;

            return temp;
        }
        */



//키보드 예제
/*
[DllImport("user32.dll", CharSet = CharSet.Auto, SetLastError = true)]
internal static extern IntPtr CallNextHookEx(IntPtr hhk, int nCode, UIntPtr wParam, IntPtr lParam);

[DllImport("user32.dll")]
public static extern void keybd_event(byte vk, byte scan, int flags, ref int extrainfo);

static void Main(string[] args)
{
    Thread.Sleep(3000);

    const byte AltKey = 80;
    const int KEYUP = 0x0002;
    int Info = 0;
    keybd_event(AltKey, 0, 0, ref Info);   // ALT key 다운
    keybd_event(AltKey, 0, KEYUP, ref Info);  // ALT key 업
}
*/

// 가우스 1번 답
/*
int sum = 0;
            for(int i=1 ;i<1000;i++)
            {
                if(i%5==0 || i%3==0)
                {
                    sum += i;
                }

            }

            Console.WriteLine(sum);
            */


//ArrayList 사용법
/*

ArrayList ar = new ArrayList();

ar.Add("Hello");
            ar.Add(6);
            ar.Add("World");
            ar.Add(true);

            Console.WriteLine("Contain(6) : " + ar.Contains(6));

            ar.Remove("World");

            ar[2] = false;

            Console.WriteLine();

            foreach(object obj in ar)
            {
                Console.WriteLine(obj);
            }


    */


// 정규식 자료구조?식으로 사용법
/*
 * ParameterExpression leftExp = Expression.Parameter(typeof(int), "a");
            ParameterExpression rightExp = Expression.Parameter(typeof(int), "b");
            BinaryExpression addExp = Expression.Add(leftExp, rightExp);

            Expression<Func<int, int, int>> addLambda = Expression<Func<int, int, int>>.Lambda<Func<int, int, int>>(addExp, new ParameterExpression[] { leftExp, rightExp });

            Func<int, int, int> addFunc = addLambda.Compile();
            Console.WriteLine(addFunc(10, 2));
            */


// 정규식 자료구조식 간단하게
/*
 * 
 * Expression<Func<int, int, int>> exp = (a, b) => a + b;

            Func<int, int, int> func = exp.Compile();
            Console.WriteLine(func(10, 2));

    */


// 이벤트 간단예제
/*
 * class TestClass
    {
        // 이벤트용 델리 게이트 선언
        public delegate void ClickEvent(object sender, EventArgs args);
        // 이벤트 선언
        public event ClickEvent ExamEvent;

        // 클릭함수
        // 실행 순서 - ②
        public void click()
        {
            // 이벤트 함수를 생성
            EventArgs args = new EventArgs();
            // 이벤트를 호출
            ExamEvent(this, args);
        }
    }

    class Program : TestClass
    {
        static void Main(string[] args)
        {
            new Program();
        }
        public Program()
        {
            // 이벤트를 생성 (델리 게이트 누적)
            // 실행 순서 - ③
            this.ExamEvent += new ClickEvent(Program_ExamEvent);
            // 클릭!
            // 실행 순서 - ①
            click();
        }
        // 생성자에서 클릭을 누르면 이벤트 호출로 불린다.
        void Program_ExamEvent(object sender, EventArgs args)
        {
            Console.WriteLine("이벤트");
        }
    }

    */
