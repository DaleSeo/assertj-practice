package seo.dale.practice.assertj.baeldung;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterAssertions {

	@Test
	public void test() {
		assertThat('c')
				.isNotEqualTo('a')
				.inUnicode()
				.isGreaterThan('b')
				.isLowerCase();
	}

}
