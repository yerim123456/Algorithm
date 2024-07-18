# 문제 링크: https://joonlab.net/problem.php?id=1073&csrf=HUNniiBgzrBXfk1PMnhvwbTglFf4y7If
# 배운점:
# 1) zip 표현
# 2) int( a > b) > boolean을 바로 형변환해서 나타내는 법

def check(A, B):
    a,b = 0, 0
    for x,y in zip(A,B):
        if x > y:
            a += 1
        elif x < y:
            b += 1
    return int(a > b)

A = list(map(int, input().split()))
B = list(map(int, input().split()))
print(check(A, B))
