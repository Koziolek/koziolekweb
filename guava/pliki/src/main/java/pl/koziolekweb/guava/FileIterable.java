package pl.koziolekweb.guava;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class FileIterable implements Iterable<String> {

	private final String path;

	public FileIterable(String path) {
		this.path = path;
	}

	@Override
	public FileLinesIterator iterator() {
		return new FileLinesIterator(new FileReaderViaSupplier(path));
	}

}
