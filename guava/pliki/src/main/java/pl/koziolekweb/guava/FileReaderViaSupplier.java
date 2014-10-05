package pl.koziolekweb.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class FileReaderViaSupplier implements Supplier<Optional<String>>, Closeable {

	private BufferedReader reader;

	public FileReaderViaSupplier(String filePath) {
		this(new File(checkNotNull(filePath)), UTF_8);
	}

	public FileReaderViaSupplier(File file, Charset charset) {
		checkNotNull(file);
		checkNotNull(charset);
		checkArgument(file.exists(), "File %s does not exist", file.getAbsolutePath());
		try {
			reader = Files.asCharSource(file, charset).openBufferedStream();
		} catch (IOException e) {
			checkState(false, e.getMessage());
		}
	}

	@Override
	public Optional<String> get() {
		try {
			String reference = reader.readLine();
			return Optional.fromNullable(reference).or(Optional.<String>absent());
		} catch (IOException e) {
			return Optional.absent();
		}
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}
}

