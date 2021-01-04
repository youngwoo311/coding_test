#https://programmers.co.kr/learn/courses/30/lessons/60057
#프로그래머스 [문자열 압축]

def solution(s):
    answer = len(s)
    for seq in range(1, len(s)//2 + 1):
        compStr = ""
        splitStr = [s[a:a + seq] for a in range(0, len(s), seq) ]
        rate = 1

        for b in range(len(splitStr) - 1):
            if splitStr[b] == splitStr[b + 1]:
                rate = rate + 1
                if b + 1 == len(splitStr) - 1:
                    compStr = compStr + str(rate) + splitStr[b]
            else :
                if rate  == 1:
                    compStr = compStr + splitStr[b]
                else :
                    compStr = compStr + str(rate) + splitStr[b]
                    rate = 1
                if b + 1 == len(splitStr) - 1:
                    compStr = compStr + splitStr[b + 1]

        if len(compStr) < answer:
            answer = len(compStr)

    return answer
