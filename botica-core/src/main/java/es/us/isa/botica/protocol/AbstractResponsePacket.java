package es.us.isa.botica.protocol;

public abstract class AbstractRequestPacket<ResponsePacketT extends Packet>
    implements RequestPacket<ResponsePacketT> {
  protected String requestId;

  public AbstractRequestPacket() {}

  public AbstractRequestPacket(String requestId) {
    this.requestId = requestId;
  }

  @Override
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
}
