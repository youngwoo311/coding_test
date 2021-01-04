//https://www.acmicpc.net/problem/4963
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4963 {
	public static int w, h, arr[][], answer;
	public static boolean vtd[][];
	public static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void init() {
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				arr[i][j] = 0;
				vtd[i][j] = false;
			}
		}
	}
	
	public static void solve(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
			if(!vtd[nx][ny] && arr[nx][ny] == 1) {
				vtd[nx][ny] = true;
				solve(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[51][51];
		vtd = new boolean[51][51];
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());	
			if(w == 0 && h == 0) break;
			answer = 0;
			init();
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());;
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1 && !vtd[i][j]) { 
						vtd[i][j] = true;
						solve(i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}
