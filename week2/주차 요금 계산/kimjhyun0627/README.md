  # 문제 풀이

## 문제 해설


**defaultdict를 애용했다. defaultdict 클래스는 dictionary의 파생형으로, dictionary에 찾고자 하는 key값이 없다면, default 값을 value로 갖는 item을 새로이 만들어주므로 위 문제를 푸는 데 매우 편리할 것이라고 생각했다.**

1. (key: 번호판 숫자, value: 입차 시 시간) 을 갖는 numbers_io defaultdict를 생성한다.
2. (key: 번호판 숫자, value: 누적 주차 시간) 을 갖는 numbers_duration defaultdict를 생성한다.
3. (key:번호판 숫자, value: 요금) 을 갖는 total_fee defaultdict를 생성한다.
4. 1번의 numbers_io와 입력받는 records를 통해 누적 주차 시간을 2번의 numbers_duration에 저장한다.
5. 2번의 numbers_duration과 입력받는 fees 리스트를 통해 3번의 total_fee를 계산한다.
6. total_fee dictionary를 key를 기준으로 정렬한 값 중 value만을 모아 list 형태로 return한다.



## 시간 복잡도

$$O(len(records))$$