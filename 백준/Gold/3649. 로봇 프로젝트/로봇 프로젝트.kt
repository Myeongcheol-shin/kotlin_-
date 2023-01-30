import java.util.Scanner

var x = 0
fun main()
{
    var br = Scanner(System.`in`)
    while(br.hasNext())
    {
        val x = br.nextInt() * 10000000
        val size = br.nextInt()
        var arr = arrayListOf<Int>()
        repeat(size)
        {
            arr.add(br.nextInt())
        }
        arr.sort()
        var i = 0
        var j = size-1

        var find = false
        while(i < j)
        {
            val tmp = arr[i] + arr[j]
            if(tmp == x) {
                find = true
                println("yes ${arr[i]} ${arr[j]}")
                break
            }
            else if(tmp < x) i++
            else j--
        }
        if(!find) println("danger")
    }
}
