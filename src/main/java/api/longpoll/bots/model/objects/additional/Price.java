package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes price.
 *
 * @see <a href="https://vk.com/dev/price">Price</a>
 */
public class Price {
    /**
     * Integer price value multiplied by 100.
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * Price currency.
     */
    @SerializedName("currency")
    private Currency currency;

    /**
     * Localized price and currency.
     */
    @SerializedName("text")
    private String text;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", text='" + text + '\'' +
                '}';
    }
}