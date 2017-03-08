public class icach71{
	public static void main(String[] args){
		int [][] foo = new int [9][4];
		int k = 1;

		System.out.printf("# | 1 2 3 4 5 6 7 8 9%n");

		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 4; j++){
				System.out.print(foo[i][j] + " ");
			}
			System.out.println();
		}
	}
}
