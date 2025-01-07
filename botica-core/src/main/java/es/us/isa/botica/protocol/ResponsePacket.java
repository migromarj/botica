package es.us.isa.botica.protocol;

public interface ResponsePacket<RequestPacketT extends Packet> extends Packet {
  String getRequestId();
}
