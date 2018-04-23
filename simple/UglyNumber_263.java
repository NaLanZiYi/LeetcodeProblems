package simple;

public class UglyNumber_263 {
	 public boolean isUgly(int num) {
	    if(num<=0) return false;
	    while(num!=1){
	    	if(num%2==0){
	    		num/=2;
	    	}else if(num%3==0){
	    		num/=3;
	    	}else if(num%5==0){
	    		num/=5;
	    	}else{
	    		return false;
	    	}
	    }
	    if(num==1) return true;
	    return false;
	 }
	 
	 //璁ㄨ鍖?-1锛氫笌涓婄被浼硷紝鍑忓皯鍒ゆ柇鐨勬鏁?
	 public boolean isUgly1(int num) {
		 if(num<=0) return false;
		 for(int i=2;i<6;i++){
			 while(num%i==0)
				 num/=i;
		 }
		 return num==1;
	 }
	 
	 //璁ㄨ鍖?-2锛?1鐨勬敼杩涳紝鍘绘帀4鏉ュ噺灏戝惊鐜鏁?
	 public boolean isUgly2(int num) {
		 if(num<=0) return false;
		 for(int i:new int[]{2,3,5}){
			 while(num%i==0)
				 num/=i;
		 }
		 return num==1;
	 }
	 
	 public boolean isUgly4(int num) {
		 if(num<=0) return false;
		 while(num%2==0) num/=2;
		 while(num%3==0) num/=3;
		 while(num%5==0) num/=5;
		 return num==1;
	 }
	 
	 //璁ㄨ鍖?-4锛氫娇鐢ㄥぇ鏁伴櫎娉?
	 public boolean isUgly3(int num) {
		//n = (2**30)*(3**20)*(5**13) = 4570198050078720000000000000L
		 //return num>0&&(4570198050078720000000000000L)%num==0;
		 return num>0&&Math.pow(30, 12)%num==0;
	 }
	 
}
