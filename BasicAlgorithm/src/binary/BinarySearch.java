package binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] as = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearch bs = new BinarySearch();
        for(int i = 0; i < as[1]; i++){
            int qv = Integer.parseInt(reader.readLine());
            int[] ans = bs.query(nums, qv);
            writer.write(String.valueOf(ans[0]) + " " + String.valueOf(ans[1]) + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    public int[] query(int[] nums, int qv){
        int[] ans = new int[2];
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] >= qv){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] != qv) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }else{
            ans[0] = left;
            left = 0;
            right = nums.length - 1;
            while(left < right){
                int mid = (right - left + 1) / 2 + left;
                if(nums[mid] <= qv){
                    left = mid;
                }else{
                    right = mid - 1;
                }
            }
            ans[1] = left;
        }
        return ans;
    }
}
