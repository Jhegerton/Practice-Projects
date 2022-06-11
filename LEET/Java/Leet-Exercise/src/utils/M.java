package utils;


public class M {

    private M(){}

    public static void p(Object obj){
        System.out.print(obj);
    }
    public static void pl(Object obj){
        System.out.println(obj);
    }
    public static void pl(){
        System.out.println();
    }

    public static Character[] convertArr(char[] arr){
        Character[] array = new Character[arr.length];
        for(int i = 0; i < arr.length; i++){
            array[i] = arr[i];
        }
        return array;
    }
    public static boolean identical(Object obj1, Object obj2){
        return obj1.equals(obj2);
    }

}
