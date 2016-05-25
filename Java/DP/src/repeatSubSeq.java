public class repeatSubSeq {
	//Given a string, find if there is any sub-sequence that repeats itself.
	//	A sub-sequence of a string is defined as a sequence of characters generated by deleting some characters in the string without changing the order of the remaining characters.
	
	public int anytwo(String a) {
		int n = a.length();
		int T[][] = new int[n +1][n +1];
		
		for (int i = 1; i <= n; i++){
			for (int j = 1; j <= n;  j++){
				if (a.charAt(j -1) == a.charAt(i -1) && i != j)
					T[i][j] = T[i -1][j -1] +1;
				else
					T[i][j] = Math.max(T[i-1][j], T[i][j -1]);
			}
		}
		
//		for (int i = 0; i <= n; i++){
//			for (int j = 0; j <= n;  j++)
//				System.out.print(T[i][j] + " ");
//			System.out.println();
//		}
		
		return T[n][n];
	}
	
	public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int T[][] = new int[m +1][n +1];
        
        for (int i = 0; i <= m; i++)
        	T[i][0] = 1;
        
        for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n;  j++){
				if (s.charAt(i -1) == t.charAt(j -1))
					T[i][j] = T[i -1][j] + T[i -1][j -1];
				else
					T[i][j] = T[i -1][j];
			}
        
		return T[m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new repeatSubSeq().numDistinct("rabbbit", "rabbit"));
	}

}
