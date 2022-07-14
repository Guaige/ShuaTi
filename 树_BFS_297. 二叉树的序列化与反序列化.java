/*
https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/
297. 二叉树的序列化与反序列化
BFS
队列用LinkedList可以添加null，ArrayDeque不行
String比较还是用equals
String.valueOf(47291)
Integer.parseInt("47291")



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "[]";
        List<String> l = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size--!=0){
                TreeNode t = q.poll();
                if(t==null)
                    l.add("null");
                else{
                    l.add(String.valueOf(t.val));
                    q.offer(t.left);
                    q.offer(t.right);
                }
            }
        }
        String r = "[";
        for(String s:l)
            r += s + ",";
        return r.substring(0,r.length()-1) + "]";
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]"))
            return null;
        String[] s = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        int i=1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(i<s.length){
            TreeNode t = q.poll();
            if(!s[i].equals("null")){
                t.left = new TreeNode(Integer.parseInt(s[i]));
                q.offer(t.left);
            }
            i++;
            if(!s[i].equals("null")){
                t.right = new TreeNode(Integer.parseInt(s[i]));
                q.offer(t.right);
            }
            i++;
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));