public class Pitagoras{
    public double calcularHipotenusa(int catetoA, int catetoB){
        
        double result;
        double A = catetoA;
        double B = catetoB;
        result = Math.sqrt(A*A + B*B); 
        return result;
        
    }
}