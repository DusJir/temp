package api.core.elements;

import api.core.attributes.Attribute;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static api.ReporterUtils.*;

public abstract class Element implements IElement {
    private final String key;
    private final boolean pair;
    private IElement parent;
    private boolean isVisible = true;
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
    public IElement findHandle(String key) {
        if (this.getChildren().isEmpty()) {
            return null;
        }
        return getChildren().stream().filter(f -> f.getKey().equals(key)).findFirst().orElse(null);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(left());
        children.forEach(e -> sb.append(e.render()));
        sb.append(right());
        return sb.toString();
    }

    protected void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    protected boolean isPair() {
        return this.pair;
    }

    private String left() {
        if (!isVisible) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        this.attributes.forEach(e -> sb.append(e.render()));
        return String.format("%s%s<%s%s>", CRLF, indent(this.getDepth()), this.key, sb);
    }

    private String right() {
        if (!this.pair || !isVisible) {
            return EMPTY;
        }
        return isLeaf() ?
                String.format("</%s>", this.key) :
                String.format("%s%s</%s>", CRLF, indent(this.getDepth()), this.key);
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
        return key.equals(element.key) && Objects.equals(parent, element.parent) && children.size() == element.children.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, children);
    }
}
