#https://www.acmicpc.net/status?user_id=hyunjun0315&problem_id=2798&from_mine=1

n, m = map(int, input().split())
v = list(map(int, input().split()))

answer = 0

for i in range(n - 2) :
    for j in range(i + 1, n - 1):
        for k in range(j + 1, n):
            temp = v[i] + v[j] + v[k]
            if temp <= m and temp > answer:
                answer = temp

print(answer)
