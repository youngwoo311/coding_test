/*
https://www.acmicpc.net/problem/11047
 */

import java.util.*

var max : Int = 10
var a : LongArray = LongArray(10)

fun main(args : Array<String>){
    val sc = Scanner(System.`in`)
    var n:Int = sc.nextInt()
    var k:Long = sc.nextLong()
    var sum:Int = 0;


    for(i in 0 until n){

        a[n-i-1] = sc.nextLong();
    }
    for(i in 0 until n-1){
        while(k>=a[i]){
            sum+=1;
            k-=a[i]

        }
    }
    println(sum)
}