#include <stdio.h>

int ABS(int n) { return n<0?-n:n; }
int mod(int n, int b)
{
  int r=n%ABS(b);
  if(r<0) r+=ABS(b);
  return r;
}
int base(int n, int b, char r[])
{
  int na=b>0?ABS(n):n, t; int c=0;
  while(na) { t=mod(na,b); na=(na-t)/b; r[c++]=t+'0'; } 
  if(!c) r[c++]='0'; r[c]=0;
  return (b>0&&n<0);
}
void print(char r[], int m)
{
  int i;
  if(m) putchar('-');
  for(i=1;r[i];i++);
  for(i--;i>=0;i--) putchar(r[i]); putchar('\n'); 
}
int main()
{
  int n, b, m; char r[64];
  scanf("%d%d",&n,&b);
  m = base(n, b, r);
  print(r, m);
}