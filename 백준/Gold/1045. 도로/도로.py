import sys
import heapq
def input():
    return sys.stdin.readline().rstrip()
 
 
 
def find_parents(X):
    if X == make_set[X]:
        return X
    make_set[X] = find_parents(make_set[X])
    return make_set[X]
 
 
def union(x,y):
    X = find_parents(x)
    Y = find_parents(y)
 
    if X !=Y:
        if ranks[X]< ranks[Y]:
            X,Y = Y,X
        make_set[Y] = X
        if ranks[X] == ranks[Y]:
            ranks[X] += 1
        return True
    return False
N,M = map(int,input().split())
 
edge_list = []
 
for x in range(N):
    temp = list(input())
    for y in range(x+1,N):
        if temp[y] == 'Y':
            heapq.heappush(edge_list,(x,y))
city_cnt = 0
if len(edge_list) >= M:
    result = [0 for _ in range(N)]
    make_set = [i for i in range(N)]
    ranks = [1 for _ in range(N)]
    remain_list = []
    while edge_list:
        node_a,node_b = heapq.heappop(edge_list)
        if union(node_a,node_b):
            city_cnt += 1
            result[node_b] += 1
            result[node_a] += 1
        else:
            heapq.heappush(remain_list,(node_a,node_b))
    if city_cnt != N-1:
        print(-1)
    else:
        remain_cnt = M - city_cnt
 
        while remain_cnt>0:
            node_a,node_b = heapq.heappop(remain_list)
            result[node_a] += 1
            result[node_b] += 1
            remain_cnt -= 1
        print(*result)
else:
    print(-1)