package com.naveen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.naveen.database.DatabaseClass;
import com.naveen.model.Message;

public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {

	messages.put(1L, new Message(1L, "Hello World 1", "Naveen"));
	messages.put(2L, new Message(2L, "Hello World 2", "Rob"));
	messages.put(3L, new Message(3L, "Hello World 3", "Bob"));
	messages.put(4L, new Message(4L, "Hello World 4", "Kate"));
	
    }

    public List<Message> getAllMessages() {
	return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id) {
	return messages.get(id);
    }

    public Message addMessage(Message message) {
	message.setId(messages.size() + 1);
	messages.put(message.getId(), message);
	return message;
    }

    public Message updateMessage(Message message) {
	if (message.getId() <= 0) {
	    return null;
	}
	messages.put(message.getId(), message);
	return message;
    }

    public Message removeMessage(long id) {
	return messages.remove(id);
    }
}
