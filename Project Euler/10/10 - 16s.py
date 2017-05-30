
import math
import sys
import time

MAX_NUM = 2000000
MIN_NUM = 3
sum = 2
start = time.time()
from decimal import *


for i in range(MIN_NUM, MAX_NUM, 2):
	j = 3
	while(True):
		if(j*j>=i):
			break
		if(i%j==0):
			break
		j += 2

	if(j > math.sqrt(i)):
		sum += i



print("답 :", sum)
end = time.time()
print(end-start)