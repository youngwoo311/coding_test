#https://www.acmicpc.net/problem/2231

n = int(input())

def get_num(num) :
    for i in range(num):
        if num == i + sum(map(int, str(i))):
            return i
    return 0

print(get_num(n))
