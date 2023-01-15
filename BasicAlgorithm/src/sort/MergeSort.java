package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new MergeSort().mergeSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                writer.write(" ");
            }
            writer.write(String.valueOf(nums[i]));
        }
        writer.write("\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    public void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int k = 0, l = left, r = mid + 1;
        while(l <= mid && r <= right){
            if(nums[l] < nums[r]) temp[k++] = nums[l++];
            else temp[k++] = nums[r++];
        }
        while(l <= mid) temp[k++] = nums[l++];
        while(r <= right) temp[k++] = nums[r++];
        for(int i = left, j = 0; i <= right && j < temp.length; i++, j++){
            nums[i] = temp[j];
        }
    }
}
