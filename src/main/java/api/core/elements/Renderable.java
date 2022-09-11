package api.core.elements;

@FunctionalInterface
public interface Renderable {
    String render();

    static Renderable empty() {
        return () -> "";
    }
}
