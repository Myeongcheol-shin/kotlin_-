import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    var T = br.readLine().toInt()
    var N = br.readLine().toInt()
    var A = br.readLine().split(" ").map{ it.toInt() } as MutableList<Int>
    var M = br.readLine().toInt()
    var B = br.readLine().split(" ").map{ it.toInt() } as MutableList<Int>

    var sum_a = mutableListOf<Int>()
    var sum_b = mutableListOf<Int>()

    for(i in A.indices){
        var sum = A[i]
        sum_a.add(sum)
        for(j in i+1 until A.size) {
            sum += A[j]
            sum_a.add(sum)
        }
    }
    for(i in B.indices){
        var sum = B[i]
        sum_b.add(sum)
        for(j in i+1 until B.size) {
            sum += B[j]
            sum_b.add(sum)
        }
    }

    sum_a.sort()
    sum_b.sort()
    var ans = 0L
    for(i in sum_a.indices){
        val tmp = T - sum_a[i]
        val ub = upperBound(sum_b, tmp)
        val lb = lowerBound(sum_b, tmp)
        ans += (ub - lb)
    }

    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun lowerBound(arr : MutableList<Int>, target : Int) : Int {
    var left = 0
    var right = arr.size
    while (left < right)
    {
        val mid = (left + right) / 2
        if(arr[mid] < target) left = mid + 1
        else right = mid
    }
    return right
}

fun upperBound(arr : MutableList<Int>, target: Int) : Int {
    var left = 0
    var rihgt = arr.size
    while (left < rihgt)
    {
        val mid = (left + rihgt) / 2
        if(arr[mid] <= target) left = mid + 1
        else rihgt = mid
    }
    return rihgt
}