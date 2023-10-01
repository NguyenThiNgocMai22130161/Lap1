package tast_1;

public class task1_1 {
	
		private static int n_;

		// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
		public static int getSn1(int n) {
		if (n ==1) {
		return 1;
	} 
//			 int term = ((-1)^(n+1)) * n;
//		        return term + getSn1(n - 1);
//		
		else
			return getSn1(n-1) + (int)Math.pow(-1,n+1) * n;
			
	}
		// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
		public static int getSn2(int n) {
		// TODO
			if (n ==1) {
				return 1;
			} else
		return getRecursive(n) + getSn2(n-1);
}
      public static int getRecursive(int num) {
    	  //đệ quy
			 if (num == 1)
			     return 1;
			     else {
			        return num * getRecursive(num - 1);
			        
			        //vòng lặp for
//			        int result=1;
//			        for (int =1,i<=n;i++)
//			        	result*=1;
//			        	return	result;
			    }}
      
	 // S(n)=1^2+2^2+3^2+....+n^2 , n>0
	 public static int getSn3(int n) {
		if (n == 1)
			return 1;
		else
			 return (int) Math.pow (n,2) + getSn3(n-1);
			 }
	 
	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	 public static double getSn4(int n) {
	  if (n == 0)
	  return 1.0; // phải lấy 0.0 
	   else
		return 1.0/ get(2*n) + getSn4(n-1 ) ;
	 }
	 public static int get(int m) {
 
			 if (m <= 1)
			     return 1;
			     else {
			        return m * get(m - 1);
			        }
			 }
		
public static void main(String[] args) {
	// Test case : n = 5
    int result1 = getSn1(5);
    System.out.println("S(5) = " + result1); 
    int result2 = getSn2(5);
    System.out.println("S(5) = " + result2);
    int result3 = getSn3(5);
    System.out.println("s(5) = " + result3);
    double result4 = getSn4(1);
    System.out.println("s(5) = " + result4);
}		

}
