package api.longpoll.bots.methods;

import org.jsoup.Connection;

import java.io.*;

public abstract class PostMethod<Response> extends Method<Response> {
	private File file;

	protected File getFile() {
		return file;
	}

	protected PostMethod<Response> setFile(File file) {
		this.file = file;
		return this;
	}

	@Override
	protected Connection.Response execute(Connection connection) throws IOException {
		if (file != null) {
			try (InputStream inputStream = new FileInputStream(file)) {
				connection.data(getType(), file.getName(), inputStream);
				return super.execute(connection);
			}
		}

		return super.execute(connection);
	}

	@Override
	protected Connection.Method getMethod() {
		return Connection.Method.POST;
	}

	protected abstract String getType();
}
