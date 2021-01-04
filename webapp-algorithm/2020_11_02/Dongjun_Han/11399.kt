import java.util.*

/*
https://www.acmicpc.net/problem/11399
*/

fun main(args:Array<String>){
    var tmp:Int
    var sum:Int = 0

    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var A = IntArray(n)

    for(i in 0 until n){
        A[i] = sc.nextInt()
    }

    for(i in n downTo (0)){
        for(j in 1 until i){
            if(A[j]<A[j-1]){
                tmp = A[j]
                A[j] = A[j-1]
                A[j-1] = tmp
            }
        }
    }
    for(i in 0 until n){
        sum += A[i]*(n-i)

    }
    println(sum)
}