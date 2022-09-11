package api.core.elements.composites;

import api.core.elements.Element;

import java.util.UUID;

public class CSplitter extends Composite {

    public CSplitter(Element...elements) {
        super("div class=\"splitter\"", elements);
    }

}
