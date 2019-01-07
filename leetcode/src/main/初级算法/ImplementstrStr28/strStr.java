package ImplementstrStr28;

/**
 * Implement strStr().
 
 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 
 
 */
public class strStr {
	public int strStrByleetCode(String haystack, String needle) {
				// empty needle is consider as prefix of any string.
				if (needle == null || needle.length() <= 0) return 0;
				if (haystack == null || haystack.length() <= 0) return -1;
				for (int i = 0; i < haystack.length() - needle.length() + 1; i++) { // *** optimized by m-n+1. or use KMP
					int j = i, k = 0;
					while (j < haystack.length() && k < needle.length()) {
						if (haystack.charAt(j) != needle.charAt(k)) break;
						j++; k++;
					}
					if (k == needle.length()) return i;
				}
				return -1;
	}
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
	
}
