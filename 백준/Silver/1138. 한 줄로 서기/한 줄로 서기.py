N = int(input())
x = list(map(int, input().split()))
 
d = [0] * N
for i in range(N):
    for j in range(N):
        if x[i] == 0 and d[j] == 0:
            d[j] = i + 1		# i 가 0 부터 시작하니 + 1을 해줌
            break
        elif d[j] == 0:
            x[i] -= 1
            
print(' '.join(map(str, d)))