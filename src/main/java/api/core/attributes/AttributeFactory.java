package api.core.attributes;

import api.core.elements.AbstractFactory;
import api.core.elements.Element;
import api.core.elements.ElementFactory;
import api.core.elements.composites.*;

public class AttributeFactory {

//    private final AttributeFactory attributeFactory = AttributeFactory.getInstance();
//
//    private AttributeFactory() {}
//
//    private static class FactoryHolder {
//        private static final AttributeFactory INSTANCE = new AttributeFactory();
//    }
//
//    public static AttributeFactory getInstance() {
//        return AttributeFactory.FactoryHolder.INSTANCE;
//    }
//
//    @Override
//    public Attribute produce(String key) {
//        switch (key) {
//            case "id":
//                return new AId();
//            case "colspan":
//                return new AColspan();
//            case "rowspan":
//                return new ARowspan();
//            case "href":
//                return new AHref();
//            case "class":
//                return new AClass();
//            case "data":
//                return new AData();
//            default:
//                throw new IllegalArgumentException("Element unknown.");
//        }
//    }
}
