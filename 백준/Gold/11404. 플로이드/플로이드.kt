import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    var arr = Array(n){ i ->IntArray(n){ j -> if (i == j) 0 else 100000001 }}

    repeat(m)
    {
        val tmp = br.readLine().split(" ").map { it.toInt() }
        arr[tmp[0]-1][tmp[1]-1] = min(arr[tmp[0]-1][tmp[1]-1], tmp[2])
    }
    for(k in arr.indices)
    {
        for(i in arr.indices)
        {
            for(j in arr.indices)
            {
                arr[i][j] = min(arr[i][k] + arr[k][j], arr[i][j])
            }
        }
    }
    for(i in arr){
        for(j in i)
        {
            if(j == 100000001) bw.write("${0} ")
            else bw.write("$j ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}