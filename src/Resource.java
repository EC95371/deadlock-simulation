
public class Resource {
    int ID;
    Resource(int i){
        ID = i;
    }
    int getID(){
        return ID;
    }
    @Override
    public String toString(){
       return Integer.toString(ID);
    }
}
