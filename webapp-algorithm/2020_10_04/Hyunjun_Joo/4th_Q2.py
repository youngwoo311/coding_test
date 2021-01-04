#프로그래머스[두개 뽑아서 더하기]
#https://programmers.co.kr/learn/courses/30/lessons/68644

def solution(numbers):
    answer = []
    for ith in range(len(numbers) - 1):
        first = numbers.pop(0)
        for second in numbers:
            if first + second not in answer:
                answer.append(first + second)

    answer.sort()

    return answer
