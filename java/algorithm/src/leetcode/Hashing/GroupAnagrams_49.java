package leetcode.Hashing;

import leetcode.Sliding_Window.longest_ones_after_one_flip.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    문자열 배열 strs가 주어질 때, 애너그램끼리 묶어서 반환하세요.
    반환 순서는 아무 순서나 가능합니다.

    예시 1:
    입력: strs = ["eat","tea","tan","ate","nat","bat"]
    출력: [["bat"], ["nat","tan"], ["ate","eat","tea"]]
    설명:
    - "bat"은 다른 어떤 문자열로도 재배열할 수 없습니다.
    - "nat"과 "tan"은 서로 글자를 재배열하면 같은 단어가 됩니다.
    - "ate", "eat", "tea" 역시 서로 애너그램입니다.

    예시 2:
    입력: strs = [""]
    출력: [[""]]

    예시 3:
    입력: strs = ["a"]
    출력: [["a"]]
*/
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        GroupAnagrams_49 sol = new GroupAnagrams_49();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = sol.groupAnagrams(strs);
        System.out.println("result:" + result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> ArraystoList = Arrays.stream(strs).toList();

        // "aet" => ["eat", "tea", "ate"]
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);  // aet
            List<String> list;
            if (!map.containsKey(sorted)) {
                list = new ArrayList<>();
                list.add(str);
            } else {
                list = map.get(sorted);
                list.addLast(str);
            }
            map.put(sorted, list);
        }

        return new ArrayList<>(map.values());
    }
}
