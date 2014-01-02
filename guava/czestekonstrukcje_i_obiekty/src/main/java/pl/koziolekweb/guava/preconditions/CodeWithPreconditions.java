package pl.koziolekweb.guava.preconditions;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class CodeWithPreconditions {
	public void method(String param1, Integer param2) {
		checkNotNull(param1, "Param1 can not be null");
		checkNotNull(param2, "Param2 can not be null");
		checkArgument(!param1.isEmpty(), "Param 1 can not be empty");
		checkArgument(param2 > 0, "Param 2 can not be <=0");
	}

	public void method2(String param1){
		checkElementIndex(1, param1.length());
		checkPositionIndex(3, param1.length());
	}
}
