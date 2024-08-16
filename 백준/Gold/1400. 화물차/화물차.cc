#include<bits/stdc++.h>
#define endl '\n'
#define HOR 0
#define VER 1
#define EMPTY '#'
#define WALL '.'
#define fi first
#define se second
#define pb push_abck
#define rep(i,a,b) for(int i=a;i<b;i++)
const int MAXNM = 20, INF = 987654321;
const int dx[]={0, 0, 1, -1}, dy[]={-1, 1, 0, 0};
struct traffic{bool st; int tm[2];};
struct cell{int x; int y; int tm;
    bool operator<(const struct cell& t) const{
        return tm > t.tm;
    }
};
using namespace std;

int cntTraffic = 0;
int n, m, sx, sy, ex, ey;
char a[MAXNM][MAXNM];
vector<traffic> light;
int seen[MAXNM][MAXNM];
priority_queue<cell> pq; // time, x, y
void input(){
    cntTraffic = -1;
    rep(i, 0, n){
        rep(j, 0, m){
            cin >> a[i][j];
            if(a[i][j] == 'A') sx = i, sy = j, a[i][j] = '#';
            if(a[i][j] == 'B') ex = i, ey = j, a[i][j] = '#';
            if(a[i][j] >='0' && a[i][j] <= '9' && cntTraffic < (a[i][j]-'0'))
                cntTraffic = a[i][j] - '0';
        }
    }
    if(cntTraffic == -1) return;
    light.clear();
    light = vector<traffic> ( cntTraffic+1 );
    rep(i, 0, cntTraffic+1){
        bool st = HOR;
        int num; char ch; int tm[2];
        cin >> num >> ch >> tm[0] >> tm[1];
        if(ch == '|') swap(tm[0], tm[1]), st = VER;
        light[i].st = st, light[i].tm[0] = tm[0], light[i].tm[1] = tm[1];
    }
}
void init(){
    fill(&seen[0][0], &seen[MAXNM-1][MAXNM], INF);
    while(!pq.empty()) pq.pop();

}
bool over(int x, int y){return (x<0 || y<0 || x>=n || y>=m);}
void whenAble(int nth, int& ntm, int d){
    int sum = light[nth].tm[0] + light[nth].tm[1];
    int tmptm = (ntm-1) % sum;
    bool curdir = d/2;
    if(tmptm < light[nth].tm[0]){
        if(curdir == light[nth].st){
            // Do nothing
        }else{
            ntm += (light[nth].tm[0] - tmptm);
        }
    }else{
        if(curdir == light[nth].st){
            ntm += (sum-1 - tmptm) +1;
        }else{
            // Do nothing
        }
    }
}
void bfs(){
    while(!pq.empty()){
        int x = pq.top().x, y = pq.top().y, tm = pq.top().tm; pq.pop();
        if(x == ex && y == ey){
            cout << tm << endl;
            return;
        }
        rep(i, 0, 4){
            int nx = x+dx[i], ny = y+dy[i];
            if(over(nx, ny) || a[nx][ny] == WALL) continue;
            if(a[nx][ny] == EMPTY){
                if(seen[nx][ny] > tm+1){
                    seen[nx][ny] = tm+1;
                    pq.push({nx, ny, tm+1});
                }
            }else{
                int nth = a[nx][ny] -'0', ntm = tm+1;
                whenAble(nth, ntm, i);
                if(seen[nx][ny] > ntm){
                    seen[nx][ny] = ntm;
                    pq.push({nx, ny, ntm});
                }
            }
        }
    }
    cout << "impossible\n";
}
void process(){
    input();
    init();
    seen[sx][sy] = 0;
    pq.push({sx, sy, 0});
    bfs();
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    while(true){
        cin >> n >> m;
        if(n == 0 && m == 0) break;
        process();
    }
    return 0;
}