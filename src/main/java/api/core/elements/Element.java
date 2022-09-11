package api.core.elements;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static api.ReporterUtils.CRLF;
import static api.ReporterUtils.SPACE;

public abstract class Element implements IElement {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String key;
    private Element parent;
    private final String id;
    private final Set<Element> children = new LinkedHashSet<>();
   // private final Set<Attribute> attributes = new LinkedHashSet<>();

    protected Element(String key) {
        this.key = key;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    protected Element addChildren(Element... elements) {
        for(Element element : elements) {
            element.setParent(this);
            this.children.add(element);
        }
        return this;
    }

    protected Element setParent(Element parent) {
        this.parent = parent;
        return this;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public int getDepth() {
        return isRoot() ? 1 : getParent().getDepth() + 1;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    public Element getParent() {
        return this.parent;
    }

    public Set<Element> getChildren() {
        return this.children;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(CRLF).append(indent(this.getDepth())).append(left());
        children.forEach(e -> sb.append(e.render()));
        String content = isLeaf() ? this.id + right() : CRLF + indent(this.getDepth()) + right();
        sb.append(content);

        return sb.toString();
    }

    private String left() { return String.format("<%s>", this.key); }

    private String right() {
        return String.format("</%s>", this.key);
    }

    public static String indent(int depth, int offset) {
        return StringUtils.leftPad(SPACE, 3 * (depth + offset));
    }

    public static String indent(int depth) {
        return indent(depth, 0);
    }


//    public Element header() {
//        Element element = new Element("thead");
//        this.setMeAsParentTo(element);
//        return element;
//    }
//
//    public Element body() {
//        Element element = new Element("tbody");
//        this.setMeAsParentTo(element);
//        return element;
//    }
//
//    public Element footer() {
//        Element element = new Element("tfoot");
//        this.setMeAsParentTo(element);
//        return element;
//    }
//
//    public Element row() {
//        Element element = new Element("tr");
//        this.setMeAsParentTo(element);
//        return element;
//    }
//
//    public Element column() {
//        Element element = new Element("td");
//        this.setMeAsParentTo(element);
//        return element;
//    }
//
//    public Element table() {
//        Element element = new Element("table");
//        this.setMeAsParentTo(element);
//        return element;
//    }

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
