import java.util.*
class Solution {
    var answer_sum = Integer.MIN_VALUE
    var answer_arr = MutableList<Int>(11){100}
    fun solution(n: Int, info: IntArray): IntArray {
        find(0,10,n,mutableListOf(),info, 0,0)
        if(answer_sum == Integer.MIN_VALUE) {
            return intArrayOf(-1)
        }
        else {
            return answer_arr.toIntArray()
        }
    }
    fun find(start : Int, end : Int, remain : Int, arr : MutableList<Int>, info : IntArray, apeach : Int, lion : Int){
        // 끝
        if(start == end) {
            val tmp_arr = arr.toList().toMutableList()
            // 마지막 남은 화살 모두 더하기
            tmp_arr.add(remain)
            // 어차피 0점이므로 비교할 필요가 없음
            // 라이언이 우승하는 경우
            if(lion > apeach) {
                // 큰 점수 차이
                val diff = lion - apeach
                // 기존의 값보다 더 크게 이겼다면,
                if(diff > answer_sum) {
                    answer_sum = diff
                    answer_arr = tmp_arr.toList().toMutableList()
                }
                // 점수가 동일하면
                else if(diff == answer_sum) {
                    for(i in 0..10){
                        if(tmp_arr[10 - i] > answer_arr[10 - i]){
                            answer_arr = tmp_arr.toList().toMutableList()
                            break
                        }
                        else if(tmp_arr[10-i] < answer_arr[10-i]) break
                    }
                }
            }
        }
        else {
            for(i in remain downTo 0 ) {
                var tmp_apeach = apeach
                var tmp_lion = lion
                // 점수가 같은 경우
                if(info[start] == i) {
                    if(i != 0) {
                        tmp_apeach += (10 - start)
                    }
                }
                else if(info[start] > i) {
                    tmp_apeach += (10 - start)
                }
                else {
                    tmp_lion += (10 - start)
                }
                var new_arr = arr.toList().toMutableList()
                new_arr.add(i)
                find(start + 1, end, remain - i, new_arr, info, tmp_apeach, tmp_lion)
            }
        }
    }
}