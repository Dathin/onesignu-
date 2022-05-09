package io.github.dathin.onesignup.model.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Data {

    @NotBlank
    @Size(max = 50)
    @Pattern(regexp="^[a-zA-Z0-9]*$")
    private String key;

    @Size(max = 50)
    @Pattern(regexp="^[a-zA-Z0-9]*$")
    private String tag;

    @NotBlank
    @Size(max = 500)
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
