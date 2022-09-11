package api.core;

import api.core.elements.ElementFactory;
import api.core.elements.composites.Composite;
import api.core.elements.Element;
import api.core.elements.composites.CompositeFactory;
import org.testng.annotations.Test;

@Test
public class ElementTest {

    public void testTable() {
        CompositeFactory cf = CompositeFactory.getInstance();
        ElementFactory ef = ElementFactory.getInstance();

        Element elm = cf.produce("TABLE");
        System.out.println("<div>");
        String html = elm.render();
        System.out.print(html);
        System.out.println("</div>");

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
