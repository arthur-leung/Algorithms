package com.arthur.leetcode;

import leetcode.Solution49;
import org.junit.Test;

import java.util.List;

public class Solution49Test {
    @Test
    public void testGroupAnagrams() {
        Solution49 solution = new Solution49();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> lists = solution.groupAnagrams(strings);
        System.out.println(lists);
    }
}
