package concepts_used;

public class Boyer_Moore_Class {
	
	 private final int R;     
	    private int[] right;     
	    private String matchPattern;      

	    public Boyer_Moore_Class(String pat) {
	        this.R = 256;
	        this.matchPattern = matchPattern;

	        right = new int[R];
	        for (int c = 0; c < R; c++)
	            right[c] = -1;
	        for (int j = 0; j < matchPattern.length(); j++)
	            right[matchPattern.charAt(j)] = j;
	    }
	    
	    public int search(String txt) {
	        int M = matchPattern.length();
	        int N = txt.length();
	        int skip;
	        for (int i = 0; i <= N - M; i += skip) {
	            skip = 0;
	            for (int j = M-1; j >= 0; j--) {
	                if (matchPattern.charAt(j) != txt.charAt(i+j)) {
	                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
	                    break;
	                }
	            }
	            if (skip == 0) return i;    
	        }
	        return N;                       
	    }

}
