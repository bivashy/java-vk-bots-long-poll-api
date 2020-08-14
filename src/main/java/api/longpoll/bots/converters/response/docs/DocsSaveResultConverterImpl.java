package api.longpoll.bots.converters.response.docs;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.DocConverterImpl;
import api.longpoll.bots.model.objects.media.AudioMessage;
import api.longpoll.bots.model.objects.media.Graffiti;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.response.docs.DocsSaveResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class DocsSaveResultConverterImpl extends JsonToPojoConverter<DocsSaveResult> {
	private static final String RESPONSE_FIELD = "response";
	private static final String DOC_FIELD = "doc";
	private static final String GRAFFITI_FIELD = "graffiti";
	private static final String AUDIO_MESSAGE_FIELD = "audio_message";

	@Override
	public DocsSaveResult convert(JsonObject jsonObject) {
		DocsSaveResult docsSaveResult = gson.fromJson(jsonObject, DocsSaveResult.class);
		DocsSaveResult.Response response = docsSaveResult.getResponse();
		Attachable attachable = null;

		JsonObject jsonResponse = jsonObject.getAsJsonObject(RESPONSE_FIELD);
		switch (response.getType()) {
			case DOC_FIELD:
				attachable = new DocConverterImpl().convert(jsonResponse.getAsJsonObject(DOC_FIELD));
				break;

			case GRAFFITI_FIELD:
				attachable = GenericConverterFactory.get(Graffiti.class).convert(jsonResponse.getAsJsonObject(GRAFFITI_FIELD));
				break;

			case AUDIO_MESSAGE_FIELD:
				attachable = GenericConverterFactory.get(AudioMessage.class).convert(jsonResponse.getAsJsonObject(AUDIO_MESSAGE_FIELD));
				break;
		}

		response.setAttachable(attachable);
		return docsSaveResult;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Attachable.class.equals(fieldAttributes.getDeclaredClass());
	}
}
