/*
피보나치
https://www.acmicpc.net/problem/10870
 */

import java.util.*

fun main(args: Array<String>){
    val sc = Scanner(System.`in`)
    var n:Int = sc.nextInt()
    var ans:Int

    ans = fibo(n)
    println(ans)
}

fun fibo(k:Int): Int {
    if(k==0) return 0
    else if(k==1) return 1
    else return fibo(k-2) + fibo(k-1)
}