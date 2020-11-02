package api.longpoll.bots.adapters.serializers;

import api.longpoll.bots.model.objects.additional.Button;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ButtonColorSerializer implements JsonSerializer<Button.ButtonColor> {
    @Override
    public JsonElement serialize(Button.ButtonColor buttonColor, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(buttonColor.getColor());
    }
}
