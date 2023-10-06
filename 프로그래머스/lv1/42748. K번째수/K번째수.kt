class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): MutableList<Int> {
        var answer = mutableListOf<Int>()
        commands.forEach { command ->
            answer.add(array.slice((command[0]-1 until command[1])).sorted()[command[2] - 1])
        }
        return answer
    }
}