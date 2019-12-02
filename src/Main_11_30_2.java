import java.util.Calendar;
import java.util.List;

public class Main_11_30_2 {
    static   class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode cur1  = a;
        ListNode cur2 = b;
        ListNode res=  new ListNode(-1);
        ListNode last = res;
        int carry =0;
        while(cur1!=null || cur2!=null){
            if(cur1!=null && cur2 !=null){
                last.next = new ListNode((cur1.val + cur2.val + carry)%10);
                carry = (cur1.val + cur2.val +carry)/10;
                cur1 = cur1.next;
                cur2 = cur2.next;
                last= last.next;
            }else  if(cur1==null){
                last.next = new ListNode((cur2.val + carry)%10);
                carry = (carry + cur2.val) /10;
                cur2 = cur2.next;
                last = last.next;
            }else if(cur2 ==null){
                last.next = new ListNode((cur1.val + carry)%10);
                carry = (carry + cur1.val)/10;
                cur1=  cur1.next;
                last =last.next;
            }
        }
        if(carry != 0){
            last.next = new ListNode(carry);
            last= last.next;
        }
        ListNode t = res.next;
        while(t!=null){

            System.out.println(t.val+" ");
            t = t.next;
        }
        return res.next;
    }

    /**
     * 将链表转为整数
     * 计算求和
     * 最后将整数转换成链表
     */
    public ListNode plusABs(ListNode a,ListNode b ){
        int aValue = listNodeConverIntValue(a);
        int bValue = listNodeConverIntValue(b);
        int sumValue = aValue+bValue;
        return intValueConverListNode(sumValue);
    }

    private ListNode intValueConverListNode(int value) {
        //数字转成字符数组
        char []chars = String.valueOf(value).toCharArray();
        //字符数组转成字符串---字符串转成数字
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(chars[chars.length -1])));
        ListNode cur = node;
        for(int i = chars.length -2; i>=0 ; i --){
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
            cur.next = newNode;
            cur = newNode;
        }
        while(node!=null){
            System.out.println(node.val+" ");
            node = node.next;
        }
        return node;
    }

    private int listNodeConverIntValue(ListNode node) {
        StringBuffer sb = new StringBuffer();
        ListNode cur = node;
        while(cur!=null){
            sb.append(cur.val);
            cur = cur.next;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
            ListNode head1 = new ListNode(1);
            ListNode q1 = new ListNode(3);
            ListNode q2 = new ListNode(4);
            ListNode q3 = new ListNode(5);
            ListNode q4 = new ListNode(6);

            ListNode head2 = new ListNode(9);
            ListNode w1 = new ListNode(6);
            ListNode w2 = new ListNode(5);
            ListNode w3 = new ListNode(4);
            ListNode w4 = new ListNode(3);
            head1.next = q1;
            q1.next = q2;
            q2.next  = q3;
            q3.next = q4;
            head2.next = w1;
            w1.next = w2;
            w2.next = w3;
            w3.next = w4;
        Main_11_30_2 m = new Main_11_30_2();
        m.plusABs(head1,head2);
        }
}
