import java.util.*

private fun main() = with(System.`in`.bufferedReader())
{
    var inputString = readLine().toList()
    var lStack = Stack<Char>()
    var rStack = Stack<Char>()
    for (i in inputString)
    {
        lStack.add(i)
    }
    var M = readLine()!!.toInt()
    for (i in 0..M-1)
    {
        var command = readLine()
        if(command[0] == 'P'){
            lStack.add(command[2])
        }
        else if (command[0] == 'L'){
            if(lStack.size != 0) rStack.add(lStack.pop())
        }
        else if (command[0] == 'D'){
            if(rStack.size != 0) lStack.add(rStack.pop())
        }
        else{
            if (lStack.size != 0) lStack.pop()
        }
    }
    lStack.addAll(rStack.reversed())
    println(lStack.joinToString(""))
}
private fun main1() = with(System.`in`.bufferedReader())
{
    // 데이터 입력 받기
    var inputString = LinkedList(readLine().toCharArray().toList())
    var it = inputString.listIterator()
    while (it.hasNext()) it.next()
    var M = readLine()!!.toInt()
    for (i in 0..M - 1){
        var command = readLine()
        if(command[0] == 'P'){
            it.add(command[2])
        }
        else if(command[0] == 'L'){
            if(it.hasPrevious()) it.previous()
        }
        else if(command[0] == 'D'){
            if(it.hasNext()) it.next()
        }
        else{
            if(it.hasPrevious()) {
                it.previous()
                it.remove()
            }
        }
    }
    println(inputString.joinToString(""))
}