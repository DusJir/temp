package api.core;

import api.core.elements.IElement;

public interface IFactory {
    IElement produce(String key);
}
