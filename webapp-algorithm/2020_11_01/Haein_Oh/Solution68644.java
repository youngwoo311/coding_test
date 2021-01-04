//https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public static int len;
    public static HashSet<Integer> arr;
	public static ArrayList<Integer> q;
	public static boolean vtd[];
	public static int answer[] = {};
    public static int[] number;
    	
	public static void solve(int idx, int cnt, int sum) {
		if(cnt == 2) {
			arr.add(sum);
			return;
		}
		
		for(int i = 0; i < len; i++) {
			if(!vtd[i]) {
				vtd[i] = true;
				solve(i, cnt+1, sum+number[i]);
				vtd[i] = false;
			}
		}
	}
	
    public int[] solution(int[] numbers) {
        number = numbers;
        len = numbers.length;
		q = new ArrayList<>();
		vtd = new boolean[len];
        arr = new HashSet<Integer>();
		solve(0, 0, 0);
		q = new ArrayList<Integer>(arr);
		answer = new int[arr.size()];
        
		for(int i = 0; i < arr.size(); i++) {
			answer[i] = q.get(i);
		}
		Arrays.sort(answer);   
        
        return answer;
    }
}