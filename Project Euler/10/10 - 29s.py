
import math
import sys
import time

MAX_NUM = 2000000
MIN_NUM = 1
sum = 0
start = time.time()
from decimal import *

def is_prime(n):
	if n<=1:
		return False
	if n<=3:
		return True
	if n%2==0 or n%3==0:
		return False
	r = int(math.sqrt(MAX_NUM))
	f = 5
	while f < r:
		if(n%f==0 or n%(f+2)==0):
			return False
		f += 6

	return True

for num in range(MIN_NUM, MAX_NUM):

	if(is_prime(num)):
		sum += num


print("답 :", sum)
end = time.time()
print(end-start)