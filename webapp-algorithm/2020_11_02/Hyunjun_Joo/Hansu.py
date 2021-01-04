#https://www.acmicpc.net/problem/1065

num = int(input())
answer = 0

for n in range(1, num + 1):
    if n < 100:
        answer += 1
    else :
        temp = str(n)
        if int(temp[0]) - int(temp[1]) == int(temp[1]) - int(temp[2]):
            answer += 1

print(answer)
