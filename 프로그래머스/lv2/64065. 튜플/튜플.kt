class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        val visit = MutableList<Boolean>(100001) {false}

        var tup = parse(s)
        tup = tup.sortedBy { it.size }.toMutableList()
        tup.forEach {
            it.forEach {i ->
                if(!visit[i]) {
                    answer.add(i)
                    visit[i] = !visit[i]
                }
            }
        }

        return answer.toIntArray()
    }
    
    // 문자열 파싱
    fun parse(s : String) : MutableList<List<Int>>{
        var ns = s.substring(1,s.length-1)
        var sp = ns.split('{', '}')
        val tup = mutableListOf<List<Int>>()
        sp.filterNot { it == "" || it == "," }.forEach {
            tup.add( it.split(",").map { it.toInt() })
        }
        return tup
    }
}