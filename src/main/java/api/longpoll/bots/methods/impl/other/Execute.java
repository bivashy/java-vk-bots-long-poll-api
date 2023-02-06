package api.longpoll.bots.methods.impl.other;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.JsonElement;

/**
 * Implements <b>execute</b> method.
 * <p>
 * A universal method for calling a sequence of other methods while saving and filtering interim results.
 *
 * @see <a href="https://vk.com/dev/execute">https://vk.com/dev/execute</a>
 */
public class Execute extends VkMethod<Execute.ResponseBody> {
    public Execute(String accessToken) {
        super(property("execute"), accessToken);
    }

    @Override
    public String getUri() {
        return property("execute");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public Execute setCode(String code) {
        return addParam("code", code);
    }

    public Execute setFuncV(int funcV) {
        return addParam("func_v", funcV);
    }

    @Override
    public Execute addParam(String key, Object value) {
        return (Execute) super.addParam(key, value);
    }

    /**
     * Response to <b>execute</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<JsonElement> {
    }
}
