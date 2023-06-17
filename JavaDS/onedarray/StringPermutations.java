package JavaDS.onedarray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// Find all permutations of a string. eg: abc => abc, bac, cba, acb, bca, cab
// Time: O(n * n!), Space: O(r – l) if we consider stack space for recursive calls

public class StringPermutations {
    static Set<String> set=new HashSet<>();
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("enter string");
            String str=br.readLine();
            System.out.println();
            permutations(str,0,str.length()-1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void permutations(String str,int l,int r){
        if(l==r){
            if(set.contains(str)) return;
            set.add(str);
            System.out.println(str+"");
            return;
        }
        for (int i=l;i<=r;i++){
            str=interchange(str,l,i);
            permutations(str,l+1,r);
            str=interchange(str,l,i);        // backtracking
        }
    }

    public static String interchange(String str,int a,int b){
        char chars[]=str.toCharArray();      // convert string to char array
        char temp=chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
        return String.valueOf(chars);        // convert char array back to string
    }
}
