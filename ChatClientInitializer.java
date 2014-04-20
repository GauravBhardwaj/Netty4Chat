package deleteIt;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * 
 */
public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
       
    	ChannelPipeline pipeline = ch.pipeline();

                
       // add decoders and encoders.
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));  // 
        pipeline.addLast("decoder", new StringDecoder()); // 
        pipeline.addLast("encoder", new StringEncoder()); // 

        // and then business logic.
        pipeline.addLast("handler", new ChatClientHandler()); // 
    }
}