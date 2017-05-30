# Problem 10
import math
import time

start = time.time()

def is_Prime(n):
    '''is_Prime(n) -> bool
    Returns True if n is prime, False otherwise.'''
    if n in [0,1]:
        return False
    if n == 2:
        return True
    for i in range(2,math.ceil(math.sqrt(n))+1):
        if n % i == 0:
            return False
    else:
        return True

def sum_primes(n):
    total = 0
    for i in range(0,n+1):
        if is_Prime(i) == True and i< n:
            total += i
    return total

print(sum_primes(2000000))


end = time.time()
print(end-start)