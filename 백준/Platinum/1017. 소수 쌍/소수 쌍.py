import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

#### 이분매칭
def dfs(x, i):
    visited[x] = True
    for y in graph[x]:
        if y == i:
            continue
        if matched_Y[y] == 0:
            matched_Y[y] = x
            matched_X[x] = y
            return True
        # y 노드가 이미 매칭이 되어있는 경우, y 노드와 매칭되어 있는 노드가 다른 노드와 매칭이 가능한지 확인
        elif not visited[matched_Y[y]] and dfs(matched_Y[y], i):
            # 다른 노드와 매칭이 가능한 경우, y 노드와 x 노드를 매칭
            matched_Y[y] = x
            matched_X[x] = y
            return True
    return False

# 소수판별
def is_prime(number):
    if number <= 1:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True

n = int(input())
arr = list(map(int, input().split()))

A, B = [], []
# 이분그래프, 인덱스변환
A_idx, B_idx = {}, {}
countA, countB = 1, 1

for i in arr:
    if i % 2 == arr[0] % 2: # 홀수
        A.append(i)
        A_idx[i] = countA
        countA += 1
    else:
        B.append(i)
        B_idx[i] = countB
        countB += 1

graph = [[] for _ in range(len(A)+1)]
for a in A:
    for b in B:
        if is_prime(a+b):
            graph[A_idx[a]].append(B_idx[b])

# tmp에 있는 B 정점들을 하나씩 확인
tmp = graph[1]

# 첫 번째 요소를 그래프에서 제거
graph[1] = []

res = []
for i in tmp: # i 는 B집합 노드들
    matched_X = [0] * (len(A)+1)
    matched_Y = [0] * (len(B)+1)
    cnt = 0
    for j in range(2, len(A)+1):
        if matched_X[j] == 0:
            visited = [False] * (len(A)+1)
            if dfs(j, i):
                cnt += 1

    if cnt == (n // 2 - 1):
        res.append(i)

if not res:
    print(-1)
    exit()
for idx, i in enumerate(res):
    res[idx] = B[i-1]

res.sort()

print(' '.join(map(str, res)))