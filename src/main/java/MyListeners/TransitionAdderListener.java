package MyListeners;
import Graphics.Drawable;
import Graphics.NetCanvas;
import Graphics.Transition2D;
import Petrinet1.PetriNet;
import Petrinet1.Transition;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;


public class TransitionAdderListener implements MouseListener {

    private PetriNet petriNet;
    private HashMap<Long, Drawable> drawables;
    private NetCanvas netCanvas;

    public TransitionAdderListener(PetriNet petriNet, HashMap<Long, Drawable> drawables, NetCanvas netCanvas) {
        this.petriNet = petriNet;
        this.drawables = drawables;
        this.netCanvas = netCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        petriNet.incrementID();
        Transition transition=new Transition(petriNet.getID(),"");
        Transition2D transition2D=new Transition2D(e.getX()-25,e.getY()-25,transition);

        petriNet.addTransition(transition);
        drawables.put(petriNet.getID(),transition2D);
        netCanvas.repaint();


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
