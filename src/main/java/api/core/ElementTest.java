package api.core;

import api.core.elements.*;
import org.testng.annotations.Test;

@Test
public class ElementTest {

    public void testTable() {

        IRoot rt = new Root(ComponentFactory.SPLITTER.get());
//        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
//        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
//        selm.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChildren(ElementFactory.TD.get());
        String html = rt.render();
        System.out.print(html);

    }
}
