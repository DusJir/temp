package api.core.elements.composites;

import api.core.elements.Element;

import java.util.UUID;

public class CRow extends Composite {

    public CRow(Element...elements) {
        super("tr", elements);
    }

}
