package api.core;

import api.core.composites.CRoot;
import api.core.composites.Composite;
import api.core.elements.Element;
import api.core.elements.IElement;

public class ComponentBuilder {
    private static final ComponentFactory factory = ComponentFactory.getInstance();

    public void build() {

        CRoot e = (CRoot) factory.produce("BROOT");



    }
}
