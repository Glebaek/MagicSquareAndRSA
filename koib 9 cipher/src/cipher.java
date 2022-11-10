public class cipher {

    public static int[][] generateSquareNumbers(int n)
    {
        int[][] magicSquare = new int[n][n];

        int i = n/2;
        int j = n-1;


        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n)
            {
                j = n-2;
                i = 0;
            }
            else
            {
                if (j == n)
                    j = 0;

                if (i < 0)
                    i=n-1;
            }

            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                magicSquare[i][j] = num++;

            j++;  i--;
        }

        return magicSquare;
    }

    
    public static void displayMS(int[][] MS, int n){

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(MS[i][j] + " ");
            System.out.println();
        }

    }
    
    public static void displayMS(char[][] magicSquareSy, int sizeOfMS) {
    	
    	for(int i = 0; i < sizeOfMS; i++)
        {
            for(int j = 0; j < sizeOfMS; j++)
                System.out.print(magicSquareSy[i][j] + " ");
            System.out.println();
        }
		
	}


    public static char[][] generateSquareSymbols(String text, int[][] magicSquare, int sizeOfMS){
    	
        char[][] magicSquareSy = new char[sizeOfMS][sizeOfMS];
        
        for(int k = 0; k < text.length(); k++) {
        	for(int i = 0; i < 5; i ++) {
        		for(int j = 0; j < 5; j++) {
        			if(magicSquare[i][j] == (k+1)) 
        				magicSquareSy[i][j] = text.charAt(k);
        		}
        	}
        }
        return magicSquareSy;
    }

    public static String decrypt(int[][] msn, char[][]mss, int size){

        String result = "";

        for(int k = 0; k < 25; k++){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(msn[i][j] == k)
                        result = result + mss[i][j];
                }
            }
        }

        return result;
    }

    public static int gcd(int e, int z)
    {
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }

}


	
