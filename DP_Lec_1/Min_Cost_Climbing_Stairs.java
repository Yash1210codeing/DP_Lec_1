package DP_Lec_1;
import java.util.*;
public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[]arr= {1,100,1,1,1,100,1,1,100,1};
        int[]dp=new int[arr.length];
        Arrays.fill(dp,-1);
        int zero=Min_Cost(arr,0,dp);
        int one=Min_Cost(arr,1,dp);
       // System.out.println(Min_Cost(arr,0,dp));
        System.out.println(Math.min(one , zero));
        System.out.println(Min_CostBU(arr));
	}
	public static int Min_Cost(int []arr,int i,int[]dp) {
		if(i>=arr.length) {
			return 0;
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		int first=Min_Cost(arr,i+1,dp);  // dp[i+1		
		int sec=Min_Cost(arr,i+2,dp);     // dp[i+2]
		return Math.min(first , sec)+arr[i];
	}
	public static int Min_CostBU(int[]arr) {
		int[]dp=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=arr[1];
		for(int i=2;i<dp.length;i++) {
			int first=dp[i-2];
			int sec=dp[i-2];
			dp[i]=Math.min(first, sec)+arr[i];			
		}
		return Math.min(dp[dp.length-1], dp[dp.length-2]);
	}
}