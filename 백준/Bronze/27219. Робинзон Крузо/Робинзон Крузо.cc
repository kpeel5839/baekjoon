#include <iostream>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int n;
    cin >> n;

    for (int i = 0; i < n / 5; i++) {
        cout << "V";
    }
    for (int i = 0; i < n % 5; i++) {
        cout << "I";
    }
}