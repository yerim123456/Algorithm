# 문제 링크: https://joonlab.net/problem.php?id=1071
# 배운 점: 
#         python 은 ++ 없고 > += 1 사용해야 함
#         반복문 사용시, in range A X > in A 이고
#         i의 의미는 원소임 > i가 num이 아니고!! > 이거 헷갈리지 말기
# 생각한 점: 빨리 입력값 처리에 익숙해져야 함!!!

def check(k, A):
    cnt =0
    for i in A:
        if(i == k):
            cnt+= 1
    return cnt

n,k = map(int, input().split())
A = list(map(int, input().split()))
print(check(k, A))
