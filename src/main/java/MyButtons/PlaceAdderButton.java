package MyButtons;

import MyListeners.PlaceAdderListener;
import Petrinet1.PetriNet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import Graphics.NetCanvas;

public class PlaceAdderButton extends Button implements ActionListener {
    private NetCanvas netCanvas;
    private PetriNet petriNet;


    public PlaceAdderButton(String label, NetCanvas netCanvas, PetriNet petrinet) throws HeadlessException {
        super(label);
        this.netCanvas = netCanvas;
        this.petriNet = petrinet;
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MouseListener[] listener=netCanvas.getMouseListeners();
        for (MouseListener listener1 :listener){
            netCanvas.removeMouseListener(listener1);
        }
        netCanvas.addMouseListener(new PlaceAdderListener(petriNet,netCanvas.getDrawables(),netCanvas));
        netCanvas.repaint();

    }
}
