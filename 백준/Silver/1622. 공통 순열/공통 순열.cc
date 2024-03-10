#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    string a, b;
    while (getline(cin, a) && getline(cin, b)) {
        map<char, int> freqA, freqB;
        for (char c : a) freqA[c]++;
        for (char c : b) freqB[c]++;

        vector<char> commonChars;
        for (auto& elem : freqA) {
            char ch = elem.first;
            if (freqB.find(ch) != freqB.end()) {
                int minFreq = min(freqA[ch], freqB[ch]);
                for (int i = 0; i < minFreq; i++) commonChars.push_back(ch);
            }
        }

        sort(commonChars.begin(), commonChars.end());

        for (char ch : commonChars) cout << ch;
        cout << "\n";
    }

    return 0;
}
