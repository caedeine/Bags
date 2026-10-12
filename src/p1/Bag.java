package p1;

import javax.security.auth.login.AccountExpiredException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

public class Bag <E>{
    private E[] arr;
    private int nElems;
    private Class clazz;
    public Bag(Class clazz, int maxSize) {
        //arr = (E[]) new Object[maxSize]; trash actually it leads to cannot cast error later on
        arr = (E[]) Array.newInstance(clazz, maxSize);
        this.clazz = clazz;

        nElems = 0;
    }


    //ammortization, n is distrubuted so time is still O(1)
    public int size(){
        return nElems;
    }

    public E[] remove(Predicate<E> predicate){
        E[] tempArr = (E[])Array.newInstance(clazz, nElems);
        int count = 0;
        for (int i = 0; i < nElems; i++){
            if (predicate.test(arr[i])){
                tempArr[count++] = arr[i];

                for (int j = i; j< nElems-1; j++){
                    arr[j] = arr[j+1];

                }
                nElems--;
                i--;
            }
        }
        return Arrays.copyOf(tempArr, count);
    }

    public E[] search(Predicate<E> predicate){
       // E[] tempArr = (E[]) new Object[nElems];
        E[] tempArr = (E[]) Array.newInstance(clazz, nElems);
        int count = 0;
        for(int i = 0; i < nElems; i++){
            if (predicate.test(arr[i])){
                tempArr[count++] = arr[i];
            }
        }



        return Arrays.copyOf(tempArr,count);

    }

    public void add(E value){
        arr[nElems++] = value;
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            System.out.println(arr[i]);

        }
        System.out.println("------------");

    }
}
