package club.lovety.xy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 念梓  on 2016/11/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyEncoder extends MessageToByteEncoder<NettyInfo> {

    private static final Logger log = LogManager.getLogger(MyEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyInfo msg, ByteBuf out) throws Exception {
        log.debug("neggty：{}",msg);
        String result = msg.getHead()+msg.getMsg();
        byte[] bb = result.getBytes();
//        ByteBuf byteBuf = ctx.alloc().buffer(bb.length);
        out.writeBytes(bb);
        ctx.writeAndFlush(out);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
        log.debug("写入： {}",msg);
    }


    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
//        super.read(ctx);

    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
//        super.flush(ctx);
    }
}
