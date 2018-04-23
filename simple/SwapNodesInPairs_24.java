package simple;
//浜ゆ崲鎺掑簭鍒楄〃涓瘡涓や釜涓?缁勭殑鑺傜偣
public class SwapNodesInPairs_24 {
	
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){this.val=x;}
	}
	
	//recursion method
	public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newhead = head.next;
        ListNode nextPairs = newhead.next;
        newhead.next = head;
        head.next=swapPairs(nextPairs);
        return newhead;
    }
	
	//iterative method锛氬鍔犱竴涓ご缁撶偣
	public ListNode swapPairs1(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode first,second;
		while(cur.next!=null&&cur.next.next!=null){
			first = cur.next;
			second = cur.next.next;
			first.next = second.next;
			cur.next=second;
			second.next = first;
			cur = first;
		}
		return dummy.next;
	}
	
	public ListNode swapPairs2(ListNode head){
		if(head==null||head.next==null) return head;
		ListNode pre=head,next,cur=head;
		ListNode newhead = head.next;
		while(pre!=null&&pre.next!=null){
			next = cur.next;
			cur.next = cur.next.next;
			cur.next.next = cur;
			pre = cur;
			cur = cur.next;
		}
		return newhead;
	}
	
	//璁ㄨ鍖猴細澧炲姞涓?涓ご缁撶偣鐨勫彉绉?
	public ListNode swapPairs3(ListNode head) {
	    ListNode start = new ListNode(0); //make head no longer a special case
	    start.next = head;

	    for(ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
	      cur.next = swap(cur.next, cur.next.next);        
	    }
	    return start.next;
	  }
	  private ListNode swap(ListNode next1, ListNode next2) {
	    next1.next = next2.next;
	    next2.next = next1;
	    return next2;
	  }
}
