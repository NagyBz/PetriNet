package MyListeners;

import Graphics.Drawable;
import Graphics.NetCanvas;
import Graphics.Vertex2D;
import Petrinet1.Arc;
import Petrinet1.PetriNet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DeleteListener implements MouseListener {
    private PetriNet petriNet;
    private HashMap<Long, Drawable> drawables;
    private NetCanvas netCanvas;

    public DeleteListener(PetriNet petriNet, HashMap<Long, Drawable> drawables, NetCanvas netCanvas) {
        this.petriNet = petriNet;
        this.drawables = drawables;
        this.netCanvas = netCanvas;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (drawables != null) {
            if(drawables!=null) {
                Object[] keys = drawables.keySet().toArray();
                Arrays.sort(keys);

                for (Object key : keys) {

                    Drawable thisdrawable = drawables.get(key);

                    if (thisdrawable.contains(e.getX(), e.getY())) {

                        if(petriNet.arcs.containsKey(thisdrawable.getID())){

                            thisdrawable.removeArcs();
                            petriNet.arcs.remove(thisdrawable.getID());
                            drawables.remove(thisdrawable.getID());
                        }
                        else if(petriNet.trasitions.containsKey(thisdrawable.getID())){

                            ArrayList<Petrinet1.Arc> inputArcs=petriNet.trasitions.get(thisdrawable.getID()).getInputArcs();
                            ArrayList<Petrinet1.Arc> outputArcs=petriNet.trasitions.get(thisdrawable.getID()).getOutputArcs();


                            deleteArcs(inputArcs, outputArcs);

                            petriNet.trasitions.get(thisdrawable.getID()).getInputArcs().clear();
                            petriNet.trasitions.get(thisdrawable.getID()).getOutputArcs().clear();
                            petriNet.trasitions.remove(thisdrawable.getID());
                            drawables.remove(thisdrawable.getID());

                        } else if (petriNet.places.containsKey(thisdrawable.getID())) {

                            ArrayList<Arc> inputArcs=(petriNet.places.get(thisdrawable.getID())).getInputArcs();
                            ArrayList<Arc> outputArcs=(petriNet.places.get(thisdrawable.getID())).getOutputArcs();


                            deleteArcs(inputArcs, outputArcs);
                            petriNet.places.get(thisdrawable.getID()).getInputArcs().clear();
                            petriNet.places.get(thisdrawable.getID()).getOutputArcs().clear();

                            petriNet.places.remove(thisdrawable.getID());
                            drawables.remove(thisdrawable.getID());
                        }


                        netCanvas.repaint();
                        break;

                    }
                }
            }
        }
    }

    private void deleteArcs(ArrayList<Petrinet1.Arc> inputArcs, ArrayList<Petrinet1.Arc> outputArcs) {

        if(inputArcs!=null ){

            for (Arc arc : inputArcs) {
                arc.getStartPoint().getOutputArcs().remove(arc);
                drawables.remove(arc.getID());
                petriNet.arcs.remove(arc.getID());
            }
        }

        if (outputArcs !=null){
        for (Arc arc : outputArcs) {
            arc.getEndPoint().getInputArcs().remove(arc);
            drawables.remove(arc.getID());
            petriNet.arcs.remove(arc.getID());
        }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
