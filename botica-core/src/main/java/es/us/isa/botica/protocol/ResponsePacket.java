package es.us.isa.botica.protocol;

public interface RequestPacket<ResponsePacketT extends Packet> extends Packet {
  String getRequestId();
}
