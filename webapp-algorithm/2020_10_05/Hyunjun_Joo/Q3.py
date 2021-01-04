#프로그래머스 [다음 큰 숫자]
#https://programmers.co.kr/learn/courses/30/lessons/12911

def solution(n):

    bin_n = list(bin(n))[2:]
    if '0' not in bin_n:
        str = "10" + ''.join(bin_n[1:])
        return int(str, 2)

    num = bin_n.count("1")

    while(True):
        n += 1
        if num == list(bin(n))[2:].count("1") :
            return n


# 이렇게하면 더 깔 : 바이너리에서도 카운트 사용됨~
#     num = bin(n).count("1")

#     while(True):
#         n += 1
#         temp = bin(n).count("1")
#         if num == temp : return n
