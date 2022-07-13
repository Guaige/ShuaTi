//https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/solution/qi-shu-zhi-dan-yuan-ge-de-shu-mu-by-leet-oa4o/
//1252. 奇数值单元格的数目

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        //逐行、列模拟+1
        for (int[] indice : indices){
            row[indice[0]]++;
            col[indice[1]]++;
        }
        //统计行、列奇数
        int oddx=0;
        for (int i:row)
            if ((i&1)!=0)
                oddx++;
        int oddy=0;
        for (int i:col)
            if ((i&1)!=0)
                oddy++;
        //数学
        return oddx*(n-oddy) + oddy*(m-oddx);
    }
}