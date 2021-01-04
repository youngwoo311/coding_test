#프로그래머스[가장 큰 정사각형 찾기]
#https://programmers.co.kr/learn/courses/30/lessons/12905

def solution(board):
    answer = 0

    if len(board) == 1 or len(board[0]) == 1:
        return 1

    for i in range(1,len(board)):
        for j in range(1, len(board[0])):
            if board[i][j] == 1:
                min_len = min(board[i - 1][j - 1], board[i- 1][j], board[i][j - 1])
                board[i][j] = min_len + 1
                answer = max(answer, min_len + 1)

    return answer ** 2
