var checkInclusion = function(s1, s2){
    var s1Len = s1.length;
    var s2Len = s2.length;

    if(s1Len > s2Len || s2 === null || s2.length === 0) return false;
    var s1Arr = new Array(26).fill(0);
    var s2Arr = new Array(26).fill(0);

    for(let i = 0; i < s1Len; i++){
        s1Arr[s1.charCodeAt(i) - 97]++;
        s2Arr[s2.charCodeAt(i) - 97]++;
    }
    for(let i = 0; i < s2Len - s1Len; i++){
        if(checkPermutation(s1Arr, s2Arr)) return true;
        s2Arr[s2.charCodeAt(i) - 97]--;
        s2Arr[s2.charCodeAt(i + s1Len) - 97]++;
    }
    if(checkPermutation(s1Arr, s2Arr)) return true;
    return false;
};

function checkPermutation(s1Arr, s2Arr){
    for(let i = 0; i < s1Arr.length; i++){
        if(s1Arr[i] !== s2Arr[i]) return false;
    }
    return true;
}