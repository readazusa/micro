package club.lovety.xy.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 念梓  on 2016/11/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyIdle extends IdleStateHandler {

    private static final Logger log = LogManager.getLogger(MyIdle.class);

    public MyIdle(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
        super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds);
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug("监测服务器端的链接: context: {},evt: {}", ctx, evt);
    }
}
