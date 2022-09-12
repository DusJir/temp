package api.core.components;

import api.core.attributes.Attribute;
import api.core.elements.Element;

import java.util.List;

public abstract class Component extends Element {

    protected Component(String key, List<Element> elements, Attribute... attributes) {
        super(key);
        addChildren(elements);
        addAttributes(attributes);
    }
}
