package Generated;
import Petrinet1.*;
import Petrinet1.Place;
import Petrinet1.Transition;
import Petrinet1.NormalArc;


public class PetrinetTransformer extends Transformer <PetriNet> {

    PetriNet net;

    public PetrinetTransformer(PetriNet net) {
        this.net = net;
    }

    public PetriNet transform(Document document) throws SameVertexTypeException, BadArcWeightException, IllegalStartVertexResetArcException {


        for(Generated.Place place: document.getPlace()){
             Place place1 =new Place(
                     place.getTokens(),
                     place.getId(),
                     place.getLabel());
             net.addPlace(place1);
        }

        for (Generated.Transition transition :document.getTransition()){

            Transition transition1=new Transition(
                    transition.getId(),
                    transition.getLabel()
            );
            net.addTransition(transition1);

        }

        for (Generated.Arc arc : document.getArc()){
           if(arc.type.matches("regular")){

                   if (net.places.get((long) arc.sourceId) != null) {

                       NormalArc normalArc = new NormalArc(
                               net.places.get((long) (arc.sourceId)),
                               net.trasitions.get((long) (arc.destinationId)),
                               (int) (arc.getMultiplicity()),
                               (long) arc.id
                       );
                       net.addArc(normalArc);
                   } else {
                       NormalArc normalArc = new NormalArc(
                               net.trasitions.get((long) (arc.sourceId)),
                               net.places.get((long) (arc.destinationId)),
                               (int) (arc.getMultiplicity()),
                               (long) arc.id
                       );
                       net.addArc(normalArc);
                   }

           }
            if(arc.type.matches("reset")){
                if(net.places.get((long)arc.sourceId)!= null){

                    ResetArc resetArc=new ResetArc(
                            net.places.get((long)(arc.sourceId)),
                            net.trasitions.get((long)(arc.destinationId)),
                            arc.getId()
                    );
                    net.addArc(resetArc);
                }
                else{
                    ResetArc resetArc =new ResetArc(
                            net.trasitions.get((long)(arc.sourceId)),
                            net.places.get((long)(arc.destinationId)),
                           arc.getId()
                    );
                    net.addArc(resetArc);
                }
            }
        }

        return net;
    }
}
