public class Main {
    
    public double calc(double a,
                       double b,
                       char method) throws IllegalArgumentException {
        
        if (method == '-') {
            return a - b;
        } else if (method == '+') {
            return a + b;
        } else if (method == '*') {
            return a * b;
        } else if (method == '/') {
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid operation"); 
        }

    }

}