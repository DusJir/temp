package api.core.composites;

import api.core.attributes.AClass;
import api.core.elements.Element;

public class CSplitter extends Composite {

    public CSplitter(Element...elements) {
        super("div", elements);
        addAttributes(new AClass("splitter"));
    }

}
