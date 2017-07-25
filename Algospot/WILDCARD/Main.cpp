#include<cstring>
#include<iostream>
#include<algorithm>
#include<sstream>
#include<string>
#include<vector>
#include<cmath>
#include<cstdio>
#include<cstdlib>
#include<fstream>
#include<cassert>
#include<numeric>
#include<set>
#include<map>
#include<queue>
#include<list>
#include<deque>

using namespace std;

typedef long long ll;

string W, S;

bool match(const string& w, const string& s) {
	int pos = 0;

	while (pos < s.size() && pos < w.size() && (w[pos] == '?' || w[pos] == s[pos]))
		++pos;

	if (pos == w.size())
		return pos == s.size();

	if (w[pos] == '*') {
		for (int skip = 0; pos + skip <= s.size(); skip++)
			if (match(w.substr(pos + 1), s.substr(pos + skip)))
				return true;
		return false;
	}

	return false;
}

int cache[5001][5001];

bool matchMemorized(int w, int s) {
	int& ret = cache[w][s];
	if (ret != -1) return ret;
	while (s < S.size() && w < W.size() && (W[w] == '?' || W[w] == S[s])) {
		++w;
		++s;
	}

	if (w == W.size()) return ret = (s == S.size());

	if (W[w] == '*') {
		for (int skip = 0; skip + s <= S.size(); skip++) {
			if (matchMemorized(w + 1, s + skip))
				return ret = 1;
			return ret = 0;
		}
	}
}

bool matchMemorized2(int w, int s) {
	int& ret = cache[w][s];
	if (ret != -1) return ret;
	if (w < W.size() && s < S.size() && (W[w] == S[s]))
		return ret = matchMemorized2(w + 1, s + 1);

	if (w == W.size()) return ret = (s == S.size());

	if (W[w] == '*') {
		if (matchMemorized2(w + 1, s) || (s < S.size() && matchMemorized2(w, s + 1)))
			return ret = 1;
	}
	return ret = 0;
}

int main(int argc, char* argv[]) {
	int cases;
	cin >> cases;
	for (int cc = 0; cc < cases; cc++) {
		cin >> W;
		vector<string> ret;
		int cc2;
		cin >> cc2;
		while (cc2--) {
			cin >> S;
			memset(cache, -1, sizeof(cache));
			if (argc == 1) {
				if (matchMemorized(0, 0)) ret.push_back(S);
			}
			else {
				if (matchMemorized2(0, 0)) ret.push_back(S);
			}
		}
		sort(ret.begin(), ret.end());
		for (int i = 0; i < ret.size(); i++) {
			cout << ret[i] << endl;
		}
	}
}