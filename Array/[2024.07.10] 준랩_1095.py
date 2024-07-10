# 문제 번호: 준랩_1095
# 문제 링크: https://joonlab.net/problem.php?id=1095
# 배운 점: 입력 값에서 값을 빼오는 방식
# 부족한 점: 순서대로 알고리즘으로 제작하는 연습 & 문제 이해 속도

def solution(n, m, A, B):
    answer = []
    for k in B:
        cnt = 0
        for a in A:
            if a >= k:
                cnt += 1
        answer.append(cnt)
    return answer

n, m = map(int, input().split())
A = list(map(int, input().split()))
B = list(int(input()) for _ in range(m))
C = solution(n,m,A,B)
for c in C:
    print(c)
