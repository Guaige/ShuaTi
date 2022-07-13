//https://leetcode.cn/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
//76. 最小覆盖子串
//滑动窗口模板，两个Map辅助，map中value相同的个数（count）用于判断缩。扩、缩时更新map和count，缩更新Min-len。



//模板
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) 
        need.put(c,need.getOrDefault(c,0)+1);
    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s.charAt(right);
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        System.out.println("window: ["+left+","+ right+")");
        /********************/
    
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}


class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<Character,Integer>();
        Map<Character,Integer> window = new HashMap<>();
        int start=0,len=Integer.MAX_VALUE,i=0,j=0,equal=0;
        //生成need
        for(char c:t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
        while(j<s.length()){
            //扩
            char c = s.charAt(j);
            j++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))
                    equal++;
            }
            //缩
            while(equal==need.size()){
                if(j-i<len){
                    len = j-i;
                    start = i;
                }
                char d = s.charAt(i);
                i++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d)))
                        equal--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}