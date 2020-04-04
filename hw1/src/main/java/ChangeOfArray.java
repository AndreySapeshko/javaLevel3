import java.util.ArrayList;

public class ChangeOfArray<T> {
    private T objT;

    public ChangeOfArray(T obj) {
        objT = obj;
    }

    public void setObjT(T objT) {
        this.objT = objT;
    }

    public T getObjT() {
        return objT;
    }

    public T[] replaceElementOfArray(T[] objArr, int place1, int place2) {
        ChangeOfArray<T> buffer = new ChangeOfArray<T>(objArr[place1]);
        objArr[place1] = objArr[place2];
        objArr[place2] = buffer.objT;

        return objArr;
    }

    public ArrayList<T> arrayToList(T[] objArr) {
        ArrayList<T> list = new ArrayList<T>(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            list.add(objArr[i]);
        }
        return list;
    }

    public ChangeOfArray<T>[] changeOfArraysToList(T[] arr) {
        ChangeOfArray<T>[] arrToList = new ChangeOfArray[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrToList[i] = new ChangeOfArray<>(arr[i]);
        }
        return arrToList;
    }
}
