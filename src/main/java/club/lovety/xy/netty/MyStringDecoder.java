package club.lovety.xy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.string.StringDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by 念梓  on 2016/12/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyStringDecoder extends StringDecoder {

    private static  final Logger log = LogManager.getLogger(MyStringDecoder.class);



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf ByteBuf =  (ByteBuf) msg;
        super.channelRead(ctx, msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        log.debug("===========");
        super.decode(ctx, msg, out);
    }
}
