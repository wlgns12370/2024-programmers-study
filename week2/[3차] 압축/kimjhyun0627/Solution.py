def solution(msg):
    dic = [chr(i) for i in range(ord('A'), ord('Z')+1)]

    answer = []
    idx = 0
    while idx < len(msg):
        for jj in range(len(msg), idx, -1):
            if msg[idx:jj] in dic:
                answer.append(dic.index(msg[idx:jj])+1)
                if jj <= len(msg):
                    dic.append(msg[idx:jj+1])
                    idx = jj
                break

    return answer
