#프로그래머스[3진법 뒤집기]
#https://programmers.co.kr/learn/courses/30/lessons/68935


def solution(n):
    answer = 0
    n = int(convert(n)[::-1])
    print(n)

    for ith, digit in enumerate(str(n)[::-1]):
        answer += int(digit) * (3 ** ith)

    return answer

def convert(n):
    T = "0123"
    q, r = divmod(n, 3)
    if q == 0:
        return T[r]
    else:
        return convert(q) + T[r]
