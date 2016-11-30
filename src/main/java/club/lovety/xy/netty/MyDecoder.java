package club.lovety.xy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by ty on 2016/11/30.
 */
public class MyDecoder extends ByteToMessageDecoder {


    private static final Logger log = LogManager.getLogger(MyDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.debug("收到客户端的数据 ： {}",in);
        byte[] head = new byte[4];
        in.readBytes(head,0,4);
        String hs = new String(head);
        byte[] msg = new byte[3];
        in.readBytes(msg,0,3);
        String m = new String(msg);

        NettyInfo nettyInfo = new NettyInfo();
        nettyInfo.setHead(Integer.parseInt(hs));
        nettyInfo.setMsg(m);
        out.add(nettyInfo);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("开始得去客户端的数据");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      log.debug("客户端关闭一个连接: {}",ctx);
    }
}
