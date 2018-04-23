package simple;

public class ReconstructItinerary_332 {
	private String resStr="";
	public void pathStr(String[][] tickets,String start){
		for(int i=0;i<tickets.length;i++){
			if(tickets[i][0]==start){
				String firstPath=tickets[i][1];
				resStr +=" " + firstPath;
				pathStr(tickets,firstPath);
			}
		}
	}
	
	public String getResStr() {
		return resStr;
	}

	public void setResStr(String resStr) {
		this.resStr = resStr;
	}

	public static void main(String[] args){
		long startTime=System.currentTimeMillis();
		String[][] tickets=new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		ReconstructItinerary_332 test=new ReconstructItinerary_332();
		test.setResStr("JFK");
		test.pathStr(tickets, "JFK");
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		System.out.println(test.getResStr());
	}
}
