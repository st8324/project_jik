package day5;

public class Star1 {

	public static void main(String[] args) {
		/* ****	k = 1	*=4 
		 * ****	k = 2 	*=4
		 * ****	k = 3 	*=4
		 * ****	k = 4 	*=4
		 * ****	k = 5 	*=4
		 * */
		int i, k;
		for( k = 1 ; k <= 5 ; k += 1 ) {
			for( i = 1 ; i <= 4 ; i += 1 ) {
				System.out.print("*");
			}
			System.out.println();
		}
		/* *		k = 1	* = 1
		 * **		k = 2	* = 2
		 * ***		k = 3 	* = 3
		 * ****		k = 4	* = 4
		 * *****	k = 5	* = 5
		 * 					* = k
		 * */
		System.out.println("--------");
		for( k = 1 ; k <= 5 ; k += 1 ) {
			for( i = 1 ; i <= k ; i += 1 ) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*     ****	k = 1	공=4	*=4 
		 *     ****	k = 2 	공=4	*=4
		 *     ****	k = 3 	공=4	*=4
		 *     ****	k = 4 	공=4	*=4
		 *     ****	k = 5 	공=4	*=4
		 * */
		System.out.println("--------");
		for( k = 1 ; k <= 5 ; k += 1 ) {
			for( i = 1 ; i <= 4 ; i += 1 ) {
				System.out.print(" ");
			}
			for( i = 1 ; i <= 4 ; i += 1 ) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*     *	k=1	공=4		*=1
		 *    **	k=2 공=3		*=2
		 *   ***	k=3 공=2		*=3
		 *  ****	k=4 공=1		*=4
		 * *****	k=5 공=0		*=5
		 * 				공=5-k	*=k
		 * */
		for(k = 1 ; k <= 5 ; k += 1 ) {
			//공백 출력
			for( i = 1 ; i <= 5 - k  ; i += 1 ) {
				System.out.print(" ");
			}
			//별 출력
			for( i = 1 ; i <= k ; i += 1 ) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
		/*     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 * */
		/* *********
		 *  *******
		 *   *****
		 *    ***
		 *     *
		 * */
	}

}
