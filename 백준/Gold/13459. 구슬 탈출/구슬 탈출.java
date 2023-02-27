import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int rr;
        int rc;
        int br;
        int bc;
        int cnt;

        public State(int rr, int rc, int br, int bc, int cnt) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
        }
    }

    static boolean[][][][] visited;
    static char[][] map;
    static int n, m;
    static int or;
    static int oc;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<State> qu = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];
        int s_rr = 0;
        int s_rc = 0;
        int s_br = 0;
        int s_bc = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'R') {
                    s_rr = i;
                    s_rc = j;
                }
                if (s.charAt(j) == 'B') {
                    s_br = i;
                    s_bc = j;
                }
                if (s.charAt(j) == 'O') {
                    or = i;
                    oc = j;
                }
                map[i][j] = s.charAt(j);
            }
        }
        qu.add(new State(s_rr, s_rc, s_br, s_bc, 1));
        while (!qu.isEmpty()) {
            State state = qu.poll();
            visited[state.rr][state.rc][state.br][state.bc] = true;
            // 종료 조건
            if (state.cnt > 10) {
                System.out.println(0);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nRr = state.rr;
                int nRc = state.rc;
                int nBr = state.br;
                int nBc = state.bc;
                boolean rFlag = false;
                boolean bFlag = false;

                while(map[nBr+dy[i]][nBc+dx[i]] != '#'){
                    nBr += dy[i];
                    nBc += dx[i];
                    if(nBr == or && nBc == oc){
                        bFlag = true;
                        break;
                    }
                }
                while(map[nRr+dy[i]][nRc+dx[i]] != '#'){
                    nRr += dy[i];
                    nRc += dx[i];
                    if(nRr == or && nRc == oc){
                        rFlag = true;
                        break;
                    }
                }
                if(bFlag) continue;
                if(rFlag){
                    System.out.println(1);
                    return;
                }
                if(nRr == nBr && nRc == nBc){
                    if(i == 0){
                        if(state.rr > state.br) nRr -= dy[i];
                        else nBr -= dy[i];
                    } else if(i == 1){
                        if(state.rc < state.bc) nRc -= dx[i];
                        else nBc -= dx[i];
                    } else if(i == 2){
                        if(state.rr < state.br) nRr -= dy[i];
                        else nBr -= dy[i];
                    } else if(i == 3){
                        if(state.rc > state.bc) nRc -= dx[i];
                        else nBc -= dx[i];
                    }
                }
                if(!visited[nRr][nRc][nBr][nBc]){
                    visited[nRr][nRc][nBr][nBc] = true;
                    qu.add(new State(nRr, nRc, nBr, nBc, state.cnt+1));
                }
            }
            // 상태전이 상  || 조건 같은 라인일때, 누가 먼저 앞에있냐, 다른 라인일 때, 벽


            // 상태전이 하

            // 상태전이 좌

            // 상태전이 우
        }
        System.out.println(0);
    }
}