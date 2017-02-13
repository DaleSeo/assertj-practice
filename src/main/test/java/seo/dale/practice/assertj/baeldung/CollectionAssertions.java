package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionAssertions {

	@Test
	public void test() {
		List<String> list = Arrays.asList("1", "2", "3");
		assertThat(list)
				.isNotEmpty()
				.contains("1")
				.startsWith("1")
				.doesNotContainNull()
				.containsSequence("2", "3");
	}

}
