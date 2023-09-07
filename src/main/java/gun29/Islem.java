package gun29;

public class Islem {

    public static Islem islem(){
        return islem(0);
    }


    public static Islem islem(double num){
        return new Islem(num);
    }

    double sum;

    private Islem(double num){
        sum = num;
    }

    public Islem topla(double a){
        sum += a;
        return this;
    }

    public Islem cikar(double a){
        sum -= a;
        return this;
    }

    public Islem carp(double a){
        sum *= a;
        return this;
    }

    public Islem bol(double a){
        sum /= a;
        return this;
    }

    public Islem write(){
        System.out.println("sum = " + sum);
        return this;
    }

}
