package simple;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack_155 {
	
	private Stack<Integer> s;
	private Stack<Integer> min;
	
	public MinStack_155() {
        s = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        s.push(x);
        if(min.isEmpty()) min.push(x);
        else if(min.peek() >= x) min.push(x);
        
    }
    
    public void pop() {
    	if(s.isEmpty()) throw new EmptyStackException();
    	int m = s.pop();
    	if(m == min.peek()) {
    		min.pop();
    	}
    }
    
    public int top() {
        if(!s.isEmpty()) return s.peek();
        else throw new EmptyStackException();
    }
    
    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        else throw new EmptyStackException();
    }
    
    public static void main(String[] args) {
    	MinStack_155 test = new MinStack_155();
    	test.push(512);
    	test.push(-1024);
    	test.push(-1024);
    	test.push(512);
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
	}
}
