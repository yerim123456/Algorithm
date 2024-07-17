# 문제: https://joonlab.net/problem.php?id=1072&csrf=RvqI4vmsMYgFIuPMHyfoC3PxFXxMIqjg

def solution(n, A, i, j, k):
  for idx in range(i,j+1):
    A[idx] = A[idx] * k
  return sum(A)

n = map(int, input().split())
A = list(map(int, input().split()))
i,j,k = map(int, input().split())
print(solution(n, A, i, j, k))
