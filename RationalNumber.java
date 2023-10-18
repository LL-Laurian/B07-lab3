package lab3;


public class RationalNumber extends SpecialNumber implements Comparable {
	int numerator;
	int denominator;

	/**
	 * This is a construction method for the class RationalNumber. It takes parameters, integer numerator and integer
	 * parameter to assign to a new RationalNumber object.
	 * @param numerator The numerator that needs to be assigned
	 * @param denominator The denominator that needs to be assigned
	 * @throws Lab3Exception If the denominator is zero, a Lab3Exception will be thrown.
	 */
	public RationalNumber(int numerator, int denominator)throws Lab3Exception {
		if (denominator == 0) {
			throw new Lab3Exception("Denominator cannot be zero");
		}
		this.denominator = denominator;
		this.numerator = numerator;
	}

	/**
	 * This method takes two integer parameters, num1 and num2, and return the greatest common divisor of them.
	 * @param num1 The first number for GCD computation.
	 * @param num2 The second number for GCD computation.
	 * @return The greatest common divisor of num1 and num2
	 */
	public int GcD(int num1, int num2){
		if (num2==0){
			return num1;
		}
		return GcD(num1, num1%num2);
	}


	/**
	 *This method overrides add() function in the SpecialNumber class. It takes a SpecialNumber num and returns its sum
	 * with the current object.
	 * @param num The RationalNumber number to be added to the current object.
	 * @return The sum of the parameter RationalNumber num and the current object.
	 * @throws Lab3Exception If the parameter is not a instance of RationalNumber, a Lab3Exception will be thrown.
	 */
	@Override
	public SpecialNumber add(SpecialNumber num) throws Lab3Exception {
		if (!(num instanceof RationalNumber)){
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		if (num==null){
			return this;
		}
		if (this ==null){
			return num;
		}
		//can num be zero?
		int denom = this.denominator * ((RationalNumber) num).denominator;
		int nume = this.numerator * ((RationalNumber) num).denominator + ((RationalNumber) num).numerator * this.denominator;
		int factor = GcD(denom,nume);
		return new RationalNumber(nume/factor, denom/factor);
	}


	/**
	 * This method overrides the divideByInt() method inherited from the SpecialNumber class. It divides the current
	 * object by the specified integer divisor and returns the result.
	 * @param divisor The integer by which the current object is to be divided.
	 * @return The result of dividing the current object by the input divisor.
	 * @throws Lab3Exception If the input integer divisor is 0, a Lab3Exception will be thrown.
	 */
	@Override
	public SpecialNumber divideByInt(int divisor) throws Lab3Exception{
		if(divisor ==0){
			throw new Lab3Exception("Cannot divide by zero");
		}
		int denom = this.denominator*divisor;
		int nume = this.numerator;
		int factor = GcD(denom,nume);
		return new RationalNumber(nume/factor, denom/factor);
	}

	/**
	 * This method compares the current object with input object.
	 * @param obj the object to be compared.
	 * @return 1 if otherRationalNumber is less than this RationalNumber, 0 if they are
	 * equal, and 1 otherwise.
	 */
	public int compareTo(Object obj){
		RationalNumber other = (RationalNumber) obj;
		if (this.numerator/this.denominator > other.numerator/other.denominator){
			return 1;
		}
		if (this.numerator/this.denominator < other.numerator/other.denominator){
			return -1;
		}
		return 0;
	}

	/**
	 * This method checks if the current RationalNumber object is equal to the other objectc.
	 * @param obj The object to compare with the current RationalNumber object.
	 * @return True if the objects are equal, false otherwise.
	 */

	public boolean equals(Object obj){
		if (this == obj){return true;}
		if (obj == null || getClass() != obj.getClass()){return false;}
		RationalNumber other = (RationalNumber) obj;
		int n_di = GcD(other.denominator,other.numerator);
		int c_di = GcD(this.denominator,this.numerator);
		return ((this.denominator/c_di == other.denominator/n_di) && (this.numerator/c_di == other.numerator/n_di));
	}

	/**
	 * This method computes the current RationalNumber object.
	 * @return the computed hash code of the current object according to the concept of euqals() function. It is based
	 * on the denominator and numerator value.
	 */
	public int hashCode(){
		int result = 17;
		int gcd = GcD(this.denominator, this.numerator);
		result = 31 * result + Integer.hashCode(this.denominator / gcd);
		result = 31 * result + Integer.hashCode(this.numerator / gcd);

		return result;
	}



}
