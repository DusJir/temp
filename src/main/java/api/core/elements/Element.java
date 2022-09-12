package api.core.elements;

import api.core.attributes.Attribute;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static api.ReporterUtils.*;

public abstract class Element implements IElement {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String key;
    private final boolean pair;
    private IElement parent;
    private final List<IElement> children = new LinkedList<>();
    private final Set<Attribute> attributes = new LinkedHashSet<>();

    protected Element(String key, boolean pair) {
        this(key, pair, Collections.emptyList());
    }

    protected Element(String key, boolean pair, List<IElement> elements, Attribute... attributes) {
        this.key = key.toLowerCase();
        this.pair = pair;
        this.children.addAll(elements);
        this.attributes.addAll(Arrays.asList(attributes));
    }

    @Override
    public void addChildren(IElement... elements) {
        addChildren(Arrays.asList(elements));
    }

    public void addChildren(List<IElement> elements) {
        for(IElement element : elements) {
            element.setParent(this);
            this.children.add(element);
        }
    }

    protected void addAttributes(Set<Attribute> attributes) {
        this.attributes.addAll(attributes);
    }

    @Override
    public Set<Attribute> getAttributes() {
        return this.attributes;
    }

    @Override
    public void setParent(IElement parent) {
        this.parent = parent;
    }

    @Override
    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public boolean isRoot() {
        return this.parent == null;
    }

    @Override
    public int getDepth() {
        return isRoot() ? 1 : getParent().getDepth() + 1;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public IElement getParent() {
        return this.parent;
    }

    @Override
    public List<IElement> getChildren() {
        return this.children;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(CRLF).append(indent(this.getDepth())).append(left());
        children.forEach(e -> sb.append(e.render()));
        sb.append(right());

        return sb.toString();
    }

    private String left() {
        StringBuilder sb = new StringBuilder();
        this.attributes.forEach(e -> sb.append(e.render()));
        return String.format("<%s%s>", this.key, sb);
    }

    private String right() {
        if (!this.pair) {
            return EMPTY;
        }
        return isLeaf() ?
                String.format("</%s>", this.key) :
                CRLF + indent(this.getDepth()) + String.format("</%s>", this.key);
    }

    public static String indent(int depth, int offset) {
        return StringUtils.leftPad(SPACE, 3 * (depth + offset));
    }

    public static String indent(int depth) {
        return indent(depth, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return key.equals(element.key) && Objects.equals(parent, element.parent) && children.equals(element.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, children);
    }
}
