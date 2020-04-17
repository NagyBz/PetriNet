package Petrinet1;



public class NormalArc extends Arc {

    public NormalArc(Vertex startPoint, Vertex endPoint, int weigth,long ID) throws SameVertexTypeException, BadArcWeightException {

        super(startPoint, endPoint,weigth,ID);
        if(weigth < 1){
            throw new BadArcWeightException("Weight must be >= 1");
        }


    }

}
