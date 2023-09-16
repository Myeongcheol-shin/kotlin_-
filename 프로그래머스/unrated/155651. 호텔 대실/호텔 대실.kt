class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        val book_list = MutableList<Int>(2000){0}
        
        book_time.forEach { bt ->
            val start_bt_list = bt[0].split(":").map{it.toInt()}
            val end_bt_list = bt[1].split(":").map{it.toInt()}
            
            // 시간 분 단위로 변환 
            val start_bt = start_bt_list[0] * 60 + start_bt_list[1] 
            val end_bt = end_bt_list[0] * 60 + end_bt_list[1] + 10
            
            for(i in start_bt until end_bt) {
                book_list[i] += 1
            }
        }
        book_list.forEach{
            answer = Math.max(answer,it)
        }
        return answer
    }
}