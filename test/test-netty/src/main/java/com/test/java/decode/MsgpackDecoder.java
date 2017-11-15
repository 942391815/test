package com.test.java.decode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * Created by qiaogu on 2017/11/9.
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf>{
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        int readLength = msg.readableBytes();
        byte[] bytes = new byte[readLength];
        msg.getBytes(msg.readerIndex(),bytes,0,readLength);
        MessagePack msgPack  = new MessagePack();
        out.add(msgPack.read(bytes));
    }
}
