package es.us.isa.botica.protocol;

public abstract class AbstractResponsePacket<RequestPacketT extends Packet>
    implements ResponsePacket<RequestPacketT> {
  protected final String requestId;

  public AbstractResponsePacket(String requestId) {
    this.requestId = requestId;
  }

  @Override
  public String getRequestId() {
    return requestId;
  }
}
