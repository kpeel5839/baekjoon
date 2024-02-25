import sys
import math
import heapq
from collections import deque, defaultdict
from itertools import permutations, combinations

INF = 10**18
inf = 2*10**9
mod = 10**9 + 7

def solve():
  n=int(sys.stdin.readline());
  for i in range(n):
    v=sys.stdin.readline().strip().split(" ");
    startValue=float(v[0])
    for i in range(1,len(v)):
      if(v[i]=='@'):
        startValue*=3
      elif(v[i]=='%'):
        startValue+=5
      else:
        startValue-=7
    sys.stdout.write("{:.2f}".format(startValue));
    sys.stdout.write("\n");

solve();
sys.stdout.flush();