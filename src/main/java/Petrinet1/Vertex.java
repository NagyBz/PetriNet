package Petrinet1;

import java.util.ArrayList;

public abstract class Vertex {
    private long ID;
    private String name;

    private ArrayList<Petrinet1.Arc> inputArcs = new ArrayList<>();
    private ArrayList<Petrinet1.Arc> outputArcs = new ArrayList<>();

    public ArrayList<Petrinet1.Arc> getInputArcs() {
        return this.inputArcs;
    }

    public ArrayList<Petrinet1.Arc> getOutputArcs() {
        return this.outputArcs;
    }

    void putInputArc(Arc arc) { inputArcs.add(arc); }

    void putOutputArc(Arc arc) {
        outputArcs.add(arc);
    }




    public void removeAllArcs(){
        this.inputArcs.clear();
        this.outputArcs.clear();
    }


    public Vertex(long ID,String name) {
        this.ID = ID;
        this.name=name;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
