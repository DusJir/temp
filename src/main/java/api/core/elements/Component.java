package api.core.elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

import static api.ReporterUtils.EMPTY;

public abstract class Component extends Element implements Comparable<IComponent>, IComponent {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Component.class);
    private final String uuid = UUID.randomUUID().toString();

    Component(IElement composite) {
        super(EMPTY, false, Collections.singletonList(composite));
        setVisible(false);
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Component component = (Component) o;
        return uuid.equals(component.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uuid);
    }

    @Override
    public int compareTo(IComponent o) {
        return this.uuid.equals(o.getUuid()) ? 0 : 1;
    }
}
