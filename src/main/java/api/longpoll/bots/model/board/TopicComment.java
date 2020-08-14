package api.longpoll.bots.model.board;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicComment implements EventObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("from_id")
	private Integer fromId;
	@SerializedName("date")
	private Integer date;
	@SerializedName("text")
	private String text;
	@SerializedName("attachments")
	private List<Attachment> attachments;

	public Integer getId() {
		return id;
	}

	public TopicComment setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getFromId() {
		return fromId;
	}

	public TopicComment setFromId(Integer fromId) {
		this.fromId = fromId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public TopicComment setDate(Integer date) {
		this.date = date;
		return this;
	}

	public String getText() {
		return text;
	}

	public TopicComment setText(String text) {
		this.text = text;
		return this;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public TopicComment setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
		return this;
	}
}
