package io.github.dathin.onesignup.model.data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class PatchDataRequest {

	@Valid
	@NotEmpty
	@Size(max = 25)
	public List<Data> data;

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

}
