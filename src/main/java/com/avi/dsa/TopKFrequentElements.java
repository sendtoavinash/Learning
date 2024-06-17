package com.avi.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);

        for (int i : res)
            System.out.println(i);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> (int) (map.get(b) - map.get(a)));
        int result[] = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = list.get(i);

        return result;
    }
}
