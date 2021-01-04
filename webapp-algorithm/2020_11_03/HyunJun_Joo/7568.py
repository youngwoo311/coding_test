#https://www.acmicpc.net/problem/7568

n = int(input())

li = []
for _ in range(n):
    li.append(list(map(int,input().split(" "))))

answer = [1 for i in range(n)]

for i in range(n - 1):
    for j in range(i + 1, n):
        if li[i][0] > li [j][0] and li[i][1] > li [j][1] :
            answer[j] += 1
        elif li[i][0] < li [j][0] and li[i][1] < li [j][1]:
            answer[i] += 1

print(" ".join(map(str, answer)))
