package api.longpoll.bots.adapters.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.JsonAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PayloadDeserializerTest {
    Gson gson = new Gson();

    @Test
    void parseBooleanTest() {
        String json = "{\"payload\":true}";

        JsonElement payload = gson.fromJson(json, PayloadHolder.class).payload;
        assertTrue(payload.isJsonPrimitive());

        JsonPrimitive jsonPrimitive = payload.getAsJsonPrimitive();
        assertTrue(jsonPrimitive.isBoolean());
        assertTrue(jsonPrimitive.getAsBoolean());
    }

    @Test
    void parseStringTest() {
        String json = "{\"payload\":\"Hello World!\"}";

        JsonElement payload = gson.fromJson(json, PayloadHolder.class).payload;
        assertTrue(payload.isJsonPrimitive());

        JsonPrimitive jsonPrimitive = payload.getAsJsonPrimitive();
        assertTrue(jsonPrimitive.isString());
        assertEquals("Hello World!", jsonPrimitive.getAsString());
    }

    @Test
    void parseJsonTest() {
        String json = "{\"payload\":{\"foo\":\"bar\"}}";

        JsonElement payload = gson.fromJson(json, PayloadHolder.class).payload;
        assertTrue(payload.isJsonObject());

        JsonObject jsonObject = payload.getAsJsonObject();
        assertTrue(jsonObject.has("foo"));

        JsonElement foo = jsonObject.get("foo");
        assertTrue(foo.isJsonPrimitive());

        JsonPrimitive jsonPrimitive = foo.getAsJsonPrimitive();
        assertTrue(jsonPrimitive.isString());
        assertEquals("bar", jsonPrimitive.getAsString());
    }

    @Test
    void parseStringJsonTest() {
        String json = "{\"payload\":\"{\\\"foo\\\":\\\"bar\\\"}\"}";

        JsonElement payload = gson.fromJson(json, PayloadHolder.class).payload;
        assertTrue(payload.isJsonObject());

        JsonObject jsonObject = payload.getAsJsonObject();
        assertTrue(jsonObject.has("foo"));

        JsonElement foo = jsonObject.get("foo");
        assertTrue(foo.isJsonPrimitive());

        JsonPrimitive jsonPrimitive = foo.getAsJsonPrimitive();
        assertTrue(jsonPrimitive.isString());
        assertEquals("bar", jsonPrimitive.getAsString());
    }

    static class PayloadHolder {
        @JsonAdapter(PayloadDeserializer.class)
        JsonElement payload;
    }
}