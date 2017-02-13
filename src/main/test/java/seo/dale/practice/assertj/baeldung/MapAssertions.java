package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class MapAssertions {

	@Test
	public void test() {
		Map<Integer, String> map = Collections.singletonMap(2, "a");
		assertThat(map)
				.isNotEmpty()
				.containsKey(2)
				.doesNotContainKey(10)
				.contains(entry(2, "a"));
	}

}
