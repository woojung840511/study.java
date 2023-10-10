// function solution(n, lost, reserve) {
//     lost.sort();
// reserve.sort();
//     let lostCount = lost.length;
//     for (let l of lost) {
//         if (reserve.indexOf(l) >= 0) {
//             reserve.splice(reserve.indexOf(l), 1);
//             lostCount--;
//             continue;
//         }
//         const arr = [-1, 1];
//         for (let a of arr) {
//             if (reserve.indexOf(l + a) >= 0) {
//                 reserve.splice(reserve.indexOf(l + a), 1);
//                 lostCount--;
//                 break;
//             }
//         }
//         if (reserve.length === 0 ) break;
//     }
//     return n - lostCount;
// }
function solution(n, lost, reserve) {
    const lostTemp = [];
    for (let i of lost) {
        if (reserve.indexOf(i) >= 0) {
            reserve.splice(reserve.indexOf(i), 1);
            continue;
        }
        lostTemp.push(i);
    }
    for (let i of reserve) {
        const moveNumArr = [-1, 1];
        for (let num of moveNumArr) {
            let possibleFriend = i + num;
            let lostTempIndex = lostTemp.indexOf(possibleFriend);
            if (lostTempIndex >= 0) {
                lostTemp.splice(lostTempIndex, 1);
                break;
            }
        }
    }
    return n - lostTemp.length;
}
// console.log("solutionWrong " + solutionWrong(5, [1,2,3], [2,3,4]));
// console.log("solutionOK " + solutionOK(5, [1,2,3], [2,3,4]));