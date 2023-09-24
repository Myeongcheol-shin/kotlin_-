class Solution {
    lateinit var numbers :MutableList<MutableList<Int>>
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        numbers = mutableListOf()
        var answer = mutableListOf<Int>()
        var cnt = 1
        for(i in 0 until rows){
            val mt = mutableListOf<Int>()
            for(j in 1..columns){
                mt.add(cnt++)
            }
            numbers.add(mt)
        }
        println(numbers)
        queries.forEach{
            answer.add(rotate(it))
        }
        
        
        return answer.toIntArray()
    }
    
    fun rotate(query : IntArray) : Int { 
        // 변수 
        val startx = query[1] - 1
        val starty = query[0] - 1
        val endx = query[3] - 1
        val endy = query[2] - 1
        
        // 최소값 찾기
        var minNumber = Integer.MAX_VALUE
        
        for(i in (startx..endx)) {
            minNumber = Math.min(minNumber, numbers[endy][i])
            minNumber = Math.min(minNumber, numbers[starty][i])
        }
        for(i in (starty..endy)) {
            minNumber = Math.min(minNumber, numbers[i][endx])
            minNumber = Math.min(minNumber, numbers[i][startx])
        }
        
        // 1. 상단 부터
        // 시작전 오른쪽 끝값 저장하기
        var tmp = numbers[starty][endx]
        for(i in (endx downTo startx+1)){
            // 옆에꺼 옮기기
            numbers[starty][i] = numbers[starty][i-1]
        }   
        
        // 기존에꺼 미리 저장하기
        val tmp2 = numbers[endy][endx]
        
        // 2. 오른쪽 옮기기
        for(i in (endy downTo starty + 2)) {
            numbers[i][endx] = numbers[i-1][endx]
        }   
        // 마지막꺼 아래로 미리 옮겨두기
        numbers[starty+1][endx] = tmp
        
        // 기존꺼 미리 저장하기
        val tmp3 = numbers[endy][startx]
        
        // 3. 바닥 옮기기
        for(i in (startx until endx - 1)) {
            numbers[endy][i] = numbers[endy][i+1]
        }
        // 기존꺼 옮기기
        numbers[endy][endx-1] = tmp2
        
        // 4. 왼쪽 돌리기
        for(i in (starty until endy - 1)){
            numbers[i][startx] = numbers[i+1][startx]
        }   
        // 기존꺼 옮기기
        numbers[endy-1][startx] = tmp3
        
        return minNumber
        
    }
}