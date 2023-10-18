package lab3;

public class ComplexNumber extends SpecialNumber {
    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public SpecialNumber add( SpecialNumber num) throws Lab3Exception {
        if (!(num instanceof ComplexNumber)) {
            throw new Lab3Exception("Cannot add an incompatible type");
        }
        if (num==null){
            return this;
        }
        if (this ==null){
            return num;
        }
        //can num be zero?
        double r = this.real + ((ComplexNumber) num).real;
        double i = this.imaginary + ((ComplexNumber) num).imaginary;
        return new ComplexNumber(r,i);
    }

    @Override
    public SpecialNumber divideByInt(int divisor) throws Lab3Exception {
        if(divisor ==0){
            throw new Lab3Exception("Cannot divide by zero");
        }
        double r = this.real/divisor;
        double i = this.imaginary/divisor;
        return new ComplexNumber(r,i);
    }

    public int compareTo(Object obj) {
        ComplexNumber other = (ComplexNumber) obj;
        double c_mag = Math.pow(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2), 0.5);
        double o_mag = Math.pow(Math.pow(other.real, 2) + Math.pow(other.imaginary, 2), 0.5);

        if (c_mag < o_mag) {
            return -1;
        }
        if (c_mag > o_mag) {
            return 1;
        } else {
            return 0;
        }
    }



    public boolean equals(Object obj){
        if (this == obj){return true;}
        if (obj == null || getClass() != obj.getClass()){return false;}
        ComplexNumber other = (ComplexNumber) obj;
        return ((this.real + this.imaginary == other.real + other.imaginary));
    }

    public int hashCode(){
        int result = 17;
        result = 31 * result + Double.hashCode(this.real + this.imaginary);
        return result;
    }

}
