n=int(input())
if n==0:
    print(1)
else:
    sum=1
    cnt=0
    while cnt!=n:
        cnt+=1
        sum*=cnt
    print(sum)