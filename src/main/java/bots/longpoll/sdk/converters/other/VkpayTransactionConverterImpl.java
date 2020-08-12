package bots.longpoll.sdk.converters.other;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.other.VkpayTransaction;
import com.google.gson.JsonObject;

public class VkpayTransactionConverterImpl extends JsonToPojoConverter<VkpayTransaction> {
	@Override
	public VkpayTransaction convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, VkpayTransaction.class);
	}
}
