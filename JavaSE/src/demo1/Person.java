package demo1;
class Person{

	public static void main(String []args){
		int[][] p = new int[10][];
		for (int i=0;i<10;i++){
			p[i] = new int[i+1];
			for (int j=0;j<i+1;j++){
				if (j==0||j==p[i].length-1){
					if (i==0){
						p[i][j] = 1;
						System.out.println(p[i][j]);
						break;
					}
					if (i==1){
						p[i][j] = p[i][j+1] = 1;
						System.out.println(p[i][j]+"\t"+p[i][j+1]);
						break;
					}
					if (j == 0){
						p[i][j] = 1;
						System.out.print(p[i][j]+"\t");
					}
					if (j==p[i].length-1){
						p[i][j] = 1;
						System.out.println(p[i][j]);
					}
				}else{
					p[i][j]=p[i-1][j-1]+p[i-1][j];
					System.out.print(p[i][j]+"\t");
				}
			}
		}
	}
}