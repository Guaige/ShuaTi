class Solution {
    List<List<String>> r;
    int n;
    public List<List<String>> solveNQueens(int n) {       
        r = new ArrayList<List<String>>();
        if (n==0)return r;
        this.n = n;
        Deque<Integer> q = new ArrayDeque<>();
        int col=0,main=0,sub=0;
        dfs(0,col,main,sub,q);
        return r;
    }
    void dfs(int row,int col,int main,int sub,Deque<Integer> q){
        if (row==n) {r.add(convert2board(q));return;}
        for (int j=0;j<n;j++)
            if (((col>>j)&1)==0 && ((main>>(row-j+n-1))&1)==0 &&((sub>>(row+j))&1)==0){
                q.addLast(j);
                col ^= 1<<j;main^=1<<(row-j+n-1);sub^=1<<(row+j);
                dfs(row+1,col,main,sub,q);
                col ^= 1<<j;main^=1<<(row-j+n-1);sub^=1<<(row+j);
                q.removeLast();
            }
        
    }
    private List<String> convert2board(Deque<Integer> path) {
    List<String> board = new ArrayList<>();
    for (Integer num : path) {
        StringBuilder row = new StringBuilder();
        row.append(".".repeat(Math.max(0, n)));
        row.replace(num, num + 1, "Q");
        board.add(row.toString());
    }
    return board;
}


}