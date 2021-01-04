#https://programmers.co.kr/learn/courses/30/lessons/42628

import heapq

def solution(operations):
    answer = []
    heap = []

    for i in operations:
        a, b = i.split(" ")

        if a == "I":
            heapq.heappush(heap, int(b))

        else:
            if len(heap) != 0:
                if b == "-1":
                    heapq.heappop(heap)
                else :
                    heap.pop(len(heap) - 1)

    if len(heap) == 0:
        return [0, 0]
    else:
        return [heapq.nlargest(1,heap)[0], heapq.nsmallest(1,heap)[0]]



    return answer
