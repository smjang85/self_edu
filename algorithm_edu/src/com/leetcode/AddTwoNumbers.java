package com.leetcode;
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
    	ListNode p = l1;
    	ListNode q = l2;
    	ListNode curr = dummyHead;
    	
    	int carry = 0;
    	while( p != null || q != null) {
    		int x = ( p != null ) ? p.data : 0;
    		int y = ( q != null ) ? q.data : 0;
    		int sum = carry + x + y;
    		carry = sum / 10;
    		curr.next = new ListNode ( sum % 10 );
    		curr = curr.next;
    		if (p != null) p = p.next;
    		if (q != null) q = q.next;
    	}
    	
    	if(carry > 0) {
    		curr.next = new ListNode(carry);
    	}
    	
    	return dummyHead.next;
    }
	
	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		
		ListNode result = addTwoNumbers(l1,l2);
		while(result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}
}

class ListNode{
	Integer data;
	ListNode next;
	
	public ListNode() {
		this.data = null;
		this.next = null;
	}
	
	public ListNode(int data) {
		this.data = data;
	}
	
	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}
