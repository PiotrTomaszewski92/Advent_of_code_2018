import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Day2_bonus {

    public static void main(String[] args) {
        int i;

        String s1;


            List<String> abc = new ArrayList<>();


        abc.add("rvefqtyxzsddglnppumawhijsc");
        abc.add("rvefqtywzbodglnkkubawhijsc");
        abc.add("rvefqpyxzbozglnpkumawhiqsc");
        abc.add("rvefqtyxzbotgenpkuyawhijsc");
        abc.add("rvefqtyxzbodglnlkumtphijsc");
        abc.add("rwefqtykzbodglnpkumawhijss");
        abc.add("rvynqtyxzbodglnpkumawrijsc");
        abc.add("rvefqtyxlbodgcnpkumawhijec");
        abc.add("rvefqtyxzbodmlnpnumawhijsx");
        abc.add("rvefqtyxzbqdbdnpkumawhijsc");
        abc.add("rvefqtyxzlodblnpkuiawhijsc");
        abc.add("rvefqtyizrodelnpkumawhijsc");
        abc.add("rveffjyxzgodglnpkumawhijsc");
        abc.add("rvefqjyxzbodalnpkumadhijsc");
        abc.add("rvefqtidzbodglnpkumawhdjsc");
        abc.add("kvefqtygzbodglnpkumawhijfc");
        abc.add("rzefqtyxzbodglfhkumawhijsc");
        abc.add("rmefqtyxzbolglnpkumaehijsc");
        abc.add("rnefqqyxzbodglnhkumawhijsc");
        abc.add("rvwfqvyxzbodglnpcumawhijsc");
        abc.add("rvefqtyxzbokgltpkumavhijsc");

        s1 = abc.get(0);

        for(i = 1; i < abc.size() ;i++)
            if (s1.length() >= abc.get(i).length()){
                s1 = getLongestCommonSubsequence(s1,abc.get(i));
            }else{
                s1 = getLongestCommonSubsequence(abc.get(i),s1);
            }

    }

    public static String getLongestCommonSubsequence(String a, String b){

        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int xyz = 0;
        String sss = "";
        for (int i = 0; i < n ; i++){

                System.out.print(i+": "+dp[m][i]+"["+a.charAt(i)+"], ");
                if (dp[m][i+1] == xyz+1){
                    xyz++;
                    sss+= b.charAt(i);
                }
        }

        System.out.println("\n"+a);
        System.out.println(b);
        System.out.println(sss);

        System.out.println("\n"+dp[m][n]);
        return sss;
    }


}
