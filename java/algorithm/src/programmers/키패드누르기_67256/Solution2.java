package programmers.키패드누르기_67256;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String answer = sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        System.out.println(answer);
    }

    public String solution(int[] numbers, String hand) {
        int prevL = 10; 
        int prevR = 12;

        String answer = "";

        for (int number : numbers) {
            Keypad keypad = new Keypad();

            for (int j = 0; j < keypad.getKeypad().size(); j++) {
                if (number == 0) number = 11;

                int anyNumber = number;
                boolean isContains = Arrays.stream(keypad.getKeypad().get(j))
                                          .anyMatch(o -> o == anyNumber);

                if (isContains) {
                    switch (j) {
                        case 0:
                            prevL = number;
                            answer += "L";
                            break;
                        case 1:
                            int leftInstance = getInstance(number, prevL);
                            int rigtInstance = getInstance(number, prevR);
                            
                            if (leftInstance == rigtInstance) {
                                if ("left".equals(hand)) {
                                    prevL = number;
                                    answer += "L";
                                } else {
                                    prevR = number;
                                    answer += "R";
                                }
                                
                            } else if (leftInstance < rigtInstance) {
                                prevL = number;
                                answer += "L";
                            } else {
                                prevR = number;
                                answer += "R";
                            }
                            break;
                        case 2:
                            prevR = number;
                            answer += "R";
                            break;
                    }
                    break;
                }
            }
        }

        return answer;
    }

	public int getInstance(int number, int prev) {
		int row = Math.abs(number - prev) / 3;
		int col = Math.abs(number - prev) % 3;

		return row + col;
	}

    class Keypad {
        List<int[]> keypad;

        public Keypad() {
            keypad = new ArrayList<>();
            keypad.add(new int[]{1, 4, 7, 10});
            keypad.add(new int[]{2, 5, 8, 11});
            keypad.add(new int[]{3, 6, 9, 12});
        }

        public void setKeypad(List<int[]> keypad) {
            this.keypad = keypad;
        }

        public List<int[]> getKeypad() {
            return keypad;
        }
    }
}
