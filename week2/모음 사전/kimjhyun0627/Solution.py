def solution(word):
    vowel = ['A', 'E', 'I', 'O', 'U']
    dict_idx = [781, 156, 31, 6, 1]

    answer = len(word)
    for i in range(len(word)):
        answer += (vowel.index(word[i])) * dict_idx[i]

    return answer