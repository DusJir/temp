package api.core.components;

import api.core.elements.Element;

public abstract class CPTable extends Element {

    protected CPTable(Element... elements) {
        super("table");
        addChildren(elements);
    }
}
