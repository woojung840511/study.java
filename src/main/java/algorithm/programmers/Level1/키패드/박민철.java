package algorithm.programmers.Level1.키패드;


import java.util.ArrayList;

public class 박민철 {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        ArrayList<String> usedHand = new ArrayList<String>();
        int locationLeft = 11;
        int locationRight = 12;
        int[] left = new int[2];
        int[] right = new int[2];
        int[] number = new int[2];

        int[][] keyPad = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {11, 0, 12}
        };

        for (int num = 0; num < numbers.length; num++) {

            if (numbers[num] == 1 || numbers[num] == 4 || numbers[num] == 7) {          //1,4,7일 경우
                locationLeft = numbers[num];
                usedHand.add("L");

            } else if (numbers[num] == 3 || numbers[num] == 6 || numbers[num] == 9) {   //3,6,9일 경우
                locationRight = numbers[num];
                usedHand.add("R");

            } else {                                                                          //2,5,8,0,일 경우
                for (int i = 0; i < keyPad.length; i++) {
                    for (int j = 0; j < keyPad[i].length; j++) {
                        if (keyPad[i][j] == locationLeft) {
                            left[0] = i;
                            left[1] = j;
//                            System.out.println("왼손 :: " + numbers[total] +"     위치 ::" + i +","+ j);
                        }

                        if (keyPad[i][j] == locationRight) {
                            right[0] = i;
                            right[1] = j;
//                            System.out.println("오른손 :: " + numbers[total] + "     위치 ::" + i + "," + j);
                        }

                        if (keyPad[i][j] == numbers[num]) {
                            number[0] = i;
                            number[1] = j;
//                            System.out.println("눌러야 할 숫자 :: " + numbers[total] +"     위치 ::" + i +","+ j);
                        }
                    }
                }

                int moveLeft = Math.abs(number[0] - left[0]) + Math.abs(number[1] - left[1]);
                int moveRight = Math.abs(number[0] - right[0]) + Math.abs(number[1] - right[1]);

                if (moveLeft < moveRight) {
                    locationLeft = numbers[num];
                    usedHand.add("L");
                } else if (moveLeft > moveRight) {
                    locationRight = numbers[num];
                    usedHand.add("R");

                } else if (moveLeft == moveRight){
                    if(hand.equals("left")){
                        locationLeft = numbers[num];
                        usedHand.add("L");
                    } else if(hand.equals("right")){
                        locationRight = numbers[num];
                        usedHand.add("R");
                    }
                }
            }
        }

        for (String num : usedHand) {
            answer += num;
        }

        return answer;
    }

    public static void main(String[] agrs) {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
//        solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
    }
}

