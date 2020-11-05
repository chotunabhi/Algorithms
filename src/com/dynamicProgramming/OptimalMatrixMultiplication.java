package com.dynamicProgramming;

public class OptimalMatrixMultiplication {
	char[] matrixNames;
	StringBuffer output = new StringBuffer();
	
	public static void main(String[] args) {
		OptimalMatrixMultiplication omm = new OptimalMatrixMultiplication();
		int []cmm = {2,4,1,1,2,3,1,1};
		
		omm.matrixNames = new char[cmm.length - 1];
		char c = 'A';
		
		for(int i = 0;i < omm.matrixNames.length; i++,c++)
			omm.matrixNames[i] = c;
		
//		System.out.println(omm.costOfMatrixMultiplication(cmm)+" "+omm.output.toString());
		System.out.println(omm.costOfMatrixMultiplicationOl(cmm,cmm.length)+" "+omm.output.toString());
		System.out.println(omm.findCost(cmm));
		
	}
	
//	private int costOfMatrixMultiplication(int[] matrixSizes) {
//		if(matrixSizes.length == 3)
//			return matrixSizes[0]*matrixSizes[1]*matrixSizes[2];
//		
//		int t[][] = new int[matrixSizes.length - 1][matrixSizes.length - 1];
//		String sm[][] = new String[matrixSizes.length - 1][matrixSizes.length - 1];
//		int q;
//		
//		for(int l = 2;l < matrixSizes.length;l++) {
//			for(int i = 0; i < matrixSizes.length - l;i++) {
//				int j = l - 1 + i;
//				
//				if(t[i][j-1] <= t[i+1][j]) {
//					t[i][j] = t[i][j-1]+matrixSizes[i]*matrixSizes[j]*matrixSizes[j+1];
//					
//					sm[i][j] = "("+(sm[i][j-1] == null?""+matrixNames[i]:sm[i][j-1])+matrixNames[j]+")";
//				}else {
//					t[i][j] = t[i+1][j]+matrixSizes[i]*matrixSizes[i+1]*matrixSizes[j+1];
//					sm[i][j] = "("+matrixNames[i]+(sm[i+1][j] == null?""+matrixNames[i]:sm[i+1][j])+")";
//				}
//			}		
//		}
//		
//		
//		for(int i = 0; i < t.length; i++) {
//			for(int j = 0;j < t[0].length;j++)
//				System.out.print(t[i][j]+" ");
//			System.out.println();
//		}
////		output.append(sm[0][sm.length-1]);
//		return t[0][matrixSizes.length - 2];
//	}
	
	private int costOfMatrixMultiplicationOl(int[] p,int n) {
		/* For simplicity of the  
        program, one extra row and 
        one extra column are allocated in m[][].  0th row 
        and 0th column of m[][] are not used */
        int m[][] = new int[n-1][n-1]; 
  
        int i, j, k, L, q; 
  
        /* m[i, j] = Minimum number of scalar 
        multiplications needed to compute the matrix 
        A[i]A[i+1]...A[j] = A[i..j] where 
        dimension of A[i] is p[i-1] x p[i] */
  
        // L is chain length. 
        for (L = 2; L < n; L++)  
        { 
            for (i = 1; i < n - L + 1; i++)  
            { 
                j = i + L - 1; 
                
                m[i-1][j-1] = Integer.MAX_VALUE; 
                
                for (k = i; k <= j - 1; k++){ 
                    // q = cost/scalar multiplications 
                    q = m[i-1][k-1] + m[k][j-1] 
                        + p[i - 1] * p[k] * p[j];
                    
                    if (q < m[i-1][j-1]) {
                        m[i-1][j-1] = q; 
                        
                        m[j-1][i-1] = k-1;
                    }
                } 
            } 
        } 
        
//        for(int x = 0; x < m.length; x++) {
//			for(int y = 0;y < m[0].length;y++)
//				System.out.print(m[x][y]+"\t ");
//			System.out.println();
//		}
        
        printParenthesis(0,n-2,m);
        System.out.println();
        return m[0][n-2]; 
	}
	char name = 'A';
	
	private void printParenthesis(int i, int j,  int[][] bracket) 
    {
        // If only one matrix left in current segment
        if (i == j)
        {
            System.out.print(name++);
            return;
        }
 
        System.out.print('(');
 
        // Recursively put brackets around subexpression
        // from i to bracket[j][i].
        // Note that "*((bracket+j*n)+i)" is similar to
        // bracket[i][j]
        printParenthesis(i, bracket[j][i], bracket);
 
        // Recursively put brackets around subexpression
        // from bracket[j][i] + 1 to i.
        printParenthesis(bracket[j][i] + 1, j, bracket);
 
        System.out.print(')');
    }
	
	 public int findCost(int arr[]){
	        int temp[][] = new int[arr.length][arr.length];
	        int q = 0;
	        for(int l=2; l < arr.length; l++){
	            for(int i=0; i < arr.length - l; i++){
	                int j = i + l;
	                temp[i][j] = 1000000;
	                for(int k=i+1; k < j; k++){
	                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
	                    System.out.println(i+","+j+","+k);
	                    if(q < temp[i][j]){
	                        temp[i][j] = q;
	                    }
	                }
	            }
	        }
	        
	        for(int x = 0; x < temp.length; x++) {
				for(int y = 0;y < temp[0].length;y++)
					System.out.print(temp[x][y]+"\t ");
				System.out.println();
			}
	        
	        return temp[0][arr.length-1];
	    }
}
