#https://www.acmicpc.net/problem/2751

N = int(input())
li = []

for _ in range(N):
    M = int(input())
    li.append(M)

def mergeSort(a):
    if len(a) > 1:
        mid = len(a)//2
        la, ra = a[:mid], a[mid:]
        mergeSort(la)
        mergeSort(ra)
        li, ri, i = 0, 0, 0
        while li < len(la) and ri < len(ra):
            if la[li] < ra[ri]:
                a[i] = la[li]
                li += 1
            else :
                a[i] = ra[ri]
                ri += 1
            i += 1
        a[i:] = la[li:] if li != len(la) else ra[ri:]

mergeSort(li)

for i in li:
    print(i)
