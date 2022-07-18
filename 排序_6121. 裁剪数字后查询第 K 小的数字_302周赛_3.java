/*
https://leetcode.cn/problems/query-kth-smallest-trimmed-number/solution/pai-xu-by-endlesscheng-ylft/
6121. 裁剪数字后查询第 K 小的数字
302周赛#3， 比赛时思路就错了，在int和long上浪费时间。本题直接使用String排序，String.compareTo
lamda自定义Arrays.sort实现稳定排序，自定义排序数据结构：原string+index，直接输出index
*/

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = getIndex(nums,queries[i]);
        }
        return ans;
    }
    int getIndex(String[] ss,int[] q){
        String[][] t = new String[ss.length][2];
        for(int i=0;i<ss.length;i++){
            t[i][0] = ss[i].substring(ss[i].length()-q[1], ss[i].length());
            t[i][1] = i + "";
        }
        Arrays.sort(t,(a,b)->{
            if(a[0].equals(b[0]))
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            return a[0].compareTo(b[0]);
        });
        return Integer.parseInt(t[q[0]-1][1]);
    }
}