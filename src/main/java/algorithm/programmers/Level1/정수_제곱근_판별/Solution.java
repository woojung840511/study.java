package algorithm.programmers.Level1.정수_제곱근_판별;

public class Solution {
    public long solution(long n) {

        long sqrt = (long) Math.sqrt(n); // 제곱근. 형변환하면서 소수점이 버려짐
        boolean hasMatchedInteger = Math.pow(sqrt, 2) == n;

        if (hasMatchedInteger) {
            return (long) Math.pow(++sqrt, 2);
        }

        return -1;
    }
}
