import sys
from collections import deque

n, m, r = map(int, sys.stdin.readline().rstrip().split())

nodes = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
nodes_depth = [0 for _ in range(n+1)]
nodes_cnt = [0 for _ in range(n+1)]

for _ in range(m):
    tail, head = map(int, sys.stdin.readline().rstrip().split())
    nodes[tail].append(head)
    nodes[head].append(tail)

for i in range(n+1):
    nodes[i].sort()
stack = deque()
stack.append([r, 0])
cnt = 1
while stack:
    cur_node, depth = stack.pop()
    if visited[cur_node]: continue
    visited[cur_node] = True
    nodes_depth[cur_node] = depth
    nodes_cnt[cur_node] = cnt
    cnt += 1
    for next_node in nodes[cur_node]:
        if not visited[next_node]:
            stack.append([next_node, depth+1])

total = 0
for i in range(1, n+1):
    if i == r or nodes_depth[i] == 0: continue
    else: total += nodes_depth[i]*nodes_cnt[i]

print(total)