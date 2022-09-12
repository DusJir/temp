package api.core.composites;

import api.core.attributes.AClass;
import api.core.elements.Element;

public class CTitle extends Composite {

    public CTitle(Element...elements) {
        super("div", elements);
        addAttributes(new AClass("subtitle"));
    }

}
