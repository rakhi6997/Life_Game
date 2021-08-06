package Life_Game;
	
public class Life_Game1{
		
		 //The final value representing dead
		 public final static int dead=0; //dead represent '.'
		 
		 //the final value representing live
		 public final static int live=1; //dead represent '*'
		 
		 public static void main(String[] args){
			 //the starting life and dead cells
			 //int [][] board; the game board is a 2D array.
			 
			 int M=10,N=10;
			 int[][] board={{dead,dead,dead,dead,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,dead,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,live,live,dead,dead,dead,dead,dead},
							{dead,dead,dead,dead,live,dead,dead,dead,dead,dead},
							{dead,dead,dead,dead,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,dead,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,live,live,dead,dead,dead,dead,dead},
							{dead,dead,live,live,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,live,dead,dead,dead,dead,dead,dead},
							{dead,dead,dead,dead,dead,live,dead,dead,dead,dead},
						    };
							
			  //Displaying board
			  System.out.println("Original Generator");
			  System.out.println("..... is dead");
			  System.out.println("** is live");	
			  
			  for(int i=0; i<M; i++){
				  for(int j=0; j<N; j++){
					  if(board[i][j] == 0)
						  System.out.println(".");
					  else
						  System.out.println("*");
				  }
					System.out.println();
			  }
			  System.out.println();
			  nextGeneration(board,M,N);
			 
		 }
		 //Function to print next generation
		 
		 static void nextGeneration(int grid[][],int M,int N){
			 int[][] future = new int[M][N];
			  // Loop through every cell call
			for(int l=1;l<M-1;l++){
				for(int m=1; m<N-1;m++){
					//finding no of neighbours that are alive
					int aliveNeighbours=0;
					for(int i=-1;i<=1;i++)
						for(int j=-1;j<=1;j++)
							aliveNeighbours += grid[l+i][m+j];
						
					//the cells need to be substracted
					aliveNeighbours -= grid[l][m];
					
					//check condition
					if((grid[l][m] == 1) && (aliveNeighbours < 2))
						future[l][m] = 0;
					//cell dies due to over population
					else if ((grid[l][m] ==1) && (aliveNeighbours >3))
						future[l][m] = 0;
					// A new cell is born
					else if((grid[l][m] == 0) && (aliveNeighbours ==3))
						future[l][m] =1;
					else
						future[l][m] =grid[l][m];
				}
			}
		//print next generation after changes
		System.out.println("Next Generation");
		for( int i=0;i < M;i++){
			for(int j=0 ;j < M; j++){
				if(future[i][j] == 0)
					System.out.println(".");
				else
					System.out.println("*");
			}
			System.out.println();
		}
	}
}
			
					
					