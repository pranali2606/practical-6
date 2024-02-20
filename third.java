class prime{
	static long prime;
	static long nonPrime;
	
	//function to create random digit
	public long getRandomDigit(){
		long digit = System.nanoTime()%10;
		return digit;
	}
		
	//function to create random 7 digit number
	public long getRandomNumber(){
	String number="";
	long num;
		for (long i=0;i<7;i++){
			num = getRandomDigit();
			while(num==0){
				num=getRandomDigit();
			}
	 		 number+=num;
		}
		
		return Long.parseLong(number);
	}
		
	//function to create random array of large size of the random 7 digits numbers
	public long[] getRandomArray(int size){
	long[] arr = new long[size];
		for (int i=0;i<size;i++){
			arr[i] = getRandomNumber();
		}
		return arr;
	}
	
	//function to count the number of primes and non primes
	long countPrimeNonPrime1(long[] arr){
        	long primeCount = 0;
        	long nonPrimeCount = 0;
        	for (long num : arr) {
            		if (isPrime1(num)) {
                		primeCount++;
            		}
            		else {
                		nonPrimeCount++;
            		}
        	}
        	return primeCount;
       }
       
       long countPrimeNonPrime2(long[] arr){
        	long primeCount = 0;
        	long nonPrimeCount = 0;
        	for (long num : arr) {
            		if (isPrime2(num)) {
                		primeCount++;
            		}
            		else {
                		nonPrimeCount++;
            		}
        	}
        	return primeCount;
       }
       
     
       
       //function to check whether the number in array is prime or non prime
       public  boolean isPrime1(long number){
		if (number <= 1) {
        	    	return false;
        	}
		for(int i=2;i<number/2;i++) {
			if (number % i !=0){
			return true;
			}	
		}
			return false;
		}
		
		 public  boolean isPrime2(long number){
		if (number <= 1) {
        	    	return false;
        	}
		for(int i=2;i<number/2;i++) {
			if (number % i !=0){
			return false;
			}	
		}
			return true;
		}
		
	public static void main(String[] args){
		prime obj1 = new prime();
		long arr1[] = obj1.getRandomArray(1000000);
		long startTime1 = System.nanoTime();
		
		System.out.println(obj1.countPrimeNonPrime1(arr1));
		long endTime1 = System.nanoTime();
		System.out.println("Time taken by arr1 is  " +(endTime1-startTime1));
		
		prime obj2 = new prime();
		long arr2[] = obj2.getRandomArray(1000000);
		long startTime2 = System.nanoTime();
		System.out.println(obj1.countPrimeNonPrime2(arr2));
		long endTime2 = System.nanoTime();
		System.out.println("Time taken by arr1 is  " +(endTime2-startTime2));
		
		}
}
