class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        // 장르 별로 노래를 수록
        // 장르 안에서 많이 재생된 노래 재생 (같으면 고유 번호가 낮은 순서로)
        // 최대 두곡만 재생된다.
        
        // 1. mutablemap을 이용하여 같은 장르 끼리 묶기 (인덱스도 포함해야함)
        var genre = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        var playing = mutableMapOf<String, Int>()
        genres.forEachIndexed { index, g ->
            val find = genre[g]
            if(find != null) genre[g]!!.add(Pair(index, plays[index]))
            else genre[g] = mutableListOf(Pair(index, plays[index]))
            
            val finds = playing[g]
            if(finds != null) playing[g] = playing[g]!! + plays[index]
            else playing[g] = plays[index]
        }
        
        // 정렬 하는데 정렬시 점수 합이 제일 큰것으로
        val sortedMap = playing.toSortedMap(compareByDescending { playing[it] })
        
        sortedMap.forEach { (key, _) ->
            // 장르 내에서 고유번호 순으로 또 정렬
            val song = genre[key]!!
            song.sortBy{it.first}
            song.sortByDescending{it.second}
            
            answer.add(song[0].first)
            if(song.size >= 2) answer.add(song[1].first)
        }
        
        return answer.toIntArray()
    }
}