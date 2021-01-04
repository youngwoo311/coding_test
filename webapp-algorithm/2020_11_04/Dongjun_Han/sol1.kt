import java.util.*
/*
https://programmers.co.kr/learn/courses/30/lessons/42583?language=kotlin
 */

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var sum = 0
        var queue: Queue<Int> = ArrayDeque<Int>();

        for(i in truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(i)
                    answer += 1
                    sum += i
                    break
                }
                else if(queue.size == bridge_length){
                    sum -= queue.poll()
                }
                else {
                    if(sum + i > weight){
                        answer += 1
                        queue.add(0)
                    }
                    else{
                        answer += 1
                        queue.add(i)
                        sum += i
                        break
                    }
                }
            }
        }
        answer += bridge_length

        return answer
    }
}

