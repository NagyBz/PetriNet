package Petrinet1;

import java.util.ArrayList;


public class Place extends Vertex {
    private  int tokens;
//    private ArrayList<Arc> inputArcs = new ArrayList<>();
//    private ArrayList<Arc> outputArcs = new ArrayList<>();
//
//
//    void putInputArc(Arc arc) { inputArcs.add(arc); }
//
//    void putOutputArc(Arc arc) {
//        outputArcs.add(arc);
//    }
//
//    public void removeallArcs(){
//        this.inputArcs.clear();
//        this.outputArcs.clear();
//    }

    public Place(int tokens, long ID, String name) {
        super (ID,name);
        this.tokens=tokens;
    }

    public int getTokens() {
        return tokens;
    }

    public  void addToken(int tokens){
        this.tokens+=tokens;
    }

    public void removeToken(int tokens) {
        this.tokens -= tokens;
    }

    public void removeAllTokens(){
            this.tokens=0;
    }

    @Override
    public String toString() {
        return "Place{" +
                "tokens=" + tokens +

                '}';
    }
}
