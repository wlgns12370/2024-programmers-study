  # 문제 풀이

## 문제 해설


**python의 경우 heapq를 사용해야 효율성 테스트를 통과하는 것 같다.**


1. scoville list를 heapq로 변환한다.
2. 반복문을 통해 구현한다(꼭 범위 조건을 확인하자).



## 시간 복잡도
*heapq의 정렬 알고리즘에 의존한다*

$$O(log(len(scoville)))$$