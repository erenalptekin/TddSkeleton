package com.develogical;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RecentlyUsedListTest {
	@Test
	public void shouldBeEmptyWhenInitialized() {
		assertThat(new RecentlyUsedList().size(), equalTo(0));
	}

	@Test
	public void shouldBeAbleToAddToTheList() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("a thing");
		assertThat(recentlyUsedList.size(), equalTo(1));
	}

	@Test
	public void retrieveItems() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("sth");
		assertThat(recentlyUsedList.retrieve(0), equalTo("sth"));
	}

	@Test
	public void theMostRecentItemShouldBeFirstInTheList() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("older");
		recentlyUsedList.add("newer");
		assertThat(recentlyUsedList.retrieve(0), equalTo("newer"));
	}

	@Test
	public void retrievesAllItemsAtTheRightOrder() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("1");
		recentlyUsedList.add("2");
		recentlyUsedList.add("3");
		assertThat(recentlyUsedList.retrieve(0), equalTo("3"));
		assertThat(recentlyUsedList.retrieve(1), equalTo("2"));
		assertThat(recentlyUsedList.retrieve(2), equalTo("1"));
	}

	@Test
	public void retrievesItemsInOrderOfRecentUse() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
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
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("1");
		recentlyUsedList.add("1");
		assertThat(recentlyUsedList.size(), equalTo(1));
	}

	@Test
	public void itemsThatAlreadyExistAreTreatedAsMostRecentlyUsed() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("1");
		recentlyUsedList.add("2");
		recentlyUsedList.add("3");

		recentlyUsedList.add("2");

		assertThat(recentlyUsedList.retrieve(0), equalTo("2"));
		assertThat(recentlyUsedList.retrieve(1), equalTo("3"));
		assertThat(recentlyUsedList.retrieve(2), equalTo("1"));
	}
}
