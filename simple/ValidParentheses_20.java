package simple;
import java.util.Stack;

public class ValidParentheses_20 {
	public boolean isValid(String s) {
        if(s==null||s.length()==0) return true;
        if(s.length()%2!=0) return false;
        String t = "";
        while(!s.equals(t)){
        	t = s;
        	s = s.replaceAll("(\\(\\))|(\\[\\])|(\\{\\})", "");
        }
        return s.isEmpty();        
    }
	
	//讨论区-方法2：使用stack
	//通过检测是否是成对出现-即最先出现的反括号应该与它前一个括号配对
	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('||c=='['||c=='{'){
				stack.push(c);
			}else{
				if(c==')'&&(stack.size()==0||stack.pop()!='(')) return false;
				if(c==']'&&(stack.size()==0||stack.pop()!='[')) return false;
				if(c=='}'&&(stack.size()==0||stack.pop()!='{')) return false;
				
				//由于配对的括号之间的ASCII码值相差不超过2，利用该技巧
				//if(stack.size()==0||c-stack.pop()>2) return false;
			}
		}
		if(stack.size()>0) return false;
		return true;
	}
	
	//讨论区-方法2：对上面方法的风格修改
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('||c=='['||c=='{'){
				stack.push(c);
			}else if(c==')'&&stack.size()>0&&stack.peek()=='('){
				stack.pop();
			}else if(c==']'&&stack.size()>0&&stack.peek()=='['){
				stack.pop();
			}else if(c=='}'&&stack.size()>0&&stack.peek()=='{'){
				stack.pop();
			}else return false;
		}
		return stack.size()>0?false:true;
		
		
		//改进2
//		for(int i=0;i<s.length();i++){
//			char c = s.charAt(i);
//			switch (c) {
//            case '(':                
//            case '{':               
//            case '[':
//                stack.push(c);
//                break;
//            case ')':
//                if (stack.size() == 0 || stack.pop() != '(')
//                    return false;
//                break;
//            case '}':
//                if (stack.size() == 0 || stack.pop() != '{')
//                    return false;
//                break;
//            case ']':
//                if (stack.size() == 0 || stack.pop() != '[')
//                    return false;
//                break;
//			}
//		}
//		return stack.isEmpty();
	}
	
	//讨论区-方法3：与上面方法的区别在于，不push([{，而是push(]}
	public boolean isValid3(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()){
			if(c=='(') stack.push(')');
			else if(c=='[') stack.push(']');
			else if(c=='{') stack.push('{');
			else if(stack.isEmpty()||stack.pop()!=c) return false;
		}
		return stack.isEmpty();
	}
	
	//讨论区-方法4：通过数组模拟stack
	public boolean isValid4(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
				case '{':
				case '[':
				case '(':
					stack[head++] = c;
					break;
				case '}':
					if(head == 0 || stack[--head] != '{') return false;
					break;
				case ')':
					if(head == 0 || stack[--head] != '(') return false;
					break;
				case ']':
					if(head == 0 || stack[--head] != '[') return false;
					break;
			}
		}
		return head == 0;
	}
	
	//讨论区-方法5：很巧的方法
	public boolean isValid5(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            //int q = "(){}[]".indexOf(s.charAt(i));  //也行效果更好
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q);
        }
        return p.isEmpty();
    }
	
	
	public static void main(String[] args){
		ValidParentheses_20 test = new ValidParentheses_20();
		System.out.println("()()()()(}}}".replace("()", ""));
	}
}
