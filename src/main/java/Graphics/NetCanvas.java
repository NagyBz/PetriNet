package Graphics;
import Petrinet1.PetriNet;
import java.awt.*;
import java.util.*;


public class NetCanvas extends Canvas  {

     HashMap<Long,Drawable> drawables;
     PetriNet petrinet;

    NetCanvas(HashMap<Long,Drawable> drawables,PetriNet petrinet){
        super();
        this.drawables=drawables;
        this.petrinet=petrinet;
    }

    public void setDrawables(HashMap<Long,Drawable> drawables){
        this.drawables=drawables;
    }

    public HashMap<Long, Drawable> getDrawables() {
        return drawables;
    }

    // my drawable HashMap I transform to Object of KeySets,
    // which I reverse sort,so I can draw drawables in right order(first arc2D,then the other drawables)
    //so I dont have to calculate the length of arcs
    // later I'll be able to create drawables with the right ID, arcs will have the greatest IDs.
    //that's why I use HashMap and not ArrayList

    @Override
    public  void paint(Graphics g){

        Graphics2D g2D=(Graphics2D)g;
        g2D.setStroke(new BasicStroke(3));

        if(drawables!=null) {
            Object[] keys = drawables.keySet().toArray();
            Arrays.sort(keys, Collections.reverseOrder());

            for (Object key : keys) {
                drawables.get(key).draw(g2D);
                if(petrinet.getID()<key.hashCode()){
                    petrinet.setID(key.hashCode());
                }
            }
        }
    }
}
