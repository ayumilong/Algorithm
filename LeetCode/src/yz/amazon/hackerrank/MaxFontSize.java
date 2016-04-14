/**
 * File Name: MaxFontSize.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:04:10 AM Apr 6, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 6:04:10 AM Apr 6, 2016
 */
public class MaxFontSize {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int tasks = scan.nextInt();
        while (tasks > 0) {
            --tasks;
            long N = scan.nextLong();
            long P = scan.nextLong();
            long W = scan.nextLong();
            long H = scan.nextLong();
            long[] paras = new long[(int)N];
            for (int i = 0; i < N; ++i) {
                paras[i] = scan.nextInt();
            }
            long ans = size(N, P, W, H, paras);
            System.out.println((int)ans);
        }

        scan.close();
    }

    public static long size(long N, long P, long W, long H, long[] paras) {
        long charSum = 0;
        for (int i = 0; i < paras.length; i++) {
            charSum += paras[i];
        }
        long max = (long)Math.sqrt(W * H * P / charSum);
        while (max > 0) {
            long charPerLine = W / max;
            long linePerPage = H / max;
            if(charPerLine == 0 || linePerPage == 0){
            		--max;
            		continue;
            }
            long maxLine = linePerPage * P;
            long curLine = 0;
            boolean find = true;
            for (int i = 0; i < N; i++) {
                curLine += (long)Math.ceil(paras[i] / (double)charPerLine);
                if (curLine > maxLine) {
                    --max;
                    find = false;
                    break;
                }
            }
            if(find){
            		return max;
            }
        }
        return max;

    }
}
