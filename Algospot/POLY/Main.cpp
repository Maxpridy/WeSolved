#include<iostream>
#include<cstdio>
#include<cstring>

using namespace std;

const int MOD = 10 * 1000 * 1000;
int cache[101][101];

int poly(int n, int first) {
	if (n == first) return 1;
	int& ret = cache[n][first];

	if (ret != -1) return ret;

	ret = 0;
	for (int second = 1; second <= n - first; second++) {
		int add = second + first - 1;
		add = add * poly(n - first, second);
		add = add % MOD;
		ret = ret + add;
		ret = ret % MOD;
	}
	return ret;
}

int main()
{
	memset(cache, -1, sizeof(cache));

	int cases;
	cin >> cases;
	for (int cc = 0; cc < cases; cc++) {
		int n;
		cin >> n;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			(ret += poly(n, i + 1)) %= MOD;
		}
		cout << ret << endl;
	}
}