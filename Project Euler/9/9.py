#
# import sys
# A = int(sys.stdin.readline())
# B = int(sys.stdin.readline())
# sum = A + B
# print(sum)


import sys
import time

MAX_NUM = 1000
MIN_NUM = 1
callcount = 0

start = time.time()


for a in range(MIN_NUM, MAX_NUM) :
	for b in range(MIN_NUM, MAX_NUM):
		if(a>=b):
			continue

		for c in range(MIN_NUM, MAX_NUM):
			if (b >= c):
				continue
			if(c*c == a*a+b*b and a+b+c==1000):
				print(a, b, c)


end = time.time()

print(end-start)