def solution(n, k):
    base = ''
    while n>0:
        n, mod = divmod(n, k)
        base += str(mod)
    
    potential = [int(s) for s in base[::-1].split('0') if s]

    def is_prime(p: int):
        if p < 2:
            return False
        for i in range(2, int(p ** 0.5) + 1):
            if p % i == 0:
                return False
        return True
    
    answer = 0
    for p in potential:
        if is_prime(p):
            answer += 1

    return answer