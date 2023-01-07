package BJ_1253

var N = 0
var ans = 0
lateinit var arr : List<Int>
fun main() {
    N = readln().toInt()
    arr = readLine()!!.split(" ").map { it.toInt() }
    arr = arr.sorted()
    for (i in 0 until N)
    {
        var left = 0
        var right = N-1
        while(left < right)
        {
            if(arr[left] + arr[right] == arr[i]){
                if(left != i && right != i){
                    ans++
                    break
                }
                else if(left == i) left++
                else if(right == i) right--
            }
            else if(arr[left] + arr[right] < arr[i]) left++
            else right--
        }
    }
    println(ans)
}