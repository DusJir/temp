package api.core;

import api.core.composites.CompositeFactory;
import api.core.elements.ElementFactory;
import api.core.elements.IElement;
import org.testng.annotations.Test;

@Test
public class ElementTest {

    public void testTable() {

        IElement selm = CompositeFactory.ROOT.get();
        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
        String html = selm.render();
        System.out.print(html);

    }
}
