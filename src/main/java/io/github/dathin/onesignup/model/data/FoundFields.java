package io.github.dathin.onesignup.model.data;

import java.util.List;
import java.util.Set;

public class FoundFields {

    private Set<String> notFoundFields;

    private List<DataExplained> list;

    public Set<String> getNotFoundFields() {
        return notFoundFields;
    }

    public void setNotFoundFields(Set<String> notFoundFields) {
        this.notFoundFields = notFoundFields;
    }

    public List<DataExplained> getList() {
        return list;
    }

    public void setList(List<DataExplained> list) {
        this.list = list;
    }
}
