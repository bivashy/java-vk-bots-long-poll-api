package api.longpoll.bots.model.market.order;

import com.google.gson.annotations.SerializedName;

public class PropertyValue {
	@SerializedName("variant_id")
	private Integer variantId;
	@SerializedName("variant_name")
	private String variantName;
	@SerializedName("property_name")
	private String propertyName;

	public Integer getVariantId() {
		return variantId;
	}

	public PropertyValue setVariantId(Integer variantId) {
		this.variantId = variantId;
		return this;
	}

	public String getVariantName() {
		return variantName;
	}

	public PropertyValue setVariantName(String variantName) {
		this.variantName = variantName;
		return this;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public PropertyValue setPropertyName(String propertyName) {
		this.propertyName = propertyName;
		return this;
	}
}
