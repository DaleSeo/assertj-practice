package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescribingAssertions {

	@Test
	public void test() {
		int age = 100;
		assertThat(age)
				.as("%s's age should be equal to 100", age)
				.isEqualTo(100);
	}

}
