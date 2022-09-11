package api.core.elements.composites;

import api.core.elements.Element;

import java.util.UUID;

public class CTitle extends Composite {

    public CTitle(Element...elements) {
        super("div class=\"subtitle\"", elements);
    }

}
