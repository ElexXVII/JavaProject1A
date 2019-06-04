import java.io.Serializable;
import java.util.ArrayList;

public class TArray
{
    ArrayList a;
    int b = 4;

    public void setA(ArrayList a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ArrayList getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public TArray()
    {

    }

    public TArray(ArrayList a)
    {
        this.a = a;
    }
}
