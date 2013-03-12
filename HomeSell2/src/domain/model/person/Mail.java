package domain.model.person;

import java.sql.Date;

public class Mail {
	private long message_id;
	private String message;
	private Date sent;
	private long sender;
	private long receiver;
	
	public Mail(long message_id, String message, Date sent, long sender, long receiver)
	{
		setMessage_id(message_id);
		setMessage(message);
		setSent(sent);
		setSender(sender);
		setReceiver(receiver);
	}
	
	public long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSent() {
		return sent;
	}
	public void setSent(Date sent) {
		this.sent = sent;
	}
	public long getSender() {
		return sender;
	}
	public void setSender(long sender) {
		this.sender = sender;
	}
	public long getReceiver() {
		return receiver;
	}
	public void setReceiver(long receiver) {
		this.receiver = receiver;
	}
}
