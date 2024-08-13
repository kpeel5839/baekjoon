import sys
input = sys.stdin.readline
n = int(input())

numbs = """###...#.###.###.#.#.###.###.###.###.###
#.#...#...#...#.#.#.#...#.....#.#.#.#.#
#.#...#.###.###.###.###.###...#.###.###
#.#...#.#.....#...#...#.#.#...#.#.#...#
###...#.###.###...#.###.###...#.###.###""".split()

can_make = dict()

def make_candidates():
    for i in range(5):
        for j in range(3):
            can_make[(i,j)] = set()
            for k in range(10):
                if numbs[i][j+k*4] == "#":
                    can_make[(i,j)].add(k)

def sol():
    numb = [input() for _ in range(5)]
    res = 0.0
    for s in range(n):
        can_ = set(range(10))
        for i in range(5):
            for j in range(s*4,s*4+3):
                if numb[i][j] == "#":
                    can_ &= can_make[(i,j%4)]
        
        if can_:
            res *= 10
            res += sum(can_)/len(can_)
        else:
            res = -1
            break

    print(res)
    
make_candidates()
sol()