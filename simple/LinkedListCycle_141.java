package simple;

public class LinkedListCycle_141 {
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	 }
	
	public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){        	
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow==fast) return true;
        }
        return false;
    }
	
	//璁ㄨ鍖?-2:鍒╃敤寮傚父澶勭悊鏈哄埗涓嶅啀杩涜闈炵┖鍒ゆ柇锛屽鏋滄湁鐜紝鍒欎笉浼氬埌杈緉ull缁堢偣锛屽鏋滄姤寮傚父锛岃鏄庡埌杈句簡缁堢偣锛岃瘉鏄庢棤鐜?
	public boolean hasCycle1(ListNode head) {
		if(head==null) return false;       
        try{
        	ListNode slow = head;
            ListNode fast = head.next;
        	while(fast!=slow){        	
            	slow = slow.next;
            	fast = fast.next.next;
            }
        	return true;
        }catch(Exception e){
        	return false;
        }
	}
	
	//璁ㄨ鍖?-3锛氳姣忎竴涓妭鐐归兘鎸囧悜head锛屽鏋滄湁鐜紝鍒欏繀灏嗗洖鍒板凡缁忛亶鍘嗚繃鐨勮妭鐐癸紝璇ヨ妭鐐圭殑next=head锛?
	//浣嗘槸锛岃鏂规硶鐮村潖浜嗛摼琛?
	public boolean hasCycle2(ListNode head) {
		if(head==null) return false;
		ListNode p = head, pre = p;
		while(p!=null&&p.next!=null){
			if(p.next==head) return true;
			p = p.next;
			pre.next = head;
			pre = p;
		}
		return false;
	}
	
	//璁ㄨ鍖?-4锛氶?掑綊
	public boolean hasCycle3(ListNode head){
	       if(head == null || head.next == null) return false;
	       if(head.next == head) return true;
	       ListNode nextNode = head.next; 
	       head.next = head;
	       boolean isCycle = hasCycle(nextNode);
	       return isCycle;
	   }
}
