package api.core.elements;

import java.util.function.Supplier;

import static api.ReporterUtils.EMPTY;

public enum ElementFactory implements IFactory<IElement> {
    DIV(() -> new Tag("div", true)),
    H1(() -> new Tag("h1", true)),
    H2(() -> new Tag("h2", true)),
    H3(() -> new Tag("h3", true)),
    HR(() -> new Tag("hr", false)),
    TABLE(() -> new Tag("table", true)),
    CAPTION(() -> new Tag("caption", true)),
    THEAD(() -> new Tag("thead", true)),
    TBODY(() -> new Tag("tbody", true)),
    TFOOT(() -> new Tag("tfoot", true)),
    TR(() -> new Tag("tr", true)),
    TD(() -> new Tag("td", true)),
    TH(() -> new Tag("th", true));

    private final Supplier<IElement> producer;

    ElementFactory(Supplier<IElement> producer) {
        this.producer = producer;
    }

    public Supplier<IElement> getProducer() {
        return this.producer;
    }

    public IElement get() {
        return get(EMPTY);
    }

    @Override
    public IElement get(String value) {
        return producer.get();
    }
}
