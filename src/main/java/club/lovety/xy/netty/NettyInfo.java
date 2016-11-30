package club.lovety.xy.netty;

/**
 * Created by 念梓  on 2016/11/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class NettyInfo {

    private int head;

    private String msg;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NettyInfo{");
        sb.append("head=").append(head);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
