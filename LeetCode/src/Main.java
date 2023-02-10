import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] as = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for(int i = 0; i < nums.length; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for(int i = 0; i < as[1]; i++){
            int[] queries = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int res = query(preSum, queries[0], queries[1]);
            writer.write(String.valueOf(res) + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int query(int[] preSum, int l, int r){
        return preSum[r] - preSum[l - 1];
    }
}
