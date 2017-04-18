
class Person
{
    public int Num { get; set; }
    public string Name { get; set; }
}


class program
{
    static void Main(string[] args)
    {
        ArrayList strlist = new ArrayList();

        var second_assist = 0;
        for (var first = 100; first < 1000; first++)
        {
            for (var second = 100 + second_assist; second < 1000; second++)
            {
                string str = "" + first * second;
                if (str.Length == 5)
                {
                    if (str[0] == str[4] && str[1] == str[3])
                    {
                        str = str + " " + first + "*" + second;
                        strlist.Add(str);
                    }
                }
                else
                {
                    if (str[0] == str[5] && str[1] == str[4] && str[2] == str[3])
                    {
                        str = str + " " + first + "*" + second;
                        strlist.Add(str);
                    }
                }
            }
            second_assist++;
        }

        var big = 0;
        foreach (String str in strlist)
        {
            var temp = Int32.Parse(str.Substring(0, 6));
            if (big < temp)
                big = temp;
            Console.Write(big + " ");
            Console.WriteLine(str);
        }

    }
}
