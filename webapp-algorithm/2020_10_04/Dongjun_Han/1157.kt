/* 단어공부
https://www.acmicpc.net/problem/1157
 */

fun main(args: Array<String>){
    var n:String = readLine()!!.toString()
    var str:IntArray = IntArray(26)
    var maxInt:Int = 0
    var maxIndex:Int = 0
    var maxCount:Int = 0

    for (i in n.indices){
        if(n[i].toInt()<91) {
            str[n[i].toInt()-65]++
            if(str[n[i].toInt()-65] > maxInt) {
                maxInt = str[n[i].toInt()-65]
            }
        }
        else {
            str[n[i].toInt()-97]++
            if(str[n[i].toInt()-97] > maxInt) {
                maxInt = str[n[i].toInt()-97]
            }
        }
    }
    for(i in str.indices){
        if(str[i] == maxInt){
            maxIndex = i
            maxCount += 1
        }
    }


    if(maxCount == 1) println((maxIndex+65).toChar())
    else println("?")

}