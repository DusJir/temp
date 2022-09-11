package api.core.attributes;

import api.core.elements.Renderable;

import java.util.Objects;

import static api.ReporterUtils.*;

public abstract class Attribute implements Comparable<Attribute>, Renderable {
    private final String key;
    private String value;

    protected Attribute(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return getOrDefault(this.value, EMPTY);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String render() {
        return isNotEmpty(this.value) ? String.format(" %s=\"%s\"", this.key, this.value) : EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return key.equals(attribute.key) && value.equals(attribute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public int compareTo(Attribute o) {
        return (key.equals(o.key) && value.equals(o.value)) ? 0 : 1;
    }
}
