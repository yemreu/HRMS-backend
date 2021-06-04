package yunusemreuzun.hrms.core.utilities.generators;

import java.util.Random;

public class RandomStringGenerator {
	
	public String generateRandomAlphanumericString(int limit) {
		return new Random().ints(48, 123).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(limit).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}
}
