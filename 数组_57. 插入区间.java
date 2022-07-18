/*
https://leetcode.cn/problems/insert-interval/solution/cha-ru-qu-jian-by-leetcode-solution/
57. 插入区间
合并区间升级，遍历到有重叠区间，维护原来的输入新区间的边界。
*/


lass Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> l = new ArrayList<>();
        boolean isAdded = false;
        for(int[] n : intervals){
            if(n[0]> right){
                if(!isAdded){
                    l.add(new int[]{left, right});
                    isAdded = true;
                }
                l.add(n);
            }
            else if (n[1]<left)
                l.add(n);
            else{
                left = Math.min(left, n[0]);
                right = Math.max(right, n[1]);
            }
        }
        if(!isAdded)
            l.add(new int[]{left, right});
        int[][] ans = new int[l.size()][2];
        for(int i=0;i<l.size();i++)
            ans[i] = l.get(i);
        return ans;
    }
}