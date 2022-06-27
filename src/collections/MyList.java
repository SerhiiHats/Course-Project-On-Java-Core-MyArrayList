package collections;

/** Гац Сергей, Курс JAVA DEVELOPER
 * Мною разработан интерфейс MyList
 * который в приближении аналогичен встроенному в Java Collection Framework - List.
 * Интерфейс MyList представлен такими методами:
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
 */

public interface MyList<T> {
    void add(T element);
    void addAtIndex(int index, T element);
    T get(int index);
    boolean contains(T element);
    void clear();
    void removeAtIndex(int index);
    int size();
    String toSeeAll();
    T getFirstElement();
    T getLastElement();
    void set(int index, T element);
    boolean isEmpty();
    @SuppressWarnings("unchecked")  // подавляем предупреждение на ограничения связанные с созданием типизированных массивов
    void addAll(T... element);

}
