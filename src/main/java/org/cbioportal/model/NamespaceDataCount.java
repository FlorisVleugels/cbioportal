package org.cbioportal.model;

import java.io.Serializable;
import java.util.Objects;

public class NamespaceDataCount implements Serializable {

    private String value;
    private Integer count;
    private Integer uniqueCount;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUniqueCount() { return uniqueCount; }

    public void setUniqueCount(Integer uniqueCount) { this.uniqueCount = uniqueCount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamespaceDataCount that = (NamespaceDataCount) o;
        return Objects.equals(value, that.value) && Objects.equals(count, that.count) && Objects.equals(uniqueCount, that.uniqueCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, count, uniqueCount);
    }
}