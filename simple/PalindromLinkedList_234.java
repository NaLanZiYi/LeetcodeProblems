package simple;
//判断单链表是否是回文链表
public class PalindromLinkedList_234 {
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	//讨论区-方法1：通过额外的函数将链表后半部分反转，然后依次比较前后两部分的值是否相等
	public boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null) return true;
	    ListNode fast = head, slow = head;
	    while(fast.next!=null&&fast.next.next!=null){
	    	slow = slow.next;
	    	fast = fast.next.next;
	    }
	    slow.next = reverseList(slow.next);
	    slow = slow.next;
	    while(slow!=null){
	    	if(head.val!=slow.val) return false;
	    	head = head.next;
	    	slow = slow.next;
	    }
	    return true;
	}
	
	public ListNode reverseList(ListNode node){
		ListNode pre = null, next = null;
		while(node!=null){
			next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		return pre;
	}
	
	//讨论区-方法2：将前一半的节点反转，一边遍历一边反转，可以减少遍历的次数
	public boolean isPalindrome1(ListNode head) {
		if(head==null||head.next==null) return true;
		ListNode slow = head , fast = head;
		ListNode pre = null, next = null;
		//fast每次走两步，slow每次走一步
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			//将前面的节点逆序
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}
		//如果有奇数个节点
		if(fast!=null) slow = slow.next;
		while(slow!=null){
			if(pre.val!=slow.val) return false;
			slow = slow.next;
			pre = pre.next;
		}
		return true;
	}
	
	//讨论区-方法3：延续上面的解法，但是在比较的时候，将前面逆序的部分再次逆序变成原来的样子
	public boolean isPalindrome2(ListNode head) {
		if(head==null||head.next==null) return true;
		ListNode fast = head;
		ListNode pre = null, next = null;
		//fast每次走两步，slow每次走一步
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			//将前面的节点逆序
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		//如果有奇数个节点
		ListNode tail = (fast==null)?head:head.next;
		boolean flag = true;  //返回标记
		//下面的步骤仍然是一边遍历一边反转节点
		while(pre!=null){
			flag = flag&&tail.val==pre.val;
			tail = tail.next;
			next = pre.next;
			pre.next = head;
			head = pre;
			pre = next;
		}
		return flag;
	}
	
	//讨论区-方法4：递归
	 public boolean isPalindrome3(ListNode head) {
		ListNode h = null;
        if (head == null) return true;	    
        if (h == null) h = head;
        boolean tmp = true;        
        if (head.next != null) tmp &= isPalindrome(head.next);	    
        tmp &= (head.val == h.val);
        h = h.next;
        return tmp;
	 }
}
