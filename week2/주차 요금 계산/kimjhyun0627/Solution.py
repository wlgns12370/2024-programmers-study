from collections import defaultdict

def solution(fees, records):
    MAXTIME = 60*23+59
    numbers_io = defaultdict(int)
    numbers_duration = defaultdict(int)
    total_fee = defaultdict(int)

    for r in records:
        time, number, io = r.split()
        minutes = int(time.split(':')[0]) * 60 + int(time.split(':')[1])
        if io == 'OUT':
            duration = minutes - numbers_io[number]
            numbers_duration[number] += duration
            del numbers_io[number]
        else:
            numbers_io[number] = minutes
        
    for n, t in numbers_io.items():
        numbers_duration[n] += MAXTIME - t
    
    for n, d in numbers_duration.items():
        total_fee[n] += fees[1]
        if d > fees[0]:
            total_fee[n] += ((d - fees[0]) // fees[2]) * fees[3]
            if (d - fees[0]) % fees[2] != 0:
                total_fee[n] += fees[3]
    
    answer = [i[1] for i in sorted(total_fee.items(), key=lambda item: item[0])]
    return answer