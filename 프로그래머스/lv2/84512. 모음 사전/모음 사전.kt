class Solution {
    var alphabets = mutableListOf<String>("A","E","I","O","U")
    var words = mutableListOf<String>()
    fun solution(word: String): Int {
        var answer = 0
        recursive("")
        return words.indexOf(word) + 1
    }
    // 제귀
    fun recursive(str : String){
        if(str.length < 5) {
            alphabets.forEach{ alphabet ->
                val nw = str+alphabet
                words.add(nw)
                recursive(nw)
            }
        }
    }
}