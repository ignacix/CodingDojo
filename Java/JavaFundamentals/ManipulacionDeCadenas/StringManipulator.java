public class StringManipulator {
    
    public String trimAndConcat(String x, String i){
        return x.trim().concat(i.trim());
    }

    public int getIndexOrNull(String cadena, char x){
        return cadena.indexOf(x);
    }

    public String concatSubstring(String cortada, int i, int f, String cadena){
        return cortada.substring(i, f).concat(cadena);
    }
}
