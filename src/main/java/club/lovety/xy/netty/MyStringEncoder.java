package club.lovety.xy.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by 念梓  on 2016/12/1.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class MyStringEncoder extends StringEncoder {

    private static final Logger log = LogManager.getLogger(MyStringEncoder.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.debug("你好=======");
        super.write(ctx, msg, promise);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, CharSequence msg, List<Object> out) throws Exception {
        log.debug("nisssss ");
        super.encode(ctx, msg, out);
    }
}
