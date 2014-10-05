package pl.koziolekweb.guava;

import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.PeekingIterator;

import java.io.Closeable;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class FileLinesIterator extends AbstractIterator<String> implements PeekingIterator<String>, Closeable {

	private final FileReaderViaSupplier supplier;

	public FileLinesIterator(FileReaderViaSupplier supplier) {
		checkNotNull(supplier, "You can't squeeze blood out of a turnip");
		this.supplier = supplier;
	}

	@Override
	protected String computeNext() {
		Optional<String> optional = supplier.get();
		return optional.isPresent() ? optional.get() : eod();
	}

	private String eod(){
		try {
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return endOfData();
	}

	@Override
	public void close() throws IOException {
		supplier.close();
	}
}