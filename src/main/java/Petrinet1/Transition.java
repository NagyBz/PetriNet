package Petrinet1;

public class Transition extends Vertex {

    public Transition(long ID, String name) { super(ID,name); }

    public boolean isFireable()  {
        for ( Arc inputArc : super.getInputArcs()) {

            if(isNormalArc(inputArc)) {
                int weight = ((inputArc).getWeigth());
                int tokens = (((Place) inputArc.getStartPoint()).getTokens());

                if (weight > tokens) {
                    return false;
                }
            }
        }
        return true;
    }

     public void fireTransition(){

        for(Arc arc: super.getInputArcs()){

            if(isNormalArc(arc))
                ((Place)arc.getStartPoint()).removeToken(arc.getWeigth());

            if (isResetArc(arc))
                ((Place)arc.getStartPoint()).removeAllTokens();

        }

        for (Arc arc : super.getOutputArcs()){
            ((Place)arc.getEndPoint()).addToken(arc.getWeigth());
        }
    }

    private boolean isResetArc(Arc arc) {
        return arc.getClass()== ResetArc.class;
    }

    private boolean isNormalArc(Arc arc) {
        return arc.getClass() == NormalArc.class;
    }


}


