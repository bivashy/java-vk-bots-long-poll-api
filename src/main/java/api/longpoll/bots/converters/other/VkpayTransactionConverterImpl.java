package api.longpoll.bots.converters.other;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.other.VkpayTransaction;
import com.google.gson.JsonObject;

public class VkpayTransactionConverterImpl extends JsonToPojoConverter<VkpayTransaction> {
	@Override
	public VkpayTransaction convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, VkpayTransaction.class);
	}
}
