package simple;
//求两个矩形重叠区域的面积：注意条件-总面积不会溢出
public class RectangleArea_223 {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (D-B)*(C-A);
		int area2 = (H-F)*(G-E);
		//会有溢出，所以答案有问题，比如负数-正数
		int len = (C>=G?G:C)-(A>=E?A:E);
		int width = (H>=D?D:H)-(F>=B?F:B);
		if(len<=0) len = 0;
		if(width<=0) width = 0;
		return area1+area2-len*width;
	}
	
	//讨论区-方法3
	public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int bottom = Math.max(B, F);
		int top = Math.min(H, D);
		int overlap = 0;
		if(right>=left&&top>=bottom){
			overlap = (right-left)*(top-bottom);
		}
		return (D-B)*(C-A)+(H-F)*(G-E)-overlap;
	}
	
	//讨论区-1：此种方法不需要考虑重叠区域
	public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        //之所以在最外面取最大值，是为了预防两个矩形不重叠，造成left大于right的情况，即矩形左边还比右边大
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);
        return (D-B)*(C-A)+(H-F)*(G-E)-(right-left)*(top-bottom);
    }
	
	//讨论区-方法2：避免方法1可能出现的left-right溢出
	int computeArea3(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		//Math.min(G, C) - Math.max(E, A)为什么没溢出？--因为先进行了比较
	    int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
	    int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
	    return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
	}
	
	//讨论区-方法4
	public int computeArea4(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rectOne = (C - A) * (D - B);
        int rectTwo = (G - E) * (H - F);        
        if(A >= G || B >= H || C <= E || D <= F){
            return rectOne + rectTwo;
        }
        
        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        
        return rectOne + rectTwo - length * height;
    }
}
