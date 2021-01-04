#https://www.acmicpc.net/problem/2750

N = int(input())
li = []

for _ in range(N):
    M = int(input())
    li.append(M)

for i in sorted(li):
    print(i)
