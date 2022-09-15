package api.core.elements;

import api.core.attributes.Attribute;

import java.util.*;

public final class Composite extends Element {

    Composite(String key, List<IElement> elements, Set<Attribute> attributes) {
        super(key, true);
        addChildren(elements);
        addAttributes(attributes);
    }
}
