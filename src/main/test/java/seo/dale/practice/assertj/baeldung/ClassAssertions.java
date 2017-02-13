package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassAssertions {

	@Test
	public void test() {
		assertThat(Runnable.class).isInterface();
		assertThat(Exception.class).isAssignableFrom(RuntimeException.class);
	}

}
