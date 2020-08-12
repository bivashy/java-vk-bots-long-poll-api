package bots.longpoll.sdk.executors;

import bots.longpoll.sdk.exceptions.ApiException;
import bots.longpoll.sdk.exceptions.ApiHttpException;
import org.jsoup.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class PostExecutor<Response> extends Executor<Response> {
	private static final Logger log = LoggerFactory.getLogger(PostExecutor.class);
	private InputStream inputStream;
	private File file;

	protected File getFile() {
		return file;
	}

	protected PostExecutor<Response> setFile(File file) {
		this.file = file;
		return this;
	}

	@Override
	public Response execute() throws ApiHttpException {
		try {
			inputStream = new FileInputStream(file);
			return super.execute();
		} catch (FileNotFoundException e) {
			log.error("File not found: {}.", file, e);
			throw new ApiException(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				log.error("Failed to close file InputStream {}.", file, e);
			}
		}
	}

	@Override
	protected List<Connection.KeyVal> getData() {
		List<Connection.KeyVal> data = super.getData();
		data.add(keyVal(getType(), file.getName(), inputStream));
		return data;
	}

	@Override
	protected Connection.Method getMethod() {
		return Connection.Method.POST;
	}

	protected abstract String getType();
}
