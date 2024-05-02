#include <iostream>
#include <set>
#include <string>

int main() {
    int n;
    std::string s;
    std::cin >> n >> s;

    std::set<char> vowels = {'a', 'e', 'i', 'o', 'u'};
    int answer = 0;
    for (int i = 0; i < s.size(); i++) {
        if (vowels.find(s[i]) != vowels.end()) {
            answer++;
        }
    }
    std::cout << answer;

    return 0;
}
