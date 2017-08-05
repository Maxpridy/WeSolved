#include<iostream>
#include<cstring>
#include<string>
#include<vector>

using namespace std;

int n, capacity;
int volume[100], need[100];
int cache[1001][100];
string name[100];
vector<string> picked;

int max(int a, int b) {
	return a > b ? a : b;
}

int pack(int capacity, int item) {
	if (item == n) return 0;

	int& ret = cache[capacity][item];
	if (ret != -1) return ret;

	ret = pack(capacity, item + 1);
	if (capacity >= volume[item]) {
		ret = max(ret, pack(capacity - volume[item], item + 1) + need[item]);
	}
	return ret;
}



void reconstruct(int capacity, int item, vector<string>& picked) {
	if (item == n) return;
	if (pack(capacity, item) == pack(capacity, item + 1))
		reconstruct(capacity, item + 1, picked);
	else {
		picked.push_back(name[item]);
		reconstruct(capacity - volume[item], item + 1, picked);
	}
}


int main() {
	int cases;
	cin >> cases;

	for (int cc = 0; cc < cases; cc++) {
		memset(cache, -1, sizeof(cache));
		cin >> n >> capacity;
		for (int i = 0; i < n; i++) {
			cin >> name[i];
			cin >> volume[i];
			cin >> need[i];
		}

		int result = pack(capacity, 0);
		reconstruct(capacity, 0, picked);
		printf("%d %d\n", result, picked.size());
		for (int i = 0; i < picked.size(); i++) {
			cout << picked.back() << endl;
			picked.pop_back();
		}
	}
}