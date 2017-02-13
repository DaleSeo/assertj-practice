package seo.dale.practice.assertj.baeldung;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectAssertions {

	@Test
	public void test() {
		Dog frido = new Dog("Fido", 5.25F);
		Dog fridoClone = new Dog("Fido", 5.25F);

		assertThat(frido).isNotEqualTo(fridoClone);
		assertThat(frido).isEqualToComparingFieldByFieldRecursively(fridoClone);
	}

	static class Dog {

		private String name;
		private Float weight;

		public Dog(String name, Float weight) {
			this.name = name;
			this.weight = weight;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Float getWeight() {
			return weight;
		}

		public void setWeight(Float weight) {
			this.weight = weight;
		}

	}

}
