package binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryFloat {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        double x = Double.parseDouble(reader.readLine());
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = -x;
        }
        //注意数据范围，当x=-0.001，ans=-0.1，用[0, 0.001]做边界无法求解。
        double left = -1000, right = 1000;
        while(Math.abs(right - left) > 10e-8){
            double mid = 1.0 * (right + left) / 2;
            if(mid * mid > x / mid){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(flag) left = -left;
        writer.write(String.format("%.6f", left));
        writer.flush();
        writer.close();
        reader.close();
    }
}
