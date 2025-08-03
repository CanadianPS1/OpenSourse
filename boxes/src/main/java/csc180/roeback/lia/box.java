package csc180.roeback.lia;
import java.lang.reflect.Array;
public class box<E>{
    private E[] a;
    //i got confused by "create a generic box" so i just made a "box" that was a generic
    public box(Class<E> c, int s){
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(c, s);
        this.a = a;
    }
    E get(int i) {return a[i];}
    public void set(int i, E value) {a[i] = value;}
}
