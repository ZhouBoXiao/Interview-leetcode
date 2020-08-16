package _公司笔试._ali._2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int maxdigits = 9;
        //List<Map.Entry<Integer, List<Integer>>> luckies = new ArrayList<>();
        Map<Integer, List<Integer>> luckies = new HashMap<>();
//        luckies.put(1, )
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int count = 0;
            for (int i = l; i <= r ; i++) {
//                count += check(i);/
            }
            System.out.println(count);
        }
        scanner.close();
    }


}
/*

3
1 10
1 1000
1 100000

void dfs(vector<pair<int, vector<int>>> mem[], vector<int>& ref, int digits, int cur, int idx) {
    if (idx == digits) {
        vector<int> dcur;
        for (int c = cur; c; c /= 10) dcur.push_back(c % 10);
        reverse(dcur.begin(), dcur.end());
        mem[digits].push_back({cur, dcur});
    }
    else if (idx == 0) {
        for (int i = 1; i <= 9; i++)
            dfs(mem, ref, digits, cur * 10 + i, idx + 1);
    }
    else {
        int pos = idx - (digits - (int)ref.size());
        int diff = pos >= 0 ? ref[pos] : 0;
        int last = cur % 10;
        if (diff == 0)
            dfs(mem, ref, digits, cur * 10 + last, idx + 1);
        else {
            for (int sign : {-1, 1}) {
                int val = last + diff * sign;
                if (val < 0 || val > 9) continue;
                else dfs(mem, ref, digits, cur * 10 + val, idx + 1);
            }
        }
    }
}

int main() {
    const int maxdigits = 9;
    vector<pair<int, vector<int>>> luckies[maxdigits + 1];

    luckies[1].push_back({7, {7}});
    for (int digits = 2; digits <= maxdigits; digits++)
        for (int i = 1; i <= digits - 1; i++)
            for (auto& ref : luckies[i])
                dfs(luckies, ref.second, digits, 0, 0);

    vector<int> lucky_nums;
    for (int digits = 1; digits <= maxdigits; digits++)
        for (auto& v : luckies[digits])
            lucky_nums.push_back(v.first);
    sort(lucky_nums.begin(), lucky_nums.end());

    int T, l ,r;
    cin >> T;
    for (int ks = 1; ks <= T; ks++) {
        cin >> l >> r;
        auto pr = upper_bound(lucky_nums.begin(), lucky_nums.end(), r);
        auto pl = upper_bound(lucky_nums.begin(), lucky_nums.end(), l - 1);
        cout << pr - pl << endl;
    }
    return 0;
}
 */


