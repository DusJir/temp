package api.core.elements;

import java.util.function.Supplier;

import static api.ReporterUtils.EMPTY;

public enum ComponentFactory implements IFactory<IComponent> {
    TABLE(() -> new Table(CompositeFactory.TABLE.get())),
    HR(() -> new Hr(CompositeFactory.HR.get())),
    TITLE(() -> new Title(CompositeFactory.TITLE.get())),
    BLOCK(() -> new Block(CompositeFactory.BLOCK.get())),
    SPLITTER(() -> new Splitter(CompositeFactory.SPLITTER.get())),
    MASTER(() -> new Master(CompositeFactory.MASTER.get())),
    DETAIL(() -> new Detail(CompositeFactory.DETAIL.get())),
    MASTER_DETAIL(() -> new MasterDetail(CompositeFactory.MASTER_DETAIL.get()));

    private final Supplier<IComponent> producer;

    ComponentFactory(Supplier<IComponent> producer) {
        this.producer = producer;
    }

    public IComponent get() {
        return get(EMPTY);
    }

    @Override
    public IComponent get(String value) {
        return producer.get();
    }
}
