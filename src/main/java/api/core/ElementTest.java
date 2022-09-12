package api.core;

import api.core.elements.Element;
import org.testng.annotations.Test;

@Test
public class ElementTest {

    public void testTable() {

        ComponentFactory ef = ComponentFactory.getInstance();

//        Element elm = ef.produce("BROOT");
//        String html = elm.render();
//        System.out.print(html);


        Element selm = ef.produce("BROOT");
        selm.getChildren().get(1).getChildren().get(0).getChildren().get(2).getChildren().get(0).addChildren(ef.produce("td"));
        selm.getChildren().get(1).getChildren().get(0).getChildren().get(2).getChildren().get(0).addChildren(ef.produce("td"));
        selm.getChildren().get(1).getChildren().get(0).getChildren().get(2).getChildren().get(0).addChildren(ef.produce("td"));
        String html = selm.render();
        System.out.print(html);

//        Element tbl = new Element("div")
//                .table()
//                .header()
//                .row()
//                .column()
//                .column()
//                .column()
//                .column()
//                .body()
//                .row()
//                .column()
//                .column()
//                .column()
//                .column()
//                .footer()
//                .row()
//                .column()
//                .column()
//                .column()
//                .column();
//
//        Composite comp = new Composite(tbl);
//        comp.print(comp.getElement());

    }
}
