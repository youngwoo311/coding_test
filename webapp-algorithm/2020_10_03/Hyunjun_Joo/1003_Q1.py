#https://programmers.co.kr/learn/courses/30/lessons/62048?language=python3
#프로그래머스 [멀쩡한 사각형]

def solution(w,h):
    answer = 1

    if(gcm(w,h) == 1) :
        answer = (w * h) - (w + h - 1)
    else :
        answer = (w * h) - (w + h - gcm(w,h))

    return answer

def gcm(a,b):
    ans = 1
    for k in range(2, min(a,b) + 1):
        while (a % k == 0) and (b % k == 0):
            a = a // k
            b = b // k
            ans = ans * k
            continue
    return ans
