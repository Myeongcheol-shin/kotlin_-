class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val clothes_map = mutableMapOf<String, Int>() 
        var answer = 1
        clothes.forEach{ cloth ->
            val find = clothes_map[cloth[1]]
            if(find != null) clothes_map[cloth[1]] = find + 1
            else clothes_map[cloth[1]] = 1
        }
        clothes_map.forEach {(key, value) ->
            answer *= (value + 1)
        }
        
        return --answer
    }
 
}