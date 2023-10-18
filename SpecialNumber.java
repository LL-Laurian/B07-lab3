package lab3;

import java.util.List;

abstract class SpecialNumber {
	public abstract SpecialNumber add(SpecialNumber num) throws Lab3Exception;
	
	public abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;


	/**
	 * This method takes an SpecialNumber type arraylist nums and compute the sum of items using add function. It then
	 * divides the sum by the size of arraylist using divideByInt to return the average of the arraylist.
	 * @param nums The arraylist that need to compute the average.
	 * @return the average of SpecialNumber numbers in arrayList nums.
	 * @throws Lab3Exception If the input arraylist nums is empty or null, a Lab3Exception will be thrown.
	 */
	public static SpecialNumber computeAverage(List<SpecialNumber> nums)throws Lab3Exception {
		if (nums == null) {
			throw new Lab3Exception("List cannot be empty");
		}
		SpecialNumber sum = nums.get(0);
		for (int i= 1; i< nums.size(); i++) {
			sum = nums.get(i).add(sum);
		}
		return sum.divideByInt(nums.size());
	}

}
