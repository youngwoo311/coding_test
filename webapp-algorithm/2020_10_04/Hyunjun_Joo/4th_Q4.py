#프로그래머스[삼각달팽이]
#https://programmers.co.kr/learn/courses/30/lessons/68645

from itertools import chain
def solution(n):
    answer = [[0] * n for _ in range(n)]

    num = 1
    x, y = -1, 0
    for i in range(n):
        for j in range(i,n):
            if i % 3 == 0:
                x += 1
            elif i % 3 == 1:
                y += 1
            else:
                x -= 1
                y -= 1
            answer[x][y] = num
            num += 1

    li = [i for i in chain(*answer) if i != 0]

    return li
