package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class NumberAssertions {

	@Test
	public void test() {
		assertThat(5.1).isEqualTo(5, withPrecision(0.1d));
	}

}
