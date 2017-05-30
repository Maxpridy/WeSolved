from time import time

def get_primes(limit):
    '''
        Implementation of Sieve algorithm
        Limit <= 10**8
    '''
    a = [True] * limit
    a[0] = a[1] = False
    for i, isprime in enumerate(a):
        if isprime:
            yield i
            for n in range(i*i, limit, i):
                a[n] = False

start = time()
limit = 5
solution = sum(get_primes(limit))
elapsed = time() - start
print("Solution: {0} \t Time elapsed: {1}".format(solution, elapsed))

