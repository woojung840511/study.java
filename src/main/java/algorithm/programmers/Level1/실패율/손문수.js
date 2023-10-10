function solution(N, stages) {
    var answer = [];
    let participant = stages.length
    let failrate = []
    stages.sort()
    for(let j=1; j<N; j++){
        let next = 0
        let fail = 0
        for(let i =0; i<stages.length; i++){
            if(stages[i]==j){
                fail += 1
            }if (stages[i]>=j){
                next += 1
            }
        }
        failrate[j-1] = fail/next
    }
    for(let k=0; k<failrate.length; k++){
        answer.push(failrate[k])
    }
    return answer;
}