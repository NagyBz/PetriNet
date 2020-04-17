package MyListeners;
import Graphics.Drawable;
import Graphics.NetCanvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;



public class RunPetriNetListener implements MouseListener {
   private NetCanvas netCanvas;
   private HashMap<Long,Drawable> drawables;

    public RunPetriNetListener(NetCanvas netCanvas, HashMap<Long, Drawable> drawables) {
        this.netCanvas = netCanvas;
        this.drawables = drawables;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Drawable drawable : drawables.values()){
            if((drawable.contains(e.getX(),e.getY()))) {
                drawable.onClick(e);
                netCanvas.repaint();
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
