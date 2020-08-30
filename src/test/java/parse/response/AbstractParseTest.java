package parse.response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public abstract class AbstractParseTest {
    private static Gson gson = new Gson();

    protected static JsonObject readJson(String path) throws IOException {
        return gson.fromJson(readFile(path), JsonObject.class);
    }

    protected static String readFile(String relativePath) throws IOException {
        return FileUtils.readFileToString(
                getFile(relativePath),
                "UTF-8");
    }

    private static File getFile(String relativePath) {
        return new File("src/test/resource/".concat(relativePath));
    }
}
