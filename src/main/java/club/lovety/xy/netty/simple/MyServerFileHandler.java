package club.lovety.xy.netty.simple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Created by 念梓  on 2016/12/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyServerFileHandler extends SimpleChannelInboundHandler<String>{

    private static final Logger log = LogManager.getLogger(MyServerFileHandler.class);



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.debug("文件服务器读取文件: ");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("一个新的客户端连接进来: {}",ctx);
        super.channelRegistered(ctx);
    }
}
