from collections import deque

def solution(maps):
    x_len = len(maps) + 2
    y_len = len(maps[0]) + 2

    processed_map = [[0 for _ in range(y_len)]]
    for line in maps:
        tmp = [0]
        for l in line:
            tmp.append(l)
        tmp.append(0)
        processed_map.append(tmp)
    processed_map.append([0 for _ in range(y_len)])

    def dfs(x:int, y:int):
        destination = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        queue = deque()
        queue.append((x, y))
        while queue:
            x, y = queue.popleft()
            for d in destination:
                new_x = x + d[0]
                new_y = y + d[1]
                if processed_map[new_x][new_y] == 0:
                    continue
                if processed_map[new_x][new_y] == 1:
                    processed_map[new_x][new_y] = processed_map[x][y] + 1
                    queue.append((new_x, new_y))
               
        return processed_map[x_len-2][y_len-2]
    
    answer = dfs(1,1)
    return answer if answer != 1 else -1
