#https://www.acmicpc.net/problem/1003

N = int(input())
li = [(0,0) for _ in range(40)]
li[0] = (1,0)
li[1] = (0,1)


for _ in range(N):
    M = int(input())
    for i in range(2, M + 1):
        li[i] = (li[i - 1][0] + li[i - 2][0], li[i - 1][1] + li[i - 2][1])
    print(*li[M])
