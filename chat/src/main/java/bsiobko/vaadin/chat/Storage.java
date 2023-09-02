package bsiobko.vaadin.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class Storage {
  @Getter
  private Queue<ChatMessage> messages = new ConcurrentLinkedDeque<>();

  public Queue<ChatMessage> getMessages() {
    return messages;
  }

  public void addRecord(String user, String message) {
    messages.add(new ChatMessage(user, message));
  }

  @Getter
  @AllArgsConstructor
  public static class ChatMessage{
    private String user;
    private String message;

    public String getMessage() {
      return message;
    }

    public String getName() {
      return user;
    }
  }
}
