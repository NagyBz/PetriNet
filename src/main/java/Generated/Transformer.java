package Generated;

import Petrinet1.BadArcWeightException;
import Petrinet1.IllegalStartVertexResetArcException;
import Petrinet1.SameVertexTypeException;

public abstract class Transformer<T> {

public abstract T transform(Document document) throws SameVertexTypeException, BadArcWeightException, IllegalStartVertexResetArcException;

}