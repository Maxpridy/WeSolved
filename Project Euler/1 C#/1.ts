
class threefive_test
{
    BCM(target)
    {
        let sum=0;
        for (let i = 0; i < target; i++)
        {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;

        }
        return sum;
    }

}

class Hello {

}

let threefive = new threefive_test();
console.log(threefive.BCM(1000));

setTimeout(Hello, 2000);
