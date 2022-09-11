package api.core.elements.composites;

import api.core.elements.Element;

import java.util.UUID;

public class CRoot extends Composite {

    public CRoot(Element...elements) {
        super("div class=\"container\"", elements);
    }

}
