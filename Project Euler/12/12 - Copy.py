

import time
import math
start = time.time()


BIG = 1000000000000

def factordivision(num):
	lst = []
	for i in range(1, num+1):
		if(num%i==0):
			lst.append(i)

	return lst


def factordivision2(num):
	lst = []
	target = num

	for i in range(1, BIG):
		for j in range(2, BIG):
			if(target%j==0):
				target = target/j
				lst.append(j)
				break

		if(target==1):
			break

	return lst

for i in range(2, BIG):
	diction = {}
	numofsoinsu = 1
	lst = factordivision2(i)
	#print(lst)

	for num in lst:
		diction[num] = diction.get(num, 0)+1

	for factor, factornum in diction.items():
		numofsoinsu *= factornum+1

	if(numofsoinsu>10):
		print(lst)
		print(i)
		print(numofsoinsu)
		break

end = time.time()
print(end-start)