package BJ_1967

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

lateinit var tree : ArrayList<ArrayList<Pair<Int,Int>>>
var ans = 0
fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var n = br.readLine().toInt()
    tree = ArrayList()
    repeat(n+1){ tree.add(ArrayList())}
    repeat(n-1)
    {
        val route = br.readLine().split(" ").map{it.toInt()}
        tree[route[0]].add(Pair(route[1],route[2]))
    }

    dfs(1)
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}
fun dfs(node : Int) : Int
{
    /* 자식이 없는 경우 */
    if(tree[node].isEmpty()) return 0

    /* 자식이 1명만 있는 경우 */
    if(tree[node].size == 1) {
        val tmp = tree[node][0].second + dfs(tree[node][0].first)
        ans = max(tmp,ans)
        return tmp
    }
    /* 자식이 1명 이상인 경우 */
    var pq = ArrayList<Int>()
    repeat(tree[node].size)
    {
        i ->
        pq.add(tree[node][i].second + dfs(tree[node][i].first))

    }
    pq.sortDescending()
    ans = max(pq[0] + pq[1], ans)
    return pq[0]
}