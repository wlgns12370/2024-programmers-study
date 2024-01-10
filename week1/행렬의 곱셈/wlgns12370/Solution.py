import sys
def solution(arr1, arr2):
    answer = []
    arr1rowcnt = len(arr1)
    arr2rowcnt = len(arr2)
    arr2colcnt = len(arr2[0])
    for i in range(arr1rowcnt):
        buc = []
        for j in range(arr2colcnt):
            temp = 0
            for k in range(arr2rowcnt):
                temp += arr1[i][k] * arr2[k][j]
            buc.append(temp)
        answer.append(buc)
    return answer