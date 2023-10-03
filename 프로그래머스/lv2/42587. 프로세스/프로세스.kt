class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        
        // 우선 순위와 인덱스가 저장된 배열 - 정렬 예정
        val mt = mutableListOf<Pair<Int,Int>>()
        // 검색용 맵
        val mm = mutableMapOf<Int,Int>()
        priorities.forEachIndexed{idx, v -> 
            mt.add(Pair(idx, v))
            mm[idx] = v
        }
        mt.sortByDescending{it.second}
        // 정렬된 배열을 큐에 삽입
        val pq = ArrayDeque<Pair<Int,Int>>()
        mt.forEach{pq.addFirst(it)}
        
        // 프로세스가 담긴 큐
        val process = ArrayDeque<Int>() 
        repeat(priorities.size){process.addFirst(it)}
        
        while(process.isNotEmpty()){
            val k = process.removeLast()
            if(mm[k]!! < pq.last().second) {
                process.addFirst(k)
            }
            else if(mm[k]!! <= pq.last().second){
                if(k == location) return answer+1
                pq.removeLast()
                answer++
            }
        }
        return answer
    }
}