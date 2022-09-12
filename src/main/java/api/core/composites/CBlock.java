package api.core.composites;

import api.core.attributes.AClass;
import api.core.elements.Element;

public class CBlock extends Composite {

    public CBlock(Element...elements) {
        super("div", elements);
        addAttributes(new AClass("block"));
    }
}
