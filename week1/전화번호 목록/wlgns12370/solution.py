def solution(phone_book):
    flag = True
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if phone_book[i] == phone_book[i+1][0:len(phone_book[i])]:
                flag = False
                return flag
    return flag