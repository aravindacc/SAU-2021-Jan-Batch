import java.util.*;

public class SortingInteger
{
     public static void main(String []args){
        int i=0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length of array: ");
        int len = scanner.nextInt();
        System.out.println("Enter "+len+" numbers.");
        while (i<len)
        {
            list.add(scanner.nextInt());
            i++;
        }
        System.out.println("Before sorting:"+list);
        Collections.sort(list);
        System.out.println("After using Collections.sort():"+list.toString());
    }
}