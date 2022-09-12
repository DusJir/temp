package api.core.composites;

import api.core.ComponentFactory;
import api.core.attributes.AClass;
import api.core.elements.Element;
import api.core.elements.IElement;

public class CRoot extends Composite {

    public CRoot(Element...elements) {
        super("div", elements);
        addAttributes(new AClass("container"));
    }

    public IElement block() {
        return ComponentFactory.getInstance().produce("BLOCK");
    }

    public IElement splitter() {
        return ComponentFactory.getInstance().produce("SPLITTER");
    }
}
