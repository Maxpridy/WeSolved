import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int T,N,K,input[];
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());

        StringTokenizer st;

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            input = new int[N];
            st = new StringTokenizer(bf.readLine());

            for(int j=0; i<N; j++)
                input[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(input);

            int sum = 0;

            for(int j=N-1; j>=N-K; j--){
                sum += input[j];
            }

            sb.append("Case #" +i).append("\n");

            sb.append(sum + "\n");
        }
        System.out.println(sb);

    }
}