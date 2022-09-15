package api.core.elements;

import api.core.attributes.Attribute;
import api.core.attributes.AttributeFactory;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Supplier;

import static api.ReporterUtils.*;

public enum CompositeFactory implements IFactory<IElement>  {
    HR(() -> new Composite(ElementFactory.HR.name(),
            Collections.emptyList(),
            toSet(ImmutablePair.of(Identifier.generateId("hr"), AttributeFactory.ID)))),
    HOOTER_CELL(() -> new Composite(ElementFactory.TH.name(),
            Collections.emptyList(),
            toSet(ImmutablePair.of(Identifier.generateId("hfcell"), AttributeFactory.ID)))),
    DATA_CELL(() -> new Composite(ElementFactory.TH.name(),
            Collections.emptyList(),
            toSet(ImmutablePair.of(Identifier.generateId("dcell"), AttributeFactory.ID)))),
    TITLE(() -> new Composite(ElementFactory.DIV.name(),
            toList(ElementFactory.H3),
            toSet(ImmutablePair.of(CSS_SUBTITLE, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("title"), AttributeFactory.ID)))),
    HEADER_ROW(() -> new Composite(ElementFactory.TR.name(),
            toList(CompositeFactory.HOOTER_CELL),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("hrow"), AttributeFactory.ID))))),
    FOOTER_ROW(() -> new Composite(ElementFactory.TR.name(),
            toList(CompositeFactory.HOOTER_CELL),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("frow"), AttributeFactory.ID))))),
    DATA_ROW(() -> new Composite(ElementFactory.TR.name(),
            toList(CompositeFactory.DATA_CELL),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("drow"), AttributeFactory.ID))))),
    HEADER(() -> new Composite(ElementFactory.THEAD.name(),
            toList(CompositeFactory.HEADER_ROW),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("header"), AttributeFactory.ID))))),
    DATA(() -> new Composite(ElementFactory.TBODY.name(),
            toList(CompositeFactory.DATA_ROW),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("data"), AttributeFactory.ID))))),
    FOOTER(() -> new Composite(ElementFactory.TFOOT.name(),
            toList(CompositeFactory.FOOTER_ROW),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("footer"), AttributeFactory.ID))))),
    TABLE(() -> new Composite(ElementFactory.TABLE.name(),
            toList(ElementFactory.CAPTION, CompositeFactory.HEADER, CompositeFactory.DATA, CompositeFactory.FOOTER),
            toSet(ImmutablePair.of(ImmutablePair.of(Identifier.generateId("table"), AttributeFactory.ID))))),
    TABLE_LEFT(() -> new Composite(ElementFactory.TABLE.name(),
            toList(ElementFactory.CAPTION, CompositeFactory.HEADER, CompositeFactory.DATA, CompositeFactory.FOOTER),
            toSet(ImmutablePair.of(CSS_HALF_LEFT, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("tleft"), AttributeFactory.ID)))),
    TABLE_RIGHT(() -> new Composite(ElementFactory.TABLE.name(),
            toList(ElementFactory.CAPTION, CompositeFactory.HEADER, CompositeFactory.DATA, CompositeFactory.FOOTER),
            toSet(ImmutablePair.of(CSS_HALF_RIGHT, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("tright"), AttributeFactory.ID)))),
    BLOCK(() -> new Composite(ElementFactory.DIV.name(),
            toList(CompositeFactory.TITLE, CompositeFactory.TABLE, CompositeFactory.HR),
            toSet(ImmutablePair.of(CSS_BLOCK, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("block"), AttributeFactory.ID)))),
    SPLITTER((() -> new Composite(ElementFactory.DIV.name(),
            toList(CompositeFactory.TITLE, CompositeFactory.TABLE_LEFT, CompositeFactory.TABLE_RIGHT, CompositeFactory.HR),
            toSet(ImmutablePair.of(CSS_SPLITTER, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("splitter"), AttributeFactory.ID))))),
    MASTER((() -> new Composite(ElementFactory.DIV.name(),
            toList(CompositeFactory.BLOCK, CompositeFactory.HR),
            toSet(ImmutablePair.of(CSS_MASTER, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("master"), AttributeFactory.ID))))),
    DETAIL((() -> new Composite(ElementFactory.DIV.name(),
            toList(CompositeFactory.TITLE, CompositeFactory.SPLITTER, CompositeFactory.HR, CompositeFactory.BLOCK, CompositeFactory.BLOCK, CompositeFactory.HR),
            toSet(ImmutablePair.of(CSS_DETAIL, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("detail"), AttributeFactory.ID))))),
    MASTER_DETAIL((() -> new Composite(ElementFactory.DIV.name(),
            toList(CompositeFactory.MASTER, CompositeFactory.DETAIL),
            toSet(ImmutablePair.of(CSS_DETAIL, AttributeFactory.CLASS), ImmutablePair.of(Identifier.generateId("master-detail"), AttributeFactory.ID)))));

    private final Supplier<IElement> producer;

    CompositeFactory(Supplier<IElement> producer) {
        this.producer = producer;
    }

    public IElement get() {
        return get(EMPTY);
    }

    @Override
    public IElement get(String value) {
        return producer.get();
    }

    @SafeVarargs
    private static Set<Attribute> toSet(Pair<String, IFactory<Attribute>>... pairs) {
        Set<Attribute> attributes = new LinkedHashSet<>();
        for (Pair<String, IFactory<Attribute>> pair : pairs) {
            attributes.add(pair.getRight().get(pair.getLeft()));
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

    private static class Identifier {
        private static final Map<String, Integer> counter = new HashMap<>();

        private static String generateId(String key) {
            int  cnt = counter.getOrDefault(key, 0) + 1;
            String id = String.format("%s[%s]", key, cnt);
            counter.put(key, cnt);
            return id;
        }
    }
}
