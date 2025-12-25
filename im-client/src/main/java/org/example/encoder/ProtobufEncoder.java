package org.example.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.example.protos.MsgProtos;

public class ProtobufEncoder extends MessageToByteEncoder<MsgProtos.Msg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MsgProtos.Msg msg, ByteBuf byteBuf) throws Exception {
        byte[] bytes = msg.toByteArray();
        int length = bytes.length;
        byteBuf.writeShort(length);
        byteBuf.writeBytes(msg.toByteArray());
    }
}
