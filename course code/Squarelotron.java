import java.util.*;

public class Squarelotron {
	int size; //size of the squarelotron
	int[][] squarelotron;

	//constructor
	public Squarelotron(int n){
		this.size = n;
		int count = 0;
		squarelotron = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0; j<n;j++) {
				count++;
				squarelotron[i][j] = count;
			}
		}
		
	}
	
	//method:upsideDownFlip
	public Squarelotron upsideDownFlip(int ring) {
		Squarelotron s = new Squarelotron(this.size);
		Squarelotron s_new = new Squarelotron(this.size);

		for(int i =0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				if(((i == ring - 1) || (i == this.size -ring) || (j== ring -1) || (j==this.size-ring))
					&& (i<= this.size-ring) && (i>=ring-1) && (j<= this.size - ring) && (j>=ring-1)
					) {
					s_new.squarelotron[i][j] = s.squarelotron[this.size- 1 - i][j];
				}
				
			}
		}
		
		return s_new;
	}
	
	//method:mainDiagonalFlip
	public Squarelotron mainDiagonalFlip(int ring) {
		Squarelotron s = new Squarelotron(this.size);
		Squarelotron s_new = new Squarelotron(this.size);

		for(int i =0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				if(((i == ring - 1) || (i == this.size -ring) || (j== ring -1) || (j==this.size-ring))
					&& (i<= this.size-ring) && (i>=ring-1) && (j<= this.size - ring) && (j>=ring-1)
					) {
					s_new.squarelotron[i][j] = s.squarelotron[j][i];
				}
				
			}
		}
		
		return s_new;
	}

	//method:rotateRight 
	//there is seasonal in the rotation. rotateRight(-1) = rotateRight(3)
	public void rotateRight(int numberOfTurns ) {
		
		numberOfTurns = (((numberOfTurns % 4) + 4 ) % 4 );
		
		for (int n = 0; n < numberOfTurns; n++) {
			Squarelotron newSquarelotron = new Squarelotron(size);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					newSquarelotron.squarelotron[j][size - 1 - i] = squarelotron[i][j]; 
				}
			}
			this.squarelotron = newSquarelotron.squarelotron;
		}
		return;
		}
	

	public static void main(String[] args) {
		
		Squarelotron s = new Squarelotron(5);
		s.rotateRight(1);
		for (int i = 0; i < 5; i++) {
			for (int j =0; j<5; j++) {
				System.out.print(s.squarelotron[i][j] + "    ");
			}
			System.out.print(" \n");
		}
	}
}
