package club.lovety.xy.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 念梓  on 2016/12/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyServerIdleStateHandler extends IdleStateHandler {

    private static final Logger log = LogManager.getLogger(MyServerIdleStateHandler.class);

    public MyServerIdleStateHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
        super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        log.debug("服务器端的监听读取");
        super.read(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug("服务器端的监听开始................");
        super.userEventTriggered(ctx, evt);
    }
}
