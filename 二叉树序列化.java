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
        if (root==null) return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        List<String> l = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node==null)
                    l.add("null");
                else{
                    l.add(String.valueOf(node.val));
                //l.add(String.valueOf(node.val));
                //
                    q.offer(node.left);
                //else    l.add("null");
                //if (node.right!=null)
                    q.offer(node.right);
                //else l.add("null");
                }
            }
        }
        String res = "[";
        for (int i=0;i<l.size()-1;i++)
            res += l.get(i) + ",";
        res += l.get(l.size()-1) + "]";
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
