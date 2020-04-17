package MyButtons;
import MyListeners.RunPetriNetListener;
import Petrinet1.PetriNet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import Graphics.NetCanvas;


public class RunButton extends Button implements ActionListener {
    private NetCanvas netCanvas;
    private PetriNet petriNet;


    public RunButton(String label, NetCanvas netCanvas, PetriNet petrinet) throws HeadlessException {
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
           netCanvas.addMouseListener(new RunPetriNetListener(netCanvas,netCanvas.getDrawables()));

        System.out.println(petriNet.toString());



    }
}
