package Petrinet1;
import java.util.HashMap;

public class PetriNet {
    private long ID=0;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    public void incrementID(){
        this.ID++;
    }

    public HashMap<Long, Place> places = new HashMap<>();
    public  HashMap<Long, Transition> trasitions = new HashMap<>();
    public HashMap<Long,Arc> arcs =new HashMap<>();


    public void addPlace(Place place){
        this.places.put(place.getID(),place);
    }

    public void addTransition(Transition trans){ this.trasitions.put(trans.getID(),trans); }

    public void addArc(Arc arc){ this.arcs.put(arc.getID(),arc); }

    public void fire(long ID) throws TransitionCannotBeFiredException {

       Transition trans=trasitions.get(ID);


      if ( !trans.isFireable()){
          throw new TransitionCannotBeFiredException("Transition can not be fired");
      }

      trans.fireTransition();

    }

    @Override
    public String toString() {
        return "PetriNet{" +
                "places=" +places.toString()+
                ", trasitions=" + trasitions.toString() +
                ", arcs=" + arcs +
                '}';
    }
}
