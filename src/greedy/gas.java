package greedy;
//加油站加油题一星难度
public class gas {
//	public int canCompleteCircuit(int[] gas,int[] cost){
//		for(int i=0;i<gas.length;i++){
//			int j=i;
//			int curgas=gas[j];
//			while(curgas>=cost[i]){
//				curgas-=cost[j];
//				j=(j+1)%gas.length;
//				if(j==i) return i;
//				curgas+=gas[j];
//			}
//		}
//		return -1;	
//	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {  
        int sum = 0;  
        int total = 0;  
        int j = -1;  
        for (int i = 0; i < gas.length; i++) {  
            sum += gas[i] - cost[i];  
            total += gas[i] - cost[i];  
            if(sum < 0) {   //之前的油量不够到达当前加油站  
                j = i;  
                sum = 0;  
            }  
        }  
        if (total < 0) return -1;    //所有加油站的油量都不够整个路程的消耗  
        else return j + 1;  
    }  
	

}
