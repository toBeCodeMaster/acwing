package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //这里选择用Y总的快排遍历模板
        new QuickSort().quickSort(nums, 0, n - 1);
        for(int i = 0; i < nums.length; i++){
            if(i > 0) writer.write(" ");
            writer.write(String.valueOf(nums[i]));
        }
        writer.write("\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    public void swap(int[] nums, int l, int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    /**
     *  quickSort是 Y总的快排模板，对于大量相同的数据
     *  quickSort每一次递归，切分点会遍历到中点，使得下一次递归数据量减半
     *  quickSort2每一次递归，切分点只会遍历到 left+1，使得下一次递归数据量-1，退化到O(n2)
     */
    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int partIndex = new Random().nextInt(right - left + 1) + left;
        int pv = nums[partIndex];
        swap(nums, left, partIndex);
        int l = left - 1;
        int r = right + 1;
        while(l < r){
            do l++; while(nums[l] < pv);
            do r--; while(nums[r] > pv);
            if(l < r) swap(nums, l, r);
        }
        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);
    }

    public void quickSort2(int[] nums, int left, int right){
        if(left >= right) return;
        int partIndex = new Random().nextInt(right - left + 1) + left;
        int pv = nums[partIndex];
        swap(nums, left, partIndex);
        int l = left;
        int r = right;
        while(l < r){
            while(l < r && nums[r] >= pv) r--;
            nums[l] = nums[r];
            while(l < r && nums[l] <= pv) l++;
            nums[r] = nums[l];
        }
        nums[l] = pv;
        quickSort2(nums, left, l - 1);
        quickSort2(nums, l + 1, right);
    }
}
