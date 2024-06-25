n=int(input())
while n!=0:
    n-=1;
    a,b,x=map(int,input().split())
    print(a*(x-1)+b)