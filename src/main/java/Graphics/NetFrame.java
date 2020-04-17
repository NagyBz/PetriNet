package Graphics;
import MyButtons.*;
import Petrinet1.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;


public class NetFrame  extends Frame  {

    public HashMap<Long,Drawable> drawables=new HashMap<>();

    public PetriNet petriNet=new PetriNet();
    public NetCanvas netCanvas=new NetCanvas(drawables,petriNet);


    OpenButton openButton;
    PlaceAdderButton placeAdderButton;
    TransitionAdderButton transitionAdderButton;
    RunButton runButton;
    ArcAdderButton arcAdderButton;
    DeleteButton deleteButton;
    SaveButton saveButton;

    NetFrame()throws HeadlessException {
        super("Petrinet editor");
        setSize(1700, 1000);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }

        });
        setLayout(new BorderLayout());


        openButton=new OpenButton("open",netCanvas,petriNet);
        placeAdderButton= new PlaceAdderButton("add Place",netCanvas,petriNet);
        transitionAdderButton=new TransitionAdderButton("add Transition",netCanvas,petriNet);
        runButton=new RunButton("run",netCanvas,petriNet);
        arcAdderButton=new ArcAdderButton("add Arc",netCanvas,petriNet);
        deleteButton=new DeleteButton("delete",netCanvas,petriNet);
        saveButton=new SaveButton("save",petriNet,netCanvas);


        Panel panel=new Panel();
        panel.add(runButton);
        panel.add(openButton);
        panel.add(saveButton);
        panel.add(placeAdderButton);
        panel.add(transitionAdderButton);
        panel.add(arcAdderButton);
        panel.add(deleteButton);
        add(panel,BorderLayout.NORTH);


        add(netCanvas,BorderLayout.CENTER);


        setVisible(true);

    }
}