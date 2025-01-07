package es.us.isa.botica.protocol;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class QueryHandler {
  private final ScheduledExecutorService executorService;

  private final Map<String, Consumer<ResponsePacket<?>>> callbacks = new ConcurrentHashMap<>();
  private final Map<String, ScheduledFuture<?>> timeoutFutures = new ConcurrentHashMap<>();

  public QueryHandler(ScheduledExecutorService executorService) {
    this.executorService = executorService;
  }

  @SuppressWarnings("unchecked")
  public <ResponsePacketT extends Packet> void registerQuery(
      RequestPacket<ResponsePacketT> packet,
      Consumer<ResponsePacketT> callback,
      Runnable timeoutCallback,
      long timeout,
      TimeUnit timeoutUnit) {
    String requestId = generateRequestId();
    packet.setRequestId(requestId);

    ScheduledFuture<?> future =
        this.executorService.schedule(
            () -> {
              this.callbacks.remove(requestId);
              this.timeoutFutures.remove(requestId);
              timeoutCallback.run();
            },
            timeout,
            TimeUnit.MILLISECONDS);
    this.callbacks.put(requestId, (Consumer<ResponsePacket<?>>) callback);
    this.timeoutFutures.put(requestId, future);
  }

  public void acceptResponse(ResponsePacket<?> packet) {
    Consumer<ResponsePacket<?>> callback = this.callbacks.remove(packet.getRequestId());
    if (callback == null) return;

    ScheduledFuture<?> timeoutFuture = this.timeoutFutures.remove(packet.getRequestId());
    if (timeoutFuture != null) timeoutFuture.cancel(false);

    callback.accept(packet);
  }

  private static String generateRequestId() {
    return new Random().ints('0', 'z' + 1)
        .filter(i -> i <= '9' || i >= 'A' && i <= 'Z' || i >= 'a')
        .limit(8)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
