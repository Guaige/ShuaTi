import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mSort {
    public static void sort(int[] n,int l,int r){
        if(l>=r)
            return;
        int i=l,j=r,m=(l+r)/2;
        sort(n,i,m);
        sort(n,m+1,j);
        merge(n,i,m,j);
    }
    public static void merge(int[] n, int l,int m,int r){
        List<Integer> nn = new ArrayList<>();
        int p1 = l,p2 = m+1,p=0;
        while(p1<=m && p2<=r) {
            if (n[p1] < n[p2])
                nn.add(n[p1++]);
            else nn.add(n[p2++]);
        }
        while(p1<=m)
            nn.add(n[p1++]);
        while(p2<=r)
            nn.add(n[p2++]);
        for(int i=0;i<nn.size();i++)
            n[l+i] = nn.get(i);
    }

    public static void main(String[] args) {
        int[] n = {4,7,2,9,1};
        sort(n,0,4);
        System.out.println(Arrays.toString(n));
    }
}
