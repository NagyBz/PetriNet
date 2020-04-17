package MyButtons;
import MyListeners.TransitionAdderListener;
import Petrinet1.PetriNet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import Graphics.NetCanvas;

public class TransitionAdderButton extends Button implements ActionListener {
    private NetCanvas netCanvas;
    private PetriNet petriNet;


    public TransitionAdderButton(String label, NetCanvas netCanvas, PetriNet petriNet) throws HeadlessException {
        super(label);
        this.netCanvas = netCanvas;
        this.petriNet = petriNet;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MouseListener[] listener=netCanvas.getMouseListeners();
        for (MouseListener listener1 :listener){
            netCanvas.removeMouseListener(listener1);
        }
        netCanvas.addMouseListener(new TransitionAdderListener(petriNet,netCanvas.getDrawables(),netCanvas));
        netCanvas.repaint();
    }
}
