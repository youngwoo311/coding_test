#프로그래머스[쿼드압축 후 개수 세기]
#https://programmers.co.kr/learn/courses/30/lessons/68936

import numpy as np

def solution(arr):
    return check(np.array(arr)).tolist()

def check(arr):
    if np.all(arr == 0):
        return np.array([1,0])
    if np.all(arr == 1):
        return np.array([0,1])

    n = len(arr[0]) // 2

    return check(arr[:n,:n]) + check(arr[n:,:n]) + check(arr[:n,n:]) + check(arr[n:,n:])
