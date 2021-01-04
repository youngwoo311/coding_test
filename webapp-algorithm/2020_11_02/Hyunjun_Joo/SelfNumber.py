# https://www.acmicpc.net/problem/4673

numbers = set(range(1,10000))
selfnum = set ()

for num in numbers :
    for i in str(num) :
        num += int(i)
    selfnum.add(num)

answer = numbers - selfnum
for a in sorted(answer):
    print(a)
