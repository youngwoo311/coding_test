import java.util.*

/*
https://www.acmicpc.net/problem/9663
 */

var used = IntArray(16){0}
var size:Int = 0
var ans:Int = 0

fun backtrack(k:Int){
    if(k==size){
        ans += 1
        return
    }
    var check = BooleanArray(16){false}

    for(i in 0 until k){
        var j:Int = used[i]
        check[j] = true
        var x:Int = j-i+k
        var y:Int = i+j-k
        if(x in 0 until size) check[x] = true
        if(y in 0 until size) check[y] = true
    }

    for(i in 0 until size) {
        if(check[i]) continue
        used[k] = i
        backtrack(k+1)
        used[k] = -1
    }

}

fun main(args:Array<String>){
    val sc = Scanner(System.`in`)
    size = sc.nextInt()
    backtrack(0)
    println(ans)
}