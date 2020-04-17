package Generated;

import Graphics.Drawable;
import Graphics.Vertex2D;
import Petrinet1.Arc;
import Petrinet1.PetriNet;
import java.util.HashMap;

public class ToDocuTransformer {




    public Document transform(PetriNet petriNet, HashMap<Long,Drawable> drawables) {
        Document document = new Document();

        for(Petrinet1.Place place: (petriNet.places).values()){
            Generated.Place place1=new Generated.Place();
            place1.setId((short)place.getID());
            place1.setLabel(place.getName());
            place1.setTokens((short)place.getTokens());
            place1.setX((short)((Vertex2D)drawables.get(place.getID())).getXcoord());
            place1.setY((short)((Vertex2D)drawables.get(place.getID())).getYcoord());
            place1.setStatic(false);

            document.getPlace().add(place1);


        }

        for(Petrinet1.Transition transition :(petriNet.trasitions).values()){
            Generated.Transition transition1=new Generated.Transition();
            transition1.setId((short)transition.getID());
            transition1.setLabel(transition.getName());
            transition1.setX((short)((Vertex2D)drawables.get(transition.getID())).getXcoord());
            transition1.setY((short)((Vertex2D)drawables.get(transition.getID())).getYcoord());

            document.getTransition().add(transition1);

        }

        for (Arc arc :petriNet.arcs.values()){
            Generated.Arc arc1=new Generated.Arc();
            arc1.setId((short)arc.getID());
            arc1.setMultiplicity((short)arc.getWeigth());
            arc1.setSourceId((short)arc.getStartPoint().getID());
            arc1.setDestinationId((short)arc.getEndPoint().getID());
            arc1.setType("regular");

            document.getArc().add(arc1);
        }

        return document;
    }







}
