package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThrowableAssertions {

	@Test
	public void test() {
		Exception ex = new RuntimeException("ERROR!");
		assertThat(ex).hasNoCause().hasMessageEndingWith("!");
	}

}
