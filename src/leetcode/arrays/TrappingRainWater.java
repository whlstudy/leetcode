package leetcode.arrays;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/11/28 3:23 下午
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // 借助栈实现，栈的操作太耗时
    public static int trap(int[] height) {
       Stack<Integer> st = new Stack<>();
       int i = 0, n = height.length, res = 0;
       while(i < n){
           if(st.isEmpty() || height[i] <= height[st.peek()]){
               st.push(i++);
           }else{
               int t = st.pop();
               if(st.isEmpty()) continue;
               res += (Math.min(height[i],height[st.peek()]) - height[t]) * (i - st.peek() - 1);
           }
       }
       return res;
    }

    // 同样思想不使用栈实现
    public int trap1(int[] height) {
        int vol = 0;
        if(height != null && height.length > 0){
            int length = height.length;

            int i=0;
            while(i+1<length){
                int e = i+1;

                if(height[i] != 0){
                    int indexMax = e;

                    while(e < length){
                        if(height[e] > height[i]){
                            indexMax = e;
                            break;
                        }
                        else{
                            if(height[e] > height[indexMax]){
                                indexMax = e;
                            }
                            e++;
                        }
                    }
                    vol += calcVol(i, indexMax, height);
                    i = indexMax;
                }
                else{
                    i++;
                }
            }
        }
        return vol;
    }

    public int calcVol(int s, int e, int[] height){
        int vol = (e-s-1) * Math.min(height[e], height[s]);
        for(int j=s+1; j<e; j++){
            vol -= height[j];
        }
        return vol;
    }
}
