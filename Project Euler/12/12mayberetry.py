


def factorization(num):
    ret = []
    i = 1

    while i <= num:
        if (num % i == 0):
            ret.append(i)
        i += 1

    return ret


def primeFactorization(num):
    dict = {}
    factor = 2

    while True:
        if (num%factor == 0):
            num /= factor
            if factor in dict:
                dict[factor] += 1
            else:
                dict[factor] = 1

        else:
            factor += 1

        if num == 1:
            return dict


def getFacNum(dict):
    retlist = []
    ret = 1

    for k in dict.keys():
        retlist.append(dict.get(k))

    retlist = map(lambda a: a+1, retlist)
    for val in retlist:
        ret *= val

    return ret



def getTriangleNumber(num):
    i = 1
    ret = 0

    while num > 0:
        ret += i
        i += 1
        num -= 1

    return ret


# gi = 1
# while True:
#     trinum = getTriangleNumber(gi)
#     dict = primeFactorization(trinum)
#     result = getFacNum(dict)
#
#     if result > 500:
#         break
#
#     print(trinum)
#
#     gi += 1
#
# print(gi)

#print(getFacNum(primeFactorization(getTriangleNumber(12375))))
print(getTriangleNumber(12375))