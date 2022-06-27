package collections;
import java.util.Arrays;

/** Гац Сергей, Курс JAVA DEVELOPER
 * В этом классе MyArrayList мною реализован интерфейс MyList
 * который в приближении аналогичен встроенному в Java Collection Framework - ArrayList.
 * Интерфейс взаимодействия с экземпляром MyArrayList включает такие методы:
 *  add(T element): добавление элемента,
 *  addAtIndex(int index, T element): добавление элемента в конкретное место по индексу,
 *  get(int index): получение значения элемента по указанному индексу,
 *  contains(T element): проверка на наличие содержания елемента,
 *  clear(): удаления всех елементов,
 *  removeAtIndex(int index): удаление элемента в конкретном месте по индексу,
 *  size(): получение общего количества ячеек памяти (количества обьектов) которые заполнены,
 *  toSeeAll(): показывает реальное состояние полностью под капотом,
 *  getFirstElement(): получение первого елемента,
 *  getLastElement(): получение последнего елемента,
 *  set(int index, T element): редактирования записи в конкретном месте по индексу,
 *  boolean isEmpty(): проверка на пустоту,
 *  addAll(T... element): добавление сразу всех елементов.
 *  Также добавлена возможность создавать экземпляры MyArrayList с пользовательским размером= int userSize (по дефолту = 10).
 */

public class MyArrayList <T> implements MyList <T>{
    private static final int DEFAULT_SIZE = 10;
    private Object[] arr;  // private T [] arr = new T[SIZE] - так не работает;
    private int cursor = 0;

    /**
     * Конструктор по дефолту MyArrayList с размерность = 10.
     */
    public MyArrayList() {
        arr = new Object[DEFAULT_SIZE];
    }

    /**
     * Конструктор создания MyArrayList с размеростью заданой пользователем = int userSize.
     */
    public MyArrayList(int userSize) {
        if (userSize <= 0) {
            throw new IllegalArgumentException();
        } else {
            arr = new Object[userSize];
        }
    }

    /**
     * Метод добавления элемента в MyArrayList, а именно в его конец.
     * В случае если MyArrayList заполнен более чем на 75%, вызывается метод resizeArray().
     */
    @Override
    public void add(T element) {
        if (arr.length * 0.75 < cursor) {
            resizeArray();                           // вызываем метод увеличения размера массива
        }
        arr[cursor] = element;
        cursor++;
    }

    /**
     * Метод увеличения размера MyArrayList в 2 раза от заполненого значения
     */
    private void resizeArray() {
        Object[] tempArr = new Object[cursor * 2];                     // создаем новый массив с размерность х2 от имеющегося заполненого
        System.arraycopy(arr, 0, tempArr, 0, arr.length); //cursor // копируем в новый массив с увеличеной размерность старый массив с меньшей размерностью
        arr = tempArr;                                              // присваиваем ссылке на старый массив - новый массив
    }

    /**
     * Метод добавления элемента в MyArrayList в конкретное место по индексу
     */
    @Override
    public void addAtIndex(int index, T element) {
        if (index > cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Object[] tempArr = new Object[arr.length + 1];                         //создаем новый массив с размерность +1 от старого
            System.arraycopy(arr, 0, tempArr, 0, index);         // копируем в новый массив часть старого по указаный индекс
            tempArr[index] = element;                                         // присваиваем вставляемый елемент новому массиву под указаным индексом
            System.arraycopy(arr, index, tempArr, index + 1, arr.length - index);   // копируем в новый массив вторую часть старого массива с указаного индекса
            arr = tempArr;                                                   // присваиваем ссылке на старый массив - новый массив
            cursor++;
        }
    }

    /**
     * Метод для получения значения элемента в MyArrayList по указанному индексу.
     */
    @SuppressWarnings("unchecked")                        // говорим о том что понимаем что делаем с down кастингом (T) arr[index]
    @Override
    public T get(int index) {
        if (index >= cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) arr[index];
        }
    }

    /**
     * Метод проверки содержания елемента в MyArrayList.
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < cursor; i++) {
            if (element.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * - метод удаления всех елементов в MyArrayList
     */
    @Override
    public void clear() {
        arr = new Object[DEFAULT_SIZE];
        cursor = 0;
    }

    /**
     * Метод удаления элемента в MyArrayList в конкретном месте по индексу
     */
    @Override
    public void removeAtIndex(int index) {
        if (index >= cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Object[] tempArr = new Object[arr.length - 1];                         //создаем новый массив с размерность в = -1 от старого
            System.arraycopy(arr, 0, tempArr, 0, index);         // копируем в новый массив часть старого по указаный индекс
            System.arraycopy(arr, index + 1, tempArr, index, (arr.length - index - 1));   // копируем в новый массив вторую часть старого массива пропуская указанный индекс
            arr = tempArr;                                                   // присваиваем ссылке на старый массив - новый массив
            cursor--;
        }
    }

    /**
     * Метод получения общего количества ячеек памяти (количества обьектов) в MyArrayList которые заполнены.
     */
    @Override
    public int size() {
        return cursor;
    }

    /**
     * Метод показывающий реальное состояние MyArrayList полностью под капотом.
     */
    @Override
    public String toSeeAll() {
        return "collections.MyList{" +
                "arr=" + Arrays.toString(arr) +
                ", cursor=" + cursor + ", lenght=" + arr.length +
                '}';
    }

    /**
     * Метод получения первого елемента в MyArrayList.
     */
    @SuppressWarnings("unchecked")                       // говорим о том что понимаем что делаем с down кастингом (T) arr[0]
    @Override
    public T getFirstElement() {
        if (cursor == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) arr[0];
        }
    }

    /**
     * Метод получения последнего елемента в MyArrayList.
     */
    @SuppressWarnings("unchecked")                       // говорим о том что понимаем что делаем с down кастингом (T) arr[cursor - 1]
    @Override
    public T getLastElement() {
        if (cursor == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) arr[cursor - 1];
        }
    }

    /**
     * Метод редактирования по индексу в MyArrayList.
     */
    @Override
    public void set(int index, T element) {
        if (index > cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = element;
        }
    }

    /**
     * Метод проверки на пустоту в MyArrayList.
     */
    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    /**
     * Метод добавления сразу всех елементов в MyArrayList.
     */
    @SuppressWarnings("unchecked")                       // подавляем предупреждение о методе с переменним числом аргументов, который по сути является типизированным массивом на создание который существуют ограничения
    @Override
    public void addAll(T... element) {
        for (T e : element) {
            add(e);
        }
    }

    /**
     * Метод показывающий содержимое MyArrayList.
     */
    @Override
    public String toString() {
        if (cursor == 0) {
            return "[]";
        }
        int iMax = cursor - 1;
        StringBuilder strbild = new StringBuilder();
        strbild.append('[');
        for (int i = 0; ; i++) {
            strbild.append(arr[i]);
            if (i == iMax) {
                strbild.append(']');
                return strbild.toString();
            }
            strbild.append(", ");
        }
    }
}
