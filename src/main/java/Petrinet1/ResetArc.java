package Petrinet1;

public class ResetArc extends Arc {


    public ResetArc(Vertex startPoint, Vertex endPoint,long ID) throws IllegalStartVertexResetArcException, SameVertexTypeException {
        super( startPoint, endPoint,0,ID);
        if (isTransition(startPoint)){
            throw new IllegalStartVertexResetArcException("Startpoint of Reset Arc cannot be a Transition");
        }
    }


    private boolean isTransition(Vertex startPoint) {
        return startPoint.getClass()== Transition.class;
    }


}
