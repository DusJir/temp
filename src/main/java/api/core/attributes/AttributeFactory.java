package api.core.attributes;

import api.core.elements.IFactory;

import java.util.function.Function;

import static api.ReporterUtils.EMPTY;

public enum AttributeFactory implements IFactory<Attribute> {
    ID(val -> new Attribute("id", val)),
    CLASS(val -> new Attribute("class", val)),
    ROWSPAN(val -> new Attribute("rowspan", val)),
    COLSPAN(val -> new Attribute("colspan", val)),
    HREF(val -> new Attribute("href", val)),
    DATA(val -> new Attribute("data-holder", val));

    private final Function<String, Attribute> producer;

    AttributeFactory(Function<String, Attribute> producer) {
        this.producer = producer;
    }

    public Function<String, Attribute> getProducer() {
        return this.producer;
    }

    @Override
    public Attribute get() {
        return new Attribute(EMPTY, EMPTY);
    }

    public Attribute get(String value) {
        return producer.apply(value);
    }
}
