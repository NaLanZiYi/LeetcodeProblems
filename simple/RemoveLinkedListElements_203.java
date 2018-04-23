package simple;

public class RemoveLinkedListElements_203 {
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;        
        while(head!=null){
        	if(head.val==val){
        		p.next = head.next;
        		head = head.next;
        	}else{
        		p = head;
            	head = head.next;
        	}        	
        }
        return h.next;
    }
}
