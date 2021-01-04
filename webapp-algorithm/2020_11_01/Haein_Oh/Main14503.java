//https://www.acmicpc.net/problem/14503
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14503 {
	public static int N, M, count, arr[][];
	public static Queue<int[]> q;
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, 1, 0, -1}; // 북 동 남 서
	
	public static void solve() {
		loop:while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int sx = tmp[0];
			int sy = tmp[1];
			int sd = tmp[2];
			int nd = sd;
			int tmpCnt = 0;
			
			for(int i = 0; i < 4; i++) {
				nd = ((nd-1) == -1) ? 3 : (nd-1);
				int nx = sx + dx[nd];
				int ny = sy + dy[nd];
				
				if (nx <= 0 || ny <= 0 || nx >= N-1 || ny >= M-1 || arr[nx][ny] == 2 || arr[nx][ny] == 1) {
					tmpCnt++;
					continue;
				}
				if (arr[nx][ny] == 0) {
					q.add(new int[] {nx, ny, nd});
					arr[nx][ny] = 2;
					count++;
					break;
				} 
			}
			if (tmpCnt == 4) {
				int back = (sd < 2) ? (sd + 2) : (sd - 2);
				int nx = sx + dx[back];
				int ny = sy + dy[back];
				if(nx <= 0 || ny <= 0 || nx >= N-1 || ny >= M-1 || arr[nx][ny] == 1) break loop;
				else {
					q.add(new int[] {nx, ny, sd});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		count = 0;
		arr = new int[N][M];
		q = new LinkedList<int[]>();
		
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken()); // 시작 위치
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new int[] {x, y, d});
		arr[x][y] = 2;
		count++;

		solve();
		System.out.println(count);
	}
}
