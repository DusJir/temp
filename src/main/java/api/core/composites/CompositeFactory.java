package api.core.composites;

import api.core.attributes.Attribute;
import api.core.attributes.AttributeFactory;
import api.core.elements.ElementFactory;
import api.core.elements.IElement;
import api.core.elements.IFactory;

import java.util.*;
import java.util.function.BiFunction;

import static api.ReporterUtils.EMPTY;

public enum CompositeFactory implements IFactory<IElement> {
    TITLE((elms, attr) -> new Composite(ElementFactory.DIV.name(), toList(ElementFactory.H3), toSet("subtitle", AttributeFactory.CLASS))),
    HEADER_ROW((elms, attr) -> new Composite(ElementFactory.TR.name(), toList(ElementFactory.TH), attr)),
    FOOTER_ROW((elms, attr) -> new Composite(ElementFactory.TR.name(), toList(ElementFactory.TH), attr)),
    DATA_ROW((elms, attr) -> new Composite(ElementFactory.TR.name(), toList(ElementFactory.TD), attr)),
    HEADER((elms, attr) -> new Composite(ElementFactory.THEAD.name(), toList(CompositeFactory.HEADER_ROW), attr)),
    DATA((elms, attr) -> new Composite(ElementFactory.TBODY.name(), toList(CompositeFactory.DATA_ROW), attr)),
    FOOTER((elms, attr) -> new Composite(ElementFactory.TFOOT.name(), toList(CompositeFactory.FOOTER_ROW), attr)),
    TABLE((elms, attr) -> new Composite(ElementFactory.TABLE.name(), toList(ElementFactory.CAPTION, CompositeFactory.HEADER,
            CompositeFactory.DATA, CompositeFactory.FOOTER), attr)),
    ROOT((elms, attr) -> new Composite(ElementFactory.DIV.name(), toList(CompositeFactory.TITLE, CompositeFactory.TABLE),
            toSet("container", AttributeFactory.CLASS))),
    BLOCK((elms, attr) -> new Composite(ElementFactory.DIV.name(), toList(CompositeFactory.TITLE, CompositeFactory.TABLE,
            ElementFactory.HR), toSet("block", AttributeFactory.CLASS))),
    SPLITTER(((elms, attr) -> new Composite(ElementFactory.DIV.name(), toList(CompositeFactory.TITLE, CompositeFactory.TABLE,
            ElementFactory.HR), toSet("splitter", AttributeFactory.CLASS))));

    private final BiFunction<List<IElement>, Set<Attribute>, IElement> producer ;

    CompositeFactory(BiFunction<List<IElement>, Set<Attribute>, IElement> producer) {
        this.producer = producer;
    }

    public BiFunction<List<IElement>, Set<Attribute>, IElement> getProducer() {
        return this.producer;
    }

    @SafeVarargs
    private static Set<Attribute> toSet(String value, IFactory<Attribute>... factories) {
        Set<Attribute> attributes = new LinkedHashSet<>();
        for (IFactory<Attribute> factory : factories) {
            attributes.add(factory.get(value));
        }
        return attributes;
    }


    @SafeVarargs
    private static List<IElement> toList(IFactory<IElement>...factories) {
        List<IElement> elements = new ArrayList<>();
        for (IFactory<IElement> factory : factories) {
            elements.add(factory.get());
        }
        return elements;
    }

    @Override
    public IElement get() {
        return get(EMPTY);
    }

    @Override
    public IElement get(String value) {
        return this.producer.apply(Collections.emptyList(), Collections.emptySet());
    }
}
