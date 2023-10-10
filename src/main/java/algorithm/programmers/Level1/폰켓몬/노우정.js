function solution(nums) {

    const extractLimit = nums.length / 2;
    const unique = [];

    for (let i = 0 ; i < nums.length ; i++) {

        if (unique.indexOf(nums[i]) < 0 && unique.length < extractLimit) {
            unique.push(nums[i]);
        }
    }

    return unique.length;
}