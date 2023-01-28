import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.min

fun main()
{
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var arr = arrayListOf<String>()

    repeat(br.readLine().toInt())
    {
        it ->
        arr.add(br.readLine())
    }

    var copyArr = arrayListOf<String>()
    copyArr.addAll(arr)
    copyArr.sort()


    var tmp = -1
    var wordSet = mutableSetOf<String>()
    for(i in 1 until copyArr.size)
    {
        var cnt = 0
        for(j in 0 until min(copyArr[i-1].length, copyArr[i].length))
        {
            if(copyArr[i-1][j] != copyArr[i][j]) break
            cnt++
        }
        if(tmp == cnt) wordSet.add(copyArr[i-1].substring(0,cnt))
        if(tmp < cnt)
        {
            tmp = cnt
            wordSet = mutableSetOf<String>()
            wordSet.add(copyArr[i-1].substring(0,cnt))
        }
    }

    var word = ""

    for(i in arr)
    {
        if(word == "")
        {
            for(j in wordSet) {
                if(i.length >= j.length && i.substring(0,j.length) == j) {
                    word = j
                    bw.write(i + "\n")
                    break
                }
            }
        }
        else
        {
            if(i.length >= word.length && i.substring(0,word.length) == word){
                bw.write(i)
                bw.flush()
                bw.close()
                return
            }
        }
    }
}