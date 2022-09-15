package api.core.elements;

public interface IRoot extends IElement {
    Title title();
    Block block();
    Splitter splitter();
    Hr hr();
    Master master();
    Detail detail();
}
