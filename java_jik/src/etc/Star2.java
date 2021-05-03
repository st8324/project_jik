package etc;

public class Star2 {

	public static void main(String[] args) {
		/*     *		i=1	공=4 	*=1
		 *    ***		i=2	공=3 	*=3
		 *   *****		i=3	공=2 	*=5
		 *  *******		i=4	공=1 	*=7
		 * *********	i=5	공=0 	*=9
		 * 					공=5-i	*=2*i-1
		 * */
		int i,k;
		int num = 10;
		for(i = 1; i<=num; i+=1) {
			for(k = 1; k<=num-i; k+=1 ) {
				System.out.print(" "); 
			}
			for(k = 1; k<=2*i-1; k+=1 ) {
				System.out.print("*"); 
			}
			System.out.println();
		}
		System.out.println("=========");
		/* *********	i=1	공=0		*=9 = 8 + 1 = 2*4 + 1 = 2*(5-1) + 1
		 *  *******		i=2	공=1		*=7 = 6 + 1 = 2*3 + 1 = 2*(5-2) + 1
		 *   *****		i=3	공=2		*=5
		 *    ***		i=4	공=3		*=3
		 *     *		i=5	공=4		*=1
		 * 					공=i-1	*=2*(5-i) + 1
		 */
		for(i = 1; i<=num; i+=1) {
			for(k = 1; k<=i-1; k+=1 ) {
				System.out.print(" "); 
			}
			for(k = 1; k<=2*(num-i)+1; k+=1 ) {
				System.out.print("*"); 
			}
			System.out.println();
		}
	}

}
