package seo.dale.practice.assertj;

import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static seo.dale.practice.assertj.Race.*;

/**
 * http://joel-costigliola.github.io/assertj/
 */
public class QuickStartTest {

	private TolkienCharacter sauron;

	private TolkienCharacter frodo;
	private TolkienCharacter sam;
	private TolkienCharacter pippin;
	private TolkienCharacter merry;
	private TolkienCharacter aragorn;
	private TolkienCharacter legolas;
	private TolkienCharacter boromir;
	private TolkienCharacter gandalf;

	private List<TolkienCharacter> fellowshipOfTheRing;

	@Before
	public void setUp() {
		sauron = new TolkienCharacter("Sauron");

		frodo = new TolkienCharacter("Frodo", 23, HOBBIT);
		sam = new TolkienCharacter("Sam", 38, HOBBIT);
		pippin = new TolkienCharacter("Pippin", 38, HOBBIT);
		merry = new TolkienCharacter("Merry", 38, HOBBIT);
		aragorn = new TolkienCharacter("Aragorn", 38, MAN);
		legolas = new TolkienCharacter("Legolas", 1000, ELF);
		boromir = new TolkienCharacter("Boromir", 37, MAN);
		gandalf = new TolkienCharacter("Gandalf", 38, MAN);

		fellowshipOfTheRing = new ArrayList<>(9);
		fellowshipOfTheRing.add(frodo);
		fellowshipOfTheRing.add(sam);
		fellowshipOfTheRing.add(pippin);
		fellowshipOfTheRing.add(merry);
		fellowshipOfTheRing.add(aragorn);
		fellowshipOfTheRing.add(legolas);
		fellowshipOfTheRing.add(boromir);
		fellowshipOfTheRing.add(gandalf);
		fellowshipOfTheRing.add(new TolkienCharacter(""));
	}

	@Test
	public void testBasic() {
		// basic assertions
		assertThat(frodo.getName()).isEqualTo("Frodo");
		assertThat(frodo).isNotEqualTo(sauron);
	}

	@Test
	public void testOnStrings() {
		// chaining string specific assertions
		assertThat(frodo.getName())
				.startsWith("Fro")
				.endsWith("do")
				.isEqualToIgnoringCase("frodo");
	}

	@Test
	public void testOnCollections() {
		// collection specific assertions (there are plenty more)
		// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
		assertThat(fellowshipOfTheRing)
				.hasSize(9)
				.contains(frodo, sam)
				.doesNotContain(sauron);
	}

	@Test(expected = ComparisonFailure.class)
	public void testAs() {
		// as() is used to describe the test and will be shown before the error message
		assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
	}


	@Test
	public void testThrownBy() {
		// Java 8 exception assertion, standard style ...
		assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
		// ... or BDD style
		Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); });
		assertThat(thrown).hasMessageContaining("boom");
	}

	@Test
	public void testExtracting() {
		// using the 'extracting' feature to check fellowshipOfTheRing character's names (Java 7)
		assertThat(fellowshipOfTheRing).extracting("name")
				.contains("Boromir", "Gandalf", "Frodo", "Legolas");
		// same thing using a Java 8 method reference
		assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName)
				.doesNotContain("Sauron", "Elrond");
		// extracting multiple values at once grouped in tuples (Java 7)
		assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name")
				.contains(tuple("Boromir", 37, "Man"),
						tuple("Sam", 38, "Hobbit"),
						tuple("Legolas", 1000, "Elf"));
	}

	@Test
	public void testFilteredOn() {
		// filtering a collection before asserting in Java 7 ...
		assertThat(fellowshipOfTheRing).filteredOn("race", HOBBIT)
				.containsOnly(sam, frodo, pippin, merry);
		// ... or in Java 8
		assertThat(fellowshipOfTheRing).filteredOn(charactor -> charactor.getName().contains("o"))
				.containsOnly(aragorn, frodo, legolas, boromir);
	}

	@Test
	public void testCombination() {
		// combining filtering and extraction (yes we can)
		assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
				.containsOnly(aragorn, frodo, legolas, boromir)
				.extracting(character -> character.getRace().getName())
				.contains("Hobbit", "Elf", "Man");
	}

}
