package club.lovety.xy.netty;

import club.lovety.xy.netty.simple.MyClientFileHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;

/**
 * Created by 念梓  on 2016/11/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class TimeClient {


    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8888;
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
//                    ch.pipeline().addLast(new MyEncoder()).addLast(new MyIdle(60,60,100));
//                    ch.pipeline().addLast("idleStateHandler",new MyIdleStateHandler(0,6,6));
//                    ch.pipeline().addLast(new MyStringEncoder(),new StringEncoder());
//                    ch.pipeline().addLast(new MyStringDecoder());
                    ch.pipeline().addLast(new MyClientFileHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)
            SocketChannel socketChannel =  (SocketChannel)f.channel();

            File file = new File("G:"+ File.separator+"PortalController.java");

            socketChannel.writeAndFlush(new ChunkedNioFile(file));

//            NettyInfo nettyInfo = new NettyInfo();
//            nettyInfo.setHead(1234);
//            nettyInfo.setMsg("000");
//            socketChannel.writeAndFlush(nettyInfo);
//            socketChannel.writeAndFlush("12345667");
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}
