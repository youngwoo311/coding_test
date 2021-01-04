# 프로그래머스 [짝지어 제거하기]
# https://programmers.co.kr/learn/courses/30/lessons/12973

def solution(s):
    answer = []

    for i in s :
        if len(answer) == 0 :
            answer.append(i)
        elif answer[-1] == i:
            answer.pop()
        else:
            answer.append(i)

    if len(answer) == 0 : return 1
    else: return 0
