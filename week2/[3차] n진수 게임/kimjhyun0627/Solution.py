def solution(n, t, m, p):
    dec_list = [i for i in range(t*m+p)]
    n_list = []
    for l in dec_list:
        base = ''
        while l>0:
            l, mod = divmod(l, n)
            if mod >= 10:
                mod = chr(ord('A') + mod%10)
            base += str(mod)
        n_list.append(base[::-1])

    str1 = '0' + ''.join(n_list)

    answer = str1[p-1:m*t:m]
    return answer
