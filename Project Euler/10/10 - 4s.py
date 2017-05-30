

import time

start = time.time()

def getPrime(num):
	ls = [True] * (num - 1)  # to get primes below the given num

	for i in range(2, num):
		# All the true mapping in the list ls are prime numbers
		if (ls[i - 1] == True):
			# Adding true mapping from ls to prime numbers list ps
			ps.append(i)

		for j in range(i, num, i):
			# Mapping all the multiples of present no. as false.
			ls[j - 1] = False


ps = []
getPrime(2000000)
print(sum(ps))


end = time.time()
print(end-start)