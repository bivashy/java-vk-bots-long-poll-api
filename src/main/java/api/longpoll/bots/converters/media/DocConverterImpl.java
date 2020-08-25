package api.longpoll.bots.converters.media;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.media.Doc;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class DocConverterImpl extends JsonToPojoConverter<Doc> {
	private static final String PREVIEW_FIELD = "preview";
	private static final String PHOTO = "photo";
	private static final String GRAFFITI = "graffiti";
	private static final String AUDIO_MSG = "audio_msg";

	@Override
	public Doc convert(JsonObject jsonObject) {
		Doc doc = gson.fromJson(jsonObject, Doc.class);
		Map<String, Doc.Preview> preview = new HashMap<>();
		jsonObject.getAsJsonObject(PREVIEW_FIELD)
				.entrySet()
				.forEach(entry -> {
					String key = entry.getKey();
					JsonObject object = entry.getValue().getAsJsonObject();
					switch (key) {
						case PHOTO:
							preview.put(key, GenericConverterFactory.get(Doc.Photo.class).convert(object));
							break;

						case GRAFFITI:
							preview.put(key, GenericConverterFactory.get(Doc.Graffiti.class).convert(object));
							break;

						case AUDIO_MSG:
							preview.put(key, GenericConverterFactory.get(Doc.AudioMessage.class).convert(object));
							break;
					}
				});
		doc.setPreview(preview);
		return doc;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Map.class.equals(fieldAttributes.getDeclaredClass());
	}
}
