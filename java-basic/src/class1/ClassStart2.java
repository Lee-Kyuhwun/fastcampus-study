package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] studentNames = {"학생1", "학생2", "학생3", "학생4", "학생5"};
        int[] studentScores = {90, 85, 70, 95, 100};

        for(int i=0; i<5 ; i++){
            System.out.println("studentScores = " + studentScores[i]);
            System.out.println("studentNames = " + studentNames[i]);
        }


    }
}
