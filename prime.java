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
	
	//function to count the number of primes and non primes for approach 1
	long countPrimeNonPrimeApproach1(long[] arr){
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
	//function to count the number of primes and non primes for approach 2       
       long countPrimeNonPrimeApproach2(long[] arr){
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
       
	//function to count the number of non primes and primes for approach 1 with inverting if else block statements
       long countNonPrimePrimeApproach1(long[] arr){
        	long primeCount = 0;
        	long nonPrimeCount = 0;
        	for (long num : arr) {
            		if (!(isPrime1(num))) {
            			nonPrimeCount++;
            		}
            		else {
                		primeCount++;
            		}
        	}
        	return primeCount;
       }
       
       	//function to count the number of non primes and primes for approach 2 with inverting if else block statements
        long countNonPrimePrimeApproach2(long[] arr){
        	long primeCount = 0;
        	long nonPrimeCount = 0;
        	for (long num : arr) {
            		if (!(isPrime2(num))) {
            			nonPrimeCount++;
            		}
            		else {
                		primeCount++;
            		}
        	}
        	return primeCount;
       }
        
       		//function to check whether the number in array is prime or non prime with approach 1
		 boolean isPrime1(long n){  
		      if(n <= 1) {  
			   return false;  
		      }  
		      for(int i = 2; i < Math.sqrt(n); i++) {  
				if (n % i == 0) {  
				     return false;  
			    	}
	   	      }
	   		 return true;
		}
		
		 //function to check whether the number in array is prime or non prime with approach 2
		 public  boolean isPrime2(long number){
		if (number <= 1) {
        	    	return false;
        	}
		for(int i=2;i<=number/2;i++) {
			if (number % i ==0){
			return false;
			}
		}
			return true;
		}
		
		
		void printArray(long []arr){
			for(int i=0;i<arr.length;i++){
				System.out.println(arr[i]);
			}
	}
	
		long averageTime(long arr[]){
		long sum=0;
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
		}
		long avg=sum/arr.length;
		return avg;
	}
		
	public static void main(String[] args){
		prime obj1 = new prime();
		prime obj2 = new prime();
		long arr1[] = obj1.getRandomArray(100000);
		
		long Primecount1=obj1.countPrimeNonPrimeApproach1(arr1);
		long Primecount2=obj1.countPrimeNonPrimeApproach2(arr1);
		long Primecount3=obj1.countNonPrimePrimeApproach1(arr1);
		long Primecount4=obj1.countNonPrimePrimeApproach2(arr1);
		
		long startTime1,endTime1,startTime2,endTime2,startTime3,endTime3,startTime4,endTime4;
		int sizeofArray=100;
		long array1[]= new long[sizeofArray];
		long array2[] =new long[sizeofArray];
		long array3[]= new long[sizeofArray];
		long array4[] =new long[sizeofArray];
		int i=0;
		while(i<2){

			startTime1=System.nanoTime();
			obj1.countPrimeNonPrimeApproach1(arr1);
			endTime1=System.nanoTime();
			array1[i]=endTime1-startTime1;
			startTime2=System.nanoTime();
			obj1.countPrimeNonPrimeApproach1(arr1);
			endTime2=System.nanoTime();
			array2[i]=endTime2-startTime2;

			startTime3=System.nanoTime();
			obj1.countNonPrimePrimeApproach1(arr1);
			endTime3=System.nanoTime();
			array3[i]=endTime3-startTime3;
			startTime4=System.nanoTime();
			obj1.countNonPrimePrimeApproach2(arr1);
			endTime4=System.nanoTime();
			array4[i]=endTime4-startTime4;
			i++;
			
		}
		long time1=obj1.averageTime(array1);
		long time2=obj1.averageTime(array2);
		long time3=obj1.averageTime(array3);
		long time4=obj1.averageTime(array4);
		
		System.out.println("Time Taken by Approach 1 for Prime and non prime : "+time1);
		System.out.println("Time Taken by Approach 2 for Prime and non prime : "+time2);
		System.out.println("Time Taken by Approach 1  for non prime and Prime : " +time3);
		System.out.println("Time Taken by Approach 2 for non Prime and Prime : "+time4);
		}
}
