

def BCM(a):
    sum=0
    for i in range(0, a):
        if i%3==0 or i%5==0:
            sum+=i
    return sum

print(BCM(1000))
