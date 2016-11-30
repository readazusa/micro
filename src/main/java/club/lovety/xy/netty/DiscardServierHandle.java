package club.lovety.xy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 念梓  on 2016/11/29.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class DiscardServierHandle extends ChannelInboundHandlerAdapter {

    private static final Logger log = LogManager.getLogger(DiscardServierHandle.class);

    private ByteBuf bbb;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        log.info("ChannelHandlerContext: {}", ctx);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        log.error("异常退出...........");
//        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("注册了一个channel......{}", ctx);
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("退出注册一个unregister。。。。。。");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("监听连接是否存在.............");
        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug("测试心跳: {}",ctx);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        bbb = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
        bbb.release();
        bbb = null;
    }
}
