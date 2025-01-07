package es.us.isa.botica.protocol.server.status;

import es.us.isa.botica.protocol.AbstractResponsePacket;
import es.us.isa.botica.protocol.client.status.SystemStatusRequestPacket;
import es.us.isa.botica.protocol.server.ServerPacket;
import java.util.List;
import java.util.Map;

public class SystemStatusResponsePacket extends AbstractResponsePacket<SystemStatusRequestPacket>
    implements ServerPacket {
  private Map<String, List<BotInfo>> bots;

  public SystemStatusResponsePacket(String requestId) {
    super(requestId);
  }

  public Map<String, List<BotInfo>> getBots() {
    return bots;
  }

  @Override
  public String toString() {
    return "SystemStatusResponsePacket{"
        + "bots="
        + bots
        + ", requestId='"
        + requestId
        + '\''
        + '}';
  }
}
