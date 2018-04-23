package simple;
import java.util.Stack;


public class SameTree_100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p!=null&&q!=null){
            if(p.val!=q.val) return false;
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }else{
        	//只有一个为null的情况
           return false;
        }
        //return true;
    }
	
	//上述方法可优化为--来自讨论区
	public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null||q==null) return p==q;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        //return (p.val==q.val)&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
	
	//利用stack，比较stack尺寸和val
	public boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if(p!=null) stack_p.push(p);
        if(q!=null) stack_q.push(q);
        TreeNode p1,q1;
        while(stack_p.size()>0&&stack_q.size()>0){
        	p1=stack_p.pop();
        	q1=stack_q.pop();
        	if(p1.val!=q1.val) return false;
        	if(p.left!=null) stack_p.push(p.left);
        	if(q.left!=null) stack_q.push(q.left);
        	//说明有一颗树出现了空节点，可判定不相等
        	if(stack_p.size()!=stack_q.size()) return false;
        	if(p.right!=null) stack_p.push(p.right);
        	if(q.right!=null) stack_q.push(q.right);
        	if(stack_p.size()!=stack_q.size()) return false;
        }
        return stack_p.size()!=stack_q.size();
    }
}
