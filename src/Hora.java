import java.util.Scanner;

public class Hora {
    protected int hora,minutos; //atributos protegidos, pensados para heredar.
    Hora (int hora, int minutos){
        // constructor
        this.hora = 0;
        this.minutos = 0;
        if (!setHora(hora)){
            //método de asignación, comprueban los valores
            System.out.println("La hora es incorrecta");
        }
        if (!setMinutos(minutos)){
            System.out.println("Los minutos no son válidos");
        }
    }
    public void inc(){
        //incrementa la hora +1 minuto
        minutos ++;
        if (minutos > 59){
            minutos = 0;
            hora ++;
            if (hora > 23){
                hora = 0;
            }
        }
    }
    public boolean setMinutos(int minutos){
        boolean correcto = false;
        if(0 <= minutos && minutos<60){
            this.minutos = minutos;
            correcto = true;
        }
        return correcto;
    }
    public boolean setHora (int hora){
        boolean correcto = false;
        if(0 <= hora && hora<24){
            this.hora = hora;
            correcto = true;
        }
        return correcto;
    }
    @Override //indica que estamos sustituyendo el método
    public String toString(){
        String result;
        result = hora + ":" + minutos;
        return result;
    }

    static public void main(String args[]) {
        Hora r = new Hora(11, 30);
        System.out.println(r);
        for (int i=1;i <= 61;i++){
            r.inc();
        }
        System.out.println(r);
        System.out.println("Escriba una hora: ");
        int hora = new Scanner(System.in).nextInt();
        boolean cambio = r.setHora(hora);
        if (cambio) {
            System.out.println(r);
        } else {
            System.out.println("La hora no se pudo cambiar.");
        }
    }
}
