#include <algorithm>
#include <sstream>
#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <stack>
#include <deque>
#include <string.h>
#include <cstdio>
#include <cmath> 
#include <set>
#include <map>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e9 + 7;

void dfs(int size, int index, vector<int>& count, string& s) {
  if (size == index) {
    // answer.push_back(string(s));
    cout << s << '\n';
    return;
  }

  for (int i = 0; i < 26; i++) {
    if (count[i] == 0) {
      continue;
    }
    
    count[i]--;
    s.push_back(i + 'a');
    dfs(size, index + 1, count, s);
    s.pop_back();
    count[i]++;
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n; cin >> n;
  // map<int, set<string> > m;

  // for (int i = 0; i < n; i++) {
  //   string s; cin >> s;
  //   vector<int> count(26, 0);
  //   string orderedString;
    
  //   for (int j = 0; j < s.length(); j++) {
  //     count[s.at(j) - 'a']++;
  //   }

  //   for (int j = 0; j < count.size(); j++) {
  //     for (int c = 0; c < count[j]; c++) {
  //       orderedString.push_back(j + 'a');
  //     }
  //   }

  //   m[orderedString.length()].insert(orderedString);
  // }
  
  // vector<string> answer;
  // for (int i = 1; i <= 20; i++) {
  //   for (auto v : m[i]) {
  //     vector<int> count(26, 0);

  //     for (int j = 0; j < v.length(); j++) {
  //       count[v.at(j) - 'a']++;
  //     }

  //     string s = "";
  //     dfs(i, 0, answer, count, s);
  //   }
  // }

  // sort(answer.begin(), answer.end());
  // for (auto v : answer) {
  //   cout << v << '\n';
  // }

  while (n-- > 0) {
    string s; cin >> s;
    vector<int> cnt(26, 0);
    string ss = "";
    
    for (auto v : s) {
      cnt[v - 'a']++;
    }
    
    dfs(s.length(), 0, cnt, ss);
  }

	return 0;
}