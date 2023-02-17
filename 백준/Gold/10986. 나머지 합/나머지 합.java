import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer;
        int[] reminderArr = new int[m];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i = 0; i < n; i++){
            total += Integer.parseInt(st.nextToken()) % m;
            reminderArr[total%m]++;
        }
        answer = reminderArr[0];
        for(int i = 0; i < m; i++){
            int k = reminderArr[i];
            answer += (long)k * (k-1)/2;
        }
        System.out.println(answer);
    }

}