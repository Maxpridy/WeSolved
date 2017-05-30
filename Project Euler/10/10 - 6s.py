

import time

start = time.time()


def eratosthenes_sieve(number):
    maximum = number + 1
    primes = dict()
    for values in range(2, maximum):
        primes[values] = True

    for values in primes:
        factors = range(values, maximum, values)
        for factor in factors[1:]:
            primes[factor] = False
    return [num for num in primes if primes[num] == True]

print(sum(eratosthenes_sieve(2000000)))

end = time.time()
print(end-start)