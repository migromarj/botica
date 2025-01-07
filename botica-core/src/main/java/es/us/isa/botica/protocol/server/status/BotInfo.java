package es.us.isa.botica.protocol.server.status;

import java.time.Instant;

public class BotStatus {
  private final String botId;
  private final Instant lastChecked;

  public BotStatus(String botId, Instant lastChecked) {
    this.botId = botId;
    this.lastChecked = lastChecked;
  }

  public String getBotId() {
    return botId;
  }

  public Instant getLastChecked() {
    return lastChecked;
  }
}
