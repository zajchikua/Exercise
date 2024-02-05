public class FourD {

        public static void main(String[] args) {
            int[][][][] array4D = {
                    {{{1}, {2}}, {{3}, {4}}},
                    {{{5}, {6}}, {{7}, {8}}},
                    {{{9}, {10}}, {{11}, {12}}},
                    {{{13}, {14}}, {{15}, {16}}},
            };
            for (int i = 0; i < array4D.length; i++) {
                for (int j = 0; j < array4D[i].length; j++) {
                    for (int k = 0; k < array4D[i][j].length; k++) {
                        for (int l = 0; l < array4D[i][j][k].length; l++) {
                            System.out.print(array4D[i][j][k][l] + "\t");
                        }
                        System.out.println();
                    }
                    if (j < array4D[i].length - 1) {
                        System.out.println("------------------");
                    }
                }
                if (i < array4D.length - 1) {
                    System.out.println("=================================");
                }
            }
        }
    }

