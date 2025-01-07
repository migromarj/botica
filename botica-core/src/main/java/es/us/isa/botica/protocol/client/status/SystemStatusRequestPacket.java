package es.us.isa.botica.protocol.client.status;

import es.us.isa.botica.protocol.AbstractRequestPacket;
import es.us.isa.botica.protocol.client.ClientPacket;
import es.us.isa.botica.protocol.server.status.SystemStatusResponsePacket;

public class SystemStatusRequestPacket extends AbstractRequestPacket<SystemStatusResponsePacket>
    implements ClientPacket {

  public SystemStatusRequestPacket() {
    super(SystemStatusResponsePacket.class);
  }

  @Override
  public String toString() {
    return "SystemStatusRequestPacket{" + "requestId='" + requestId + '\'' + '}';
  }
}
