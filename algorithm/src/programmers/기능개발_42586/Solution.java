package programmers.기능개발_42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		sol.solution(progresses, speeds);
	}

    public int[] solution(int[] progresses, int[] speeds) {
    	Queue<Integer> worktime = new LinkedList<Integer>();

		// 작업 완료하는 데에 걸리는 일수 계산: (100 - 작업 진도) / 작업 속도
    	for (int i = 0; i < progresses.length; i++) {
    		int time = (100 - progresses[i]) / speeds[i];

			// 나머지가 있으면 일수 + 1
    		if ((100 - progresses[i]) % speeds[i] != 0) {
    			time++;
    		}
    		worktime.add(time);
    	}

    	List<Integer> result = calcNextWork(worktime);

    	int[] answer = result.stream().mapToInt(i->i).toArray();
    	
        return answer;
    }
    
    public List<Integer> calcNextWork(Queue<Integer> worktime) {
		List<Integer> result = new ArrayList<Integer>();

		// prevWork: 비교할 때 기준이 되는 일수
		int prevWork = worktime.poll();
		int cnt = 1;

    	while (!worktime.isEmpty()) {
			int nextWork = worktime.peek();

			if (prevWork < nextWork) {
				result.add(cnt);
				cnt = 1;

				prevWork = worktime.poll();

			} else {
				worktime.poll();
				cnt++;
			}
		}
		result.add(cnt);
    	
		return result;
    }
}
