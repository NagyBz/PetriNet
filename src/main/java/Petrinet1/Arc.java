package Petrinet1;

public abstract class Arc {

    private int weigth;
    private Vertex startPoint;
    private Vertex endPoint;
    private long ID;

     Arc(Vertex startPoint, Vertex endPoint,int weigth,Long ID) throws SameVertexTypeException {

        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weigth=weigth;
         this.ID=ID;

        if (startPoint.getClass().getName()==endPoint.getClass().getName()){
            throw new SameVertexTypeException("Between same Vertex types cannot be put an Arc ");
        }

        if(startPoint instanceof Transition){
            ((Transition) startPoint).putOutputArc(this);
            ((Place)endPoint).putInputArc(this);
        }

        if(endPoint instanceof Transition){
            ((Transition) endPoint).putInputArc(this);
            ((Place)startPoint).putOutputArc(this);
        }

    }


    public Vertex getStartPoint() {
        return startPoint;
    }

    public Vertex getEndPoint() {return endPoint; }

    public int getWeigth() {
        return weigth;
    }

    public long getID() {
        return ID;
    }
}
