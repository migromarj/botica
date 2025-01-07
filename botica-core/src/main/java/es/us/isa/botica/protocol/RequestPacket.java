package es.us.isa.botica.protocol;


public interface RequestPacket<ResponsePacketT extends ResponsePacket<?>> extends Packet {
  String getRequestId();

  void setRequestId(String requestId);

  Class<ResponsePacketT> getResponsePacketClass();
}
