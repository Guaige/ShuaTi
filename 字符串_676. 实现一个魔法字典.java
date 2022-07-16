class MagicDictionary {

    String[] ss;
    public MagicDictionary() {

    }
    
    public void buildDict(String[] dictionary) {
        ss = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String s:ss){
            if (s.length()!=searchWord.length())
                continue;
            int dif = 0;
            for (int i=0;i<s.length();i++){
                if (s.charAt(i)!=searchWord.charAt(i)){
                    dif++;
                    if (dif>1)
                        break;
                }
            }
            if (dif==1)
                return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */