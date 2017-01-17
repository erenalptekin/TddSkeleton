package com.develogical;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RecentlyUsedListTest {
	private final RecentlyUsedList<String> recentlyUsedList = new RecentlyUsedList<>();

	@Test
	public void shouldBeEmptyWhenInitialized() {
		assertThat(recentlyUsedList.size(), equalTo(0));
	}

	@Test
	public void shouldBeAbleToAddToTheList() {
		recentlyUsedList.add("a thing");
		assertThat(recentlyUsedList.size(), equalTo(1));
	}

    @Test
    public void shouldBeAbleToAddOtherTypesToTheList() {
        RecentlyUsedList<Integer> integerRecentlyUsedList = new RecentlyUsedList<>();
        integerRecentlyUsedList.add(32);
        assertThat(integerRecentlyUsedList.size(), equalTo(1));
        assertThat(integerRecentlyUsedList.retrieve(0), equalTo(32));
    }

	@Test
	public void retrieveItems() {
		recentlyUsedList.add("sth");
		assertThat(recentlyUsedList.retrieve(0), equalTo("sth"));
	}

	@Test
	public void theMostRecentItemShouldBeFirstInTheList() {
		recentlyUsedList.add("older");
		recentlyUsedList.add("newer");
		assertThat(recentlyUsedList.retrieve(0), equalTo("newer"));
	}

	@Test
	public void retrievesAllItemsAtTheRightOrder() {
		recentlyUsedList.add("1");
		recentlyUsedList.add("2");
		recentlyUsedList.add("3");
		assertThat(recentlyUsedList.retrieve(0), equalTo("3"));
		assertThat(recentlyUsedList.retrieve(1), equalTo("2"));
		assertThat(recentlyUsedList.retrieve(2), equalTo("1"));
	}

	@Test
	public void retrievesItemsInOrderOfRecentUse() {
		recentlyUsedList.add("1");
		recentlyUsedList.add("2");
		recentlyUsedList.add("3");

		recentlyUsedList.retrieve(1);

		assertThat(recentlyUsedList.retrieve(0), equalTo("2"));
		assertThat(recentlyUsedList.retrieve(1), equalTo("3"));
		assertThat(recentlyUsedList.retrieve(2), equalTo("1"));
	}

	@Test
	public void itemsInTheListAreUnique() {
		recentlyUsedList.add("1");
		recentlyUsedList.add("1");
		assertThat(recentlyUsedList.size(), equalTo(1));
	}

	@Test
	public void itemsThatAlreadyExistAreTreatedAsMostRecentlyUsed() {
		recentlyUsedList.add("1");
		recentlyUsedList.add("2");
		recentlyUsedList.add("3");

		recentlyUsedList.add("2");

		assertThat(recentlyUsedList.retrieve(0), equalTo("2"));
		assertThat(recentlyUsedList.retrieve(1), equalTo("3"));
		assertThat(recentlyUsedList.retrieve(2), equalTo("1"));
	}

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorCase1IndexLessThanZero() {
	    recentlyUsedList.retrieve(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void errorCase2IndexBiggerThanTheListSize() {
        recentlyUsedList.retrieve(111);
    }
}
