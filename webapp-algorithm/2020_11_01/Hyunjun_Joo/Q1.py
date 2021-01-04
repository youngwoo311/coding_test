# 프로그래머스 JadenCase 문자열 만들기
# https://programmers.co.kr/learn/courses/30/lessons/12951

def solution(s):
    answer = ''
    s = list(s.lower())

    if s[0].isalpha() :
        s[0] = s[0].upper()
    for i in range(1, len(s)):
        if s[i - 1] == " " and s[i].isalpha :
            s[i] = s[i].upper()

    return "".join(s)
