function solution(numbers, hand) {
    let answer = '';
    const keypad = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
        ['*', 0, '#']];
    let lastRightPos = getPos('#');
    let lastLeftPos = getPos('*');

    function getPos(num) {
        let x = -1;
        let y = -1;
        let matched = false;
        for (let row of keypad) {
            y++;
            for (let key of row) {
                x++;
                if (key === num) {
                    matched = true;
                    break;
                }
            }
            if (matched) break;
            x = -1;
        }
        return {x, y};
    }

    function calcD(pos1, pos2) { // 이동거리 계산 결과 산출
        return Math.abs(pos2.x - pos1.x) + Math.abs(pos2.y - pos1.y);
    }

    function pressKey(num, hand) { // 양손이 각각 마지막으로 누른 넘버 저장
        if (hand === 'right') {
            answer += 'R';
            lastRightPos = getPos(num);
        } else {
            answer += 'L';
            lastLeftPos = getPos(num);
        }
    }

    numbers.forEach(num => {
        const numPos = getPos(num);
        if (numPos.x === 2) {
            pressKey(num, 'right');
        } else if (numPos.x === 0) {
            pressKey(num, 'left');
        } else if (calcD(lastLeftPos, numPos) > calcD(lastRightPos, numPos)) {
            pressKey(num, 'right');
        } else if (calcD(lastLeftPos, numPos) < calcD(lastRightPos, numPos)) {
            pressKey(num, 'left');
        } else if (calcD(lastLeftPos, numPos) === calcD(lastRightPos, numPos)) {
            pressKey(num, hand);
        }
    })
    return answer;
}