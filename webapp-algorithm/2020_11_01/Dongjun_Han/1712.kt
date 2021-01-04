/*
https://www.acmicpc.net/problem/1712
 */

import java.util.*


fun main(args:Array<String>){
    val sc = Scanner(System.`in`)
    var a:Int = sc.nextInt()
    var b:Int = sc.nextInt()
    var c:Int = sc.nextInt()

    if(b>=c)  println(-1)
    else println((a/(c-b)).toInt()+1)

}