package concepts_used;

public class Boyer_Moore_Class {
	
	 private final int R;     
	    private int[] right;    

	    private char[] pattern;  
	    private String pat;     
	    public Boyer_Moore_Class(String pat) {
	        this.R = 256;
	        this.pat = pat;

	        right = new int[R];
	        for (int c = 0; c < R; c++)
	            right[c] = -1;
	        for (int j = 0; j < pat.length(); j++)
	            right[pat.charAt(j)] = j;
	    }

	    public Boyer_Moore_Class(char[] pattern, int R) {
	        this.R = R;
	        this.pattern = new char[pattern.length];
	        for (int j = 0; j < pattern.length; j++)
	            this.pattern[j] = pattern[j];

	        right = new int[R];
	        for (int c = 0; c < R; c++)
	            right[c] = -1;
	        for (int j = 0; j < pattern.length; j++)
	            right[pattern[j]] = j;
	    }

	    public int search(String txt) {
	        int M = pat.length();
	        int N = txt.length();
	        int skip;
	        for (int i = 0; i <= N - M; i += skip) {
	            skip = 0;
	            for (int j = M-1; j >= 0; j--) {
	                if (pat.charAt(j) != txt.charAt(i+j)) {
	                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
	                    break;
	                }
	            }
	            if (skip == 0) return i;    
	        }
	        return N;                       
	    }


	    public int search(char[] text) {
	        int M = pattern.length;
	        int N = text.length;
	        int skip;
	        for (int i = 0; i <= N - M; i += skip) {
	            skip = 0;
	            for (int j = M-1; j >= 0; j--) {
	                if (pattern[j] != text[i+j]) {
	                    skip = Math.max(1, j - right[text[i+j]]);
	                    break;
	                }
	            }
	            if (skip == 0) return i;    
	        }
	        return N;                       
	    }

}
