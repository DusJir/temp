package api.core.elements;

public class Title extends Component {

    private final IElement eDiv;
    private final IElement eH3;


    Title(IElement composite) {
        super(composite);
        eDiv = ((Composite) composite).getHandle("div:title");
        eH3 = getHandle(composite.getChildren(), "div");
    }
}