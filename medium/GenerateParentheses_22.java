package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses_22 {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder build = new StringBuilder();
        helper(list,build,n,0);
        return list;
    }
	
	//讨论区-方法1
	//pre:剩余(的数量，next:可用的)括号数量，每使用一个左括号，就有一个右括号可用
	private void helper(List<String> list, StringBuilder build, int pre, int next) {
		if(pre==0&&next==0){
			list.add(build.toString());
			return;
		}
		if(next>0) {
			build.append(")");
			helper(list,build,pre,next-1);
			build.deleteCharAt(build.length()-1);
			//build.setLength(build.length()-1);
		}
		if(pre>0) {
			build.append("(");
			helper(list,build,pre-1,next+1);
			build.deleteCharAt(build.length()-1);
		}
	}
	
	//讨论-方法2，思路同上
	public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder build = new StringBuilder();
        helper1(list,build,n,n);
        return list;
    }
	
	//讨论区-方法1
	//pre:剩余左括号的数量，next：剩余右括号的数量，应该保证next>=pre;
	private void helper1(List<String> list, StringBuilder build, int pre, int next) {
		if(pre==0&&next==0){
			list.add(build.toString());
			return;
		}
		//此时就应该先判断左括号
		if(pre>0) {
			build.append("(");
			helper1(list,build,pre-1,next);
			build.deleteCharAt(build.length()-1);
		}
		if(next>=pre) {
			build.append(")");
			helper1(list,build,pre,next-1);
			build.deleteCharAt(build.length()-1);
		}
	}
	
	//讨论区-方法2：迭代
//	Let's consider an example to get clear view:
//	f(0): ""
//	f(1): "("f(0)")"
//	f(2): "("f(0)")"f(1), "("f(1)")"
//	f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
//	So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
	public List<String> generateParenthesis2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            
            lists.add(list);
        }
        
        return lists.get(lists.size() - 1);
    }
	
	//讨论区-方法3
	public List<String> generateParenthesis3(int n) {
	    ArrayList<String> list = new ArrayList<String>();
	    Stack<String> stack = new Stack<String>();
	    Stack<Integer> validationStack = new Stack<Integer>();
	    stack.push("(");
	    validationStack.push(0);
	    while(stack.size() != 0)
	    {
	        String s = stack.pop();
	        int v = validationStack.pop();
	        if(s.length() == n * 2)
	        {
	            list.add(s);
	            continue;
	        }
	        if(s.length() - v < n)
	        {
	            stack.push(s + "(");
	            validationStack.push(v);
	        }
	        if(2 * v < s.length())
	        {
	            stack.push(s + ")");
	            validationStack.push(v+1);
	        }
	    }
	    return list;
	}
	
}
