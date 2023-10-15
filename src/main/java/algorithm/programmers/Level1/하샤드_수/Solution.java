package algorithm.programmers.Level1.하샤드_수;

class Solution {
    public boolean solution(int x) {
        int total = 0;
        int dividend = x;

        while (dividend > 0) {
            total += dividend % 10;
            dividend /= 10;
        }

        return  x % total == 0;
    }
}
