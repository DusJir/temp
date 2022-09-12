package api.core.composites;

import api.core.attributes.Attribute;
import api.core.elements.Element;
import api.core.elements.IElement;

import java.util.List;
import java.util.Set;

public class Composite extends Element {

    protected Composite(String key, List<IElement> elements, Set<Attribute> attributes) {
        super(key, true);
        addChildren(elements);
        addAttributes(attributes);
    }
}
