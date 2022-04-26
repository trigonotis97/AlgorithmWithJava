package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_347 {
}

class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Number> numList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 1) + 1);

        for (int num : map.keySet()) numList.add(new Number(num, map.get(num)));
        Collections.sort(numList, (a, b) -> b.count - a.count); // count 내림차순으로 정렬
        for (int i = 0; i < numList.size(); i++) {
            if (i >= k && numList.get(i).count < numList.get(k - 1).count) break;
            resultList.add(numList.get(i).num);
        }
        Integer[] out = new Integer[resultList.size()];
        resultList.toArray(out);
        return null;

    }

    class Number {
        int num;
        int count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

    }
}
