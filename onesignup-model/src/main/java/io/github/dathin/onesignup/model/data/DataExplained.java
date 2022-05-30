package io.github.dathin.onesignup.model.data;

import java.util.Objects;

public class DataExplained extends Data {

	private String keyExplained;

	private String tagExplained;

	public String getKeyExplained() {
		return keyExplained;
	}

	public void setKeyExplained(String keyExplained) {
		this.keyExplained = keyExplained;
	}

	public String getTagExplained() {
		return tagExplained;
	}

	public void setTagExplained(String tagExplained) {
		this.tagExplained = tagExplained;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DataExplained that = (DataExplained) o;
		return Objects.equals(keyExplained, that.keyExplained) && Objects.equals(tagExplained, that.tagExplained);
	}

	@Override
	public int hashCode() {
		return Objects.hash(keyExplained, tagExplained);
	}

}
