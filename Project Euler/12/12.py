

import time
start = time.time()


def factordivision(num):
	lst = []
	for i in range(1, num+1):
		if(num%i==0):
			lst.append(i)

	return lst


for i in range(1, 100000000000):
	lst = factordivision(i)
	if (len(lst)>30):
		print(lst)
		print(i)
		break


end = time.time()
print(end-start)