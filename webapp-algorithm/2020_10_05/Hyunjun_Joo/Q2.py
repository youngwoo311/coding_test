#프로그머스[올바른 괄호]
#https://programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):

    li = list(s)
    check = 0

    for par in li :
        if par == '(' : check += 1
        else : check -= 1
        if check < 0 : return False

    return check == 0
