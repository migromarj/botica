package es.us.isa.botica.director.protocol;

import es.us.isa.botica.protocol.Packet;
import es.us.isa.botica.protocol.RequestPacket;
import es.us.isa.botica.protocol.ResponsePacket;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface BoticaServer {
  void start() throws TimeoutException;

  boolean isConnected();

  <P extends Packet> void registerPacketListener(Class<P> packetClass, PacketListener<P> listener);

  void sendPacket(Packet packet, String botId);

  <ResponsePacketT extends ResponsePacket<?>> void sendPacket(
      RequestPacket<ResponsePacketT> packet,
      String botId,
      PacketListener<ResponsePacketT> callback,
      Runnable timeoutCallback);

  <ResponsePacketT extends ResponsePacket<?>> void sendPacket(
      RequestPacket<ResponsePacketT> packet,
      String botId,
      PacketListener<ResponsePacketT> callback,
      Runnable timeoutCallback,
      long timeout,
      TimeUnit timeoutUnit);

  void close();
}
