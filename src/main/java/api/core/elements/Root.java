package api.core.elements;

import api.core.attributes.AttributeFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import static api.ReporterUtils.CSS_CONTAINER;

public class Root extends Element implements Comparable<Root>, IComponent, IRoot {
    private final String uuid = UUID.randomUUID().toString();

    public Root(IComponent... components) {
        super(ElementFactory.VIRTUAL.name(), true, Arrays.asList(components), AttributeFactory.CLASS.get(CSS_CONTAINER));
        setVisible(false);
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Override
    public Title title() {
        IComponent cmp = ComponentFactory.TITLE.get();
        addChildren(cmp);
        return (Title) cmp;
    }

    @Override
    public Block block() {
        IComponent cmp = ComponentFactory.BLOCK.get();
        addChildren(cmp);
        return (Block) cmp;
    }

    @Override
    public Splitter splitter() {
        IComponent cmp = ComponentFactory.SPLITTER.get();
        addChildren(cmp);
        return (Splitter) cmp;
    }

    @Override
    public Hr hr() {
        IComponent cmp = ComponentFactory.HR.get();
        addChildren(cmp);
        return (Hr) cmp;
    }

    @Override
    public Master master() {
        IComponent cmp = ComponentFactory.MASTER.get();
        addChildren(cmp);
        return (Master) cmp;
    }

    @Override
    public Detail detail() {
        IComponent cmp = ComponentFactory.DETAIL.get();
        addChildren(cmp);
        return (Detail) cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Root root = (Root) o;
        return uuid.equals(root.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uuid);
    }

    @Override
    public int compareTo(Root o) {
        return this.uuid.equals(o.uuid) ? 0 : 1;
    }
}
