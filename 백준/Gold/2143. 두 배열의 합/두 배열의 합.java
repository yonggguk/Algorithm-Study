import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] nPrefixSum = new int[n+1];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            nPrefixSum[i] = nPrefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mPrefixSum = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++){
            mPrefixSum[i] = mPrefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int nPartPrefixSumSize = n*(n+1)/2;
        int mPartPrefixSumSize = m*(m+1)/2;
        int[] nPartPrefixSum = new int[nPartPrefixSumSize];
        int[] mPartPrefixSum = new int[mPartPrefixSumSize];

        int partIndex = 0;
        for(int i = n; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                nPartPrefixSum[partIndex++] = nPrefixSum[i] - nPrefixSum[j];
            }
        }
        partIndex = 0;
        for(int i = m; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                mPartPrefixSum[partIndex++] = mPrefixSum[i] - mPrefixSum[j];
            }
        }
        Arrays.sort(nPartPrefixSum);
        Arrays.sort(mPartPrefixSum);
        int nLt = 0;
        int mRt = mPartPrefixSumSize-1;
        while(mRt >= 0 && nLt < nPartPrefixSumSize){
            int sum = nPartPrefixSum[nLt] + mPartPrefixSum[mRt];
            if(sum < t){
                nLt++;
            } else if(sum == t){
                long nCnt = 0;
                long mCnt = 0;
                int tmpN = nPartPrefixSum[nLt];
                int tmpM = mPartPrefixSum[mRt];
                while(nLt < nPartPrefixSumSize && nPartPrefixSum[nLt] == tmpN){
                    nLt++;
                    nCnt++;
                }
                while(mRt >= 0 && mPartPrefixSum[mRt] == tmpM){
                    mRt--;
                    mCnt++;
                }
                answer += nCnt * mCnt;
            } else if(sum > t){
                mRt--;
            }
        }
        System.out.println(answer);
    }
}
