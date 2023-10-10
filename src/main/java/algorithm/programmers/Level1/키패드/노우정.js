function solution(numbers, hand) {
    let answer = '';
    const numsForLeft = [1, 4, 7];
    const numsForRight = [3, 6, 9];
    let lastRNum = 10;
    let lastLNum = 12;

    function calcD(pos1, pos2) { // 이동거리 계산 결과 산출
        const distance = Math.abs(pos2 - pos1);
        return parseInt(distance / 3) + (distance % 3);
    }

    function pressKey (num, hand) { // 양손이 각각 마지막으로 누른 넘버 저장
        if ( hand === 'right' ) {
            answer += 'R';
            lastRNum = num;
        } else {
            answer += 'L';
            lastLNum = num;
        }
    }
    
    numbers.forEach(num => {
        num = (num === 0 ? 11 : num);
        if (numsForRight.includes(num)) {
            pressKey(num, 'right');
        } else if (numsForLeft.includes(num)) {
            pressKey(num, 'left');
        } else if (calcD(lastLNum, num) > calcD(lastRNum, num)) {
            pressKey(num, 'right');
        } else if (calcD(lastLNum, num) < calcD(lastRNum, num)) {
            pressKey(num, 'left');
        } else if (calcD(lastLNum, num) === calcD(lastRNum, num)) {
            pressKey(num, hand);
        }
    })
    return answer;
}