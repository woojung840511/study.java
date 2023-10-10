package algorithm.programmers.Level1.키패드;

class Point {
    private int x;
    private int y;

    public Point() {}
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

}

class Solution {
    private String[][] keypad = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"*", "0", "#"}
    };

    private String answer;
    private Point curL;
    private Point curR;

    //keypad 배열 안에서 num의 좌표를 리턴
    private Point getPointFromKeypad(String num) {
        Point point = null;

        for(int i=0; i<keypad.length; i++) {
            for(int j=0; j<keypad[i].length; j++) {
                if(keypad[i][j].equals(num)) {
                    point = new Point(i, j);
                }
            }
        }

        return point;
    }

    //해당 좌표로 왼손을 이동시킴
    private void setCurL(Point point) {
        answer += "L";
        curL = point;
    }

    //해당 좌표로 오른손을 이동시킴
    private void setCurR(Point point) {
        answer += "R";
        curR = point;
    }

    public String solution(int[] numbers, String hand) {
        answer = "";
        curL = getPointFromKeypad("*");
        curR = getPointFromKeypad("#");

        for(int number : numbers) {
            Point point = getPointFromKeypad(String.valueOf(number));

            if(number == 1 || number == 4 || number == 7) {
                setCurL(point);
            } else if(number == 3 || number == 6 || number == 9) {
                setCurR(point);
            } else {
                int distanceL = Math.abs(point.getX() - curL.getX()) + Math.abs(point.getY() - curL.getY());
                int distanceR = Math.abs(point.getX() - curR.getX()) + Math.abs(point.getY() - curR.getY());

                if(distanceL == distanceR) {
                    //왼손, 오른손 거리가 같은 경우 = 자신이 주로 사용하는 손으로 누르기
                    if (("left".equals(hand))) {
                        setCurL(point);
                    } else {
                        setCurR(point);
                    }
                } else if(distanceL < distanceR) {
                    //왼손이 더 가까운 경우
                    setCurL(point);
                } else {
                    //오른손이 더 가까운 경우
                    setCurR(point);
                }
            }
        }

        return answer;
    }
}

public class 조하연 {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(s.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}