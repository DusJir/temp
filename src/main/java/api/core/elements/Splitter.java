package api.core.elements;

import java.util.Objects;

public class Splitter extends Component {

    private final IElement eLeft;
    private final IElement eRight;
    private final IElement eTitle;
    private final IElement eHr;


    Splitter(IElement composite) {
        super(composite);
        setVisible(false);
        eTitle = getHandle(composite.getChildren(), "title");
        eLeft = getHandle(composite.getChildren(), "tleft");
        eRight = getHandle(composite.getChildren(), "tright");
        eHr = getHandle(composite.getChildren(), "hr");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Splitter splitter = (Splitter) o;
        return eLeft.equals(splitter.eLeft) && eRight.equals(splitter.eRight) && eTitle.equals(splitter.eTitle)
                && eHr.equals(splitter.eHr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eLeft, eRight, eTitle, eHr);
    }
}
