package simple;
import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicates_83 {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	//鍒ゆ柇涓嬩竴涓妭鐐?
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        Set<Integer> nodeset=new HashSet<Integer>();
        nodeset.add(head.val);
        ListNode node=head;
        while(node.next!=null){
        	if(nodeset.contains(node.next.val)){
        		node.next=node.next.next; 
        	}else{
        		nodeset.add(node.next.val);
        		node=node.next;
        	}
        }
        return head;
    }
	
	//娉ㄦ剰鏉′欢-鎺掑簭鐨勫垪琛?:闇?瑕佹敞鎰忛潪绌哄拰杈圭晫鍒ゆ柇
	public ListNode deleteDuplicates1(ListNode head) {
		if(head!=null&&head.next!=null){
			ListNode node=head;
			while(node.next!=null){
				if(node.val==node.next.val){
					node.next=node.next.next;
				}else{
					node=node.next;
				}
			}			
		}
		return head;
	}
	
	//璁ㄨ鍖猴細閫掑綊
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null||head.next==null) return head;
		head.next=deleteDuplicates2(head.next);
		return head.val==head.next.val?head.next:head;
	}
	
	//璁ㄨ鍖猴細1琛?
	public ListNode deleteDuplicates3(ListNode h) {
		return (h!=null) && ((h.next = deleteDuplicates3(h.next))!=null) && h.next.val == h.val ? h.next : h;
	}
}
