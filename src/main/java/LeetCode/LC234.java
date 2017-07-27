package LeetCode;

/**
 * Created by jie on 7/16/17.
 */
public class LC234 {
    public static boolean isPalindrome(ListNode head) {
        int nNode =0;
        ListNode currentNode = head;
        while(currentNode!=null){
            nNode++;
            currentNode=currentNode.next;
        }
        if (nNode<=1) return true;
        int half=nNode/2;
        currentNode = head;
        while(half>0){
            currentNode=currentNode.next;
            half--;
        }
        HelperClass.reverseList(head,currentNode);
        ListNode newHead= HelperClass.newHead;
        boolean rt=true;
        ListNode move1= newHead;
        ListNode move2=nNode%2==1?currentNode.next:currentNode;
        while(move1!=null){
            if(move1.val!=move2.val){
                rt=false;
                break;
            }
            move1=move1.next;
            move2=move2.next;
        }
        return rt;

    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        ListNode n2=new ListNode(2);
        head.next=n2;
        isPalindrome(head);
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class HelperClass{
    static ListNode newHead=null;
    public static ListNode reverseList(ListNode head, ListNode stopNode){
        newHead=null;
        if(head.next==stopNode ||head.next==null)
            newHead=head;
        else {
            ListNode newTail = reverseList(head.next, stopNode);
            newTail.next = head;
        }
        head.next=null;
        return head;
    }
}
