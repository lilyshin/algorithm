package programmers.뉴스클러스터링_17677;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("aaa", "AAAA");
	}

	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		List<String> str1List = getElement(str1);
		List<String> str2List = getElement(str2);

		return jacquard(str1List, str2List);
	}

	public List<String> getElement(String str) {
		// 문자열을 두 글자로 자른 원소를 넣을 list
		List<String> strList = new ArrayList<String>();

		for (int i = 0; i < str.length() - 1; i++) {
			int str1Num = (int) str.charAt(i);
			int str2Num = (int) str.charAt(i + 1);

			// 문자열->숫자 ASCII 코드로 영문자만 받기
			if ((64 < str1Num && str1Num < 91) || (96 < str1Num && str1Num < 123)) {
				if ((64 < str2Num && str2Num < 91) || (96 < str2Num && str2Num < 123)) {

					strList.add(String.valueOf((char) str1Num).concat(String.valueOf((char) str2Num)));
				}
			}
		}

		return strList;
	}

	public int jacquard(List<String> str1List, List<String> str2List) {
		// 공집합일 경우 return
		if (str1List.size() == 0 && str2List.size() == 0) {
			return 65536;
		}

		int min = 0;
		int max = str1List.size() + str2List.size();

		for (String s : str1List) {
			for (int j = 0; j < str2List.size(); j++) {
				if (s.equals(str2List.get(j))) {
					min++;
					str2List.remove(j);	// 중복 원소 제거
					break;
				}
			}
		}

		max = max - min;

		double result = (double) min / max;

		return (int) (result * 65536);
	}
}
