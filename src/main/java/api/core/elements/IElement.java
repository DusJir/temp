package api.core.elements;

import api.core.attributes.Attribute;

import java.util.List;
import java.util.Set;

public interface IElement extends Renderable {
    String getKey();
    void addChildren(IElement... elements);
    Set<Attribute> getAttributes();
    boolean isLeaf();
    boolean isRoot();
    int getDepth();
    IElement getParent();
    void setParent(IElement parent);
    List<IElement> getChildren();
}
