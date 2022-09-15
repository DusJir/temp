package api.core.elements;

import java.util.Objects;

public class Block extends Component  {

    private final IElement eTable;
    private final IElement eTitle;
    private final IElement eHr;


    Block(IElement composite) {
        super(composite);
        setVisible(false);
        eTitle = ((Element) composite).findHandle("div").findHandle().findHandle("h3");
        eTable = ((Composite) composite).getHandle("table:table");
        eHr = ((Composite) composite).getHandle("hr:hr");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Block block = (Block) o;
        return eTable.equals(block.eTable) && eTitle.equals(block.eTitle) && eHr.equals(block.eHr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eTable, eTitle, eHr);
    }
}
