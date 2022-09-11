package api.core.elements.composites;

import api.core.elements.Element;

public abstract class Composite extends Element {

    protected Composite(String key, Element... elements) {
        super(key);
        addChildren(elements);
    }
}
