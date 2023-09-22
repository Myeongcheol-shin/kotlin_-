class Solution {
    fun solution(infos: Array<String>, querys: Array<String>): IntArray {
    var answer= mutableListOf<Int>()
    val mm = HashMap<String, MutableList<Int>>()
    for(i1 in arrayOf("cpp", "java","python","-")){
        for(i2 in arrayOf("backend", "frontend", "-")){
            for(i3 in arrayOf("junior", "senior", "-")){
                for(i4 in arrayOf("chicken", "pizza", "-")){
                    mm[i1+i2+i3+i4] = mutableListOf()
                }
            }
        }
    }
    infos.forEach {info ->
        val i = info.split(" ")
        val d = i[4].toInt()
        // "-" -> 0
        mm[i[0] + i[1] + i[2] + i[3]]!!.add(d)
        // "-" -> 1
        mm["-" + i[1] + i[2] + i[3]]!!.add(d)
        mm[i[0] + "-" + i[2] + i[3]]!!.add(d)
        mm[i[0] + i[1] + "-" + i[3]]!!.add(d)
        mm[i[0] + i[1] + i[2] + "-"]!!.add(d)
        // "-" -> 2
        mm["-" + "-" + i[2] + i[3]]!!.add(d)
        mm["-" + i[1] + "-" + i[3]]!!.add(d)
        mm["-" + i[1] + i[2] + "-"]!!.add(d)
        mm[i[0] + "-" + "-" + i[3]]!!.add(d)
        mm[i[0] + "-" + i[2] + "-"]!!.add(d)
        mm[i[0] + i[1] + "-" + "-"]!!.add(d)
        // "-" -> 3
        mm["-" + "-" + "-" + i[3]]!!.add(d)
        mm["-"  + "-"  + i[2] + "-"]!!.add(d)
        mm[i[0] + "-"  + "-"  + "-"]!!.add(d)
        mm["-"  + i[1] + "-"  + "-"]!!.add(d)
        // "-" -> 4
        mm["-" + "-" + "-" + "-"]!!.add(d)
    }
    for(m in mm){
        mm[m.key] = m.value.sorted().toMutableList()
    }
    querys.forEach { query->
        var cnt = 0
        val r = query.replace(" and", "")
        val q = r.split(" ")
        val t = mm[q[0] + q[1] + q[2] + q[3]]!!
        val bs = binarySearch(t, q[4].toInt())
        if(bs == null) answer.add(0)
        else answer.add(t.size - bs)
    }

    return answer.toIntArray()
}
fun binarySearch(sortedList: MutableList<Int>, target: Int): Int? {
    var left = 0
    var right = sortedList.size - 1
    var resultIndex: Int? = null

    while (left <= right) {
        val mid = (left + right) / 2
        val midValue = sortedList[mid]

        if (midValue >= target) {
            resultIndex = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return resultIndex
}
}
   