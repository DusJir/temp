package api.core;

import api.core.attributes.Attribute;
import api.core.composites.*;
import api.core.elements.*;

public class ComponentFactory implements IFactory {

    private ComponentFactory() {}

    private static class FactoryHolder {
        private static final ComponentFactory INSTANCE = new ComponentFactory();
    }

    public static ComponentFactory getInstance() {
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
            case "BROOT":
                return new CRoot(getElement("TITLE"), getElement("BLOCK"), getElement("hr"));
            case "SROOT":
                return new CRoot(getElement("TITLE"), getElement("SPLITTER"), getElement("hr"));
            case "BLOCK":
                return new CBlock(getElement("TABLE"));
            case "SPLITTER":
                return new CSplitter(getElement("TABLE"), getElement("TABLE"));
            case "TITLE":
                return new CTitle(getElement("h3"));
            case "TABLE_ROW":
                return new CRow(getElement("td"));
            case "TABLE_HROW":
                return new CRow(getElement("th"));
            case "TABLE_HEADER":
                return new CHeader(getElement("TABLE_HROW"));
            case "TABLE_DATA":
                return new CData(getElement("TABLE_ROW"));
            case "TABLE_FOOTER":
                return new CFooter(getElement("TABLE_HROW"));
            case "TABLE":
                return new CTable(getElement("caption"), getElement("TABLE_HEADER"),
                        getElement("TABLE_DATA"), getElement("TABLE_FOOTER"));
            default:
                throw new IllegalArgumentException("Element unknown.");
        }
    }

    private Element getElement(String key) {
        return this.produce(key);
    }

}
