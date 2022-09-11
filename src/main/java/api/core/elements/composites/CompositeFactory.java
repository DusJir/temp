package api.core.elements.composites;

import api.core.elements.AbstractFactory;
import api.core.elements.Element;
import api.core.elements.ElementFactory;

public class CompositeFactory implements AbstractFactory {

    private final ElementFactory elementFactory = ElementFactory.getInstance();

    private CompositeFactory() {}

    private static class FactoryHolder {
        private static final CompositeFactory INSTANCE = new CompositeFactory();
    }

    public static CompositeFactory getInstance() {
        return CompositeFactory.FactoryHolder.INSTANCE;
    }

    private Element getElement(String key) {
        return elementFactory.produce(key);
    }

    private Element getComposite(String key) {
        return this.produce(key);
    }

    @Override
    public Element produce(String key) {
        switch (key) {
            case "ROOT":
                return new CRoot();
            case "BLOCK":
                return new CBlock();
            case "SPLITTER":
                return new CSplitter();
            case "TITLE":
                return new CTitle(getElement("h3"));
            case "TABLE_ROW":
                return new CRow(getElement("td"));
            case "TABLE_HROW":
                return new CRow(getElement("th"));
            case "TABLE_HEADER":
                return new CHeader(getComposite("TABLE_HROW"));
            case "TABLE_DATA":
                return new CData(getComposite("TABLE_ROW"));
            case "TABLE_FOOTER":
                return new CFooter(getComposite("TABLE_HROW"));
            case "TABLE":
                return new CTable(getElement("caption"), getComposite("TABLE_HEADER"),
                        getComposite("TABLE_DATA"), getComposite("TABLE_FOOTER"));

            default:
                throw new IllegalArgumentException("Element unknown.");
        }
    }
}
