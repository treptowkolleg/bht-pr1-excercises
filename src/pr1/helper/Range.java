package pr1.helper;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

	private final int start, endInclusive;

	public Range(int start, int endInclusive) {
		this.start = start;
		this.endInclusive = endInclusive;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<>() {
			int current = start;

			public boolean hasNext() {
				return current <= endInclusive;
			}

			public Integer next() {
				return current++;
			}
		};
	}

}
