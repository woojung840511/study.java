function solution(N, stages) {
    // N: 스테이지 개수
    // stages: 사용자가 현재 도전 중인 스테이지의 번호 arr

    const failRatioArr = [];
    let numberOfReached = 0;

    for (let stage = 1; stage <= N; stage++) {

        let numberOfPlaying = stages.filter(s => stage === s).length;

        failRatioArr.push(
            {
                stage: stage,
                failRatio: numberOfPlaying / (stages.length - numberOfReached)
            }
        );

        numberOfReached += numberOfPlaying;
    }

    failRatioArr.sort( (a , b) => { return b.failRatio - a.failRatio});
    return failRatioArr.map(f => f.stage);
}