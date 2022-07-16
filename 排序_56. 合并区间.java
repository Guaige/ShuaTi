/*
https://leetcode.cn/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
56. 合并区间
按左值排序，遍历。如果当前左值大于现有区间列表最右值，合并。否则更新最右值。
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        List<int[]> merge = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(merge.isEmpty() || merge.get(merge.size()-1)[1] < intervals[i][0])
                merge.add(new int[]{intervals[i][0],intervals[i][1]});
            else merge.get(merge.size()-1)[1] = Math.max(merge.get(merge.size()-1)[1],intervals[i][1]);
        }
        return merge.toArray(new int[merge.size()][]);
    }
}