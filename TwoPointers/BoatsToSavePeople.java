import java.util.Arrays;
class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j = people.length-1;
        int cn =0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                cn+=1;
                i+=1;
                j-=1;
            }
            else{
                cn+=1;
                j--;
            }
        }
        return cn;
    }

    public static void main(String[] args) {
        int[] people = new int[]{3,1,4,8,7};
        System.out.println(numRescueBoats(people,9));
    }
}