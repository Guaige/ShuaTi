class Solution {   
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    boolean[] isUsed;
    int[] n;
    Deque<Integer> q = new ArrayDeque<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums;
        isUsed = new boolean[nums.length];  
        //*****************      
        Arrays.sort(nums);   
        //***************     
        dfs(0);
        return ll;
    }
    void dfs(int cur){
        if (cur==n.length){
            ll.add(new ArrayList<>(q));
            return;
        }
        for (int i=0;i<n.length;i++){
            if (isUsed[i])
                continue;
            if (i>0 && n[i]==n[i-1] && !isUsed[i-1])
                continue;
            q.addLast(n[i]);
            isUsed[i]=true;
            dfs(cur+1);
            isUsed[i] = false;
            q.removeLast();
        }
    }
}