

import java.util.ArrayList;

public class Process {
    int numHeld, numWanted;
    ArrayList<Resource> heldResources;
    ArrayList<Resource> wantedResources;
    
    ArrayList getHeldResources() {
        return heldResources;
    }
    ArrayList getWantedResource(){
        return wantedResources;
    }
    int getNumHeld(){
        return numHeld;
    }
    int getNumWanted(){
        return numWanted;
    }
    void hold(Resource newRes){
        heldResources.add(newRes);
        numHeld++;
    }
    
    void want(Resource newRes){
        wantedResources.add(newRes);
        numWanted++;
    }
    
    void drop(Resource newRes){
        heldResources.remove(newRes);
        numHeld--;
    }
    
    void endWant(Resource newRes){
        wantedResources.remove(newRes);
        numWanted--;
    }
    
}
