package club.lovety.xy.netty.simple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 念梓  on 2016/12/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyClientFileHandler extends ChunkedWriteHandler {

    private static final Logger log = LogManager.getLogger(MyClientFileHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.debug("客户端写文件");
        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("客户端读文件: ");

        super.channelRead(ctx, msg);
    }




}
