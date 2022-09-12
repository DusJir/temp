package api.core.attributes;

import api.core.elements.IElement;
import api.core.elements.Renderable;

import java.util.Objects;

import static api.ReporterUtils.*;

public abstract class Attribute implements IElement, Comparable<Attribute>, Renderable {
    private final String key;
    private final String value;

    protected Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getValue() {
        return getOrDefault(this.value, EMPTY);
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
