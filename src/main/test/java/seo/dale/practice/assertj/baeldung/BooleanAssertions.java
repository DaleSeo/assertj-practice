package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanAssertions {

	@Test
	public void test() {
		assertThat("".isEmpty()).isTrue();
	}

}
