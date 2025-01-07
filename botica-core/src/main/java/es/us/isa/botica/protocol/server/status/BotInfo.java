package es.us.isa.botica.protocol.server.status;

import es.us.isa.botica.bot.BotStatus;
import java.time.Instant;

public class BotInfo {
  private final String botId;
  private final BotStatus status;
  private final Instant lastChecked;

  public BotInfo(String botId, BotStatus status, Instant lastChecked) {
    this.botId = botId;
    this.status = status;
    this.lastChecked = lastChecked;
  }

  public String getBotId() {
    return botId;
  }

  public Instant getLastChecked() {
    return lastChecked;
  }

  @Override
  public String toString() {
    return "BotInfo{"
        + "botId='"
        + botId
        + '\''
        + ", status="
        + status
        + ", lastChecked="
        + lastChecked
        + '}';
  }
}
