package api.core.elements;

import api.core.attributes.Attribute;

public class ElementFactory implements AbstractFactory {

    private ElementFactory() {}

    private static class FactoryHolder {
        private static final ElementFactory INSTANCE = new ElementFactory();
    }

    public static ElementFactory getInstance() {
        return FactoryHolder.INSTANCE;
    }

    @Override
    public Element produce(String key) {
        switch (key) {
            case "div":
                return new EDiv();
            case "hr":
                return new EHr();
            case "table":
                return new ETable();
            case "caption":
                return new ECaption();
            case "thead":
                return new EThead();
            case "tbody":
                return new ETbody();
            case "tfoot":
                return new ETfoot();
            case "tr":
                return new ETr();
            case "td":
                return new ETd();
            case "th":
                return new ETh();
            case "h1":
                return new EH1();
            case "h2":
                return new EH2();
            case "h3":
                return new EH3();
            default:
                throw new IllegalArgumentException("Element unknown.");
        }
    }

}
