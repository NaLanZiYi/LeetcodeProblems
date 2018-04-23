package simple;
//鍚堝苟涓や釜鎺掑簭鍒楄〃
public class MergeTwoSortedLists_21 {
	
	public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
        	return l1==l2?null:(l1==null?l2:l1);
        ListNode node;
        if(l1.val<l2.val){
        	node=l1;
        	l1=l1.next;
        }else{
        	node=l2;
        	l2=l2.next;
        }
        ListNode head=node;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		node.next=l1;
        		l1=l1.next;
        	}else{
        		node.next=l2;
        		l2=l2.next;
        	}
        	node=node.next;
        }
        //涓嬮潰涓や釜寰幆灏嗗叾涓墿浣欑殑閾捐〃渚濇閾炬帴鍒皀ode涓婏紝鍏跺疄鍙敤鐩存帴灏唋1鎴杔2閾炬帴涓婃潵鍗冲彲
//        while(l1!=null){
//        	node.next=l1;
//        	node=node.next;
//        	l1=l1.next;
//        }
//        while(l2!=null){
//        	node.next=l2;
//        	node=node.next;
//        	l2=l2.next;
//        }
        if(l1!=null) node.next=l1;
        else node.next=l2;
        return head; 
    }
	
	//鏂规硶2锛氶?掑綊
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode node=null;
		if(l1.val<l2.val){
			node=l1;
			node.next=mergeTwoLists1(l1.next, l2);
		}else{
			node=l2;
			node.next=mergeTwoLists1(l1, l2.next);
		}
		return node;
	}
}
