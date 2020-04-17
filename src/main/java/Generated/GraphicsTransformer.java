package Generated;
import Graphics.*;
import Petrinet1.PetriNet;
import java.util.HashMap;


public class GraphicsTransformer extends Transformer<HashMap<Long,Drawable>> {
  private   PetriNet net ;

    public void setNet(PetriNet net) {
        this.net = net;
    }

    public HashMap<Long,Drawable> transform(Document document)  {
        //keys on Hashmap are the IDs of drawables,
        // so it will be able easy to draw the drawables in the right order
        //and get the coordinations of the Arc2D from the document,which contains just IDs

        HashMap<Long,Drawable> drawables=new HashMap<>();


        for (Generated.Place place : document.getPlace()) {
            Place2D place2D = new Place2D(

                    place.getX(),
                    place.getY(),
                    net.places.get((long)place.getId())
            );

            drawables.put((((long)place.getId())),place2D);
        }

        for (Generated.Transition transition : document.getTransition()) {
            Transition2D transition2d = new Transition2D(
                    transition.getX(),
                    transition.getY(),
                    (net.trasitions.get((long)transition.getId()))

            );

            drawables.put(((long)(transition.getId())),transition2d);
        }

        for (Generated.Arc arc : document.getArc()) {

                if (net.places.get((long) arc.sourceId) != null) {

                    //getting the coordinates from the existing drawable shapes using ID as the key of Hashmap

                    int source_x=((int)((getPlace2D(drawables, arc.getSourceId())).getX())+25);
                    int source_y=((int)(getPlace2D(drawables, arc.getSourceId()).getY())+25);
                    int destination_x=((int)(getTransition2D(drawables, arc.getDestinationId()).getX())+25);
                    int destination_y=((int)((getTransition2D(drawables, arc.getDestinationId())).getY())+25);
                    Petrinet1.Arc arc1=net.arcs.get(((long)arc.getId()));


                    Arc2D arc2D =new Arc2D(source_x,source_y,destination_x,destination_y,arc1);

                    drawables.put(((long)(arc.getId())),arc2D);
                }
                else {
                    int source_x=((int)((getTransition2D(drawables, arc.getSourceId())).getX())+25);
                    int source_y=((int)((getTransition2D(drawables, arc.getSourceId())).getY())+25);
                    int destination_x=((int)((getPlace2D(drawables, arc.getDestinationId())).getX())+25);
                    int destination_y=((int)((getPlace2D(drawables, arc.getDestinationId())).getY())+25);
                    Petrinet1.Arc arc1=net.arcs.get(((long)arc.getId()));

                    Arc2D arc2D =new Arc2D(source_x,source_y,destination_x,destination_y,arc1);

                    drawables.put(((long)(arc.getId())),arc2D);

                }
        }

        return drawables;
    }

    private Place2D getPlace2D(HashMap<Long, Drawable> drawables, long sourceId) {
        return (Place2D) (drawables.get(sourceId));
    }

    private Transition2D getTransition2D(HashMap<Long, Drawable> drawables, long destinationId) {
        return (Transition2D) (drawables.get(destinationId));
    }

}