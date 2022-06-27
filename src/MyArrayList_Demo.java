import collections.MyArrayList;
import collections.MyList;
import models.Employee;
import java.util.Random;

/**
 * В этом классе тестируется на работоспособность собственная коллекция MyArrayList, и её методы
 */

public class MyArrayList_Demo {
    public static void main(String[] args) {
        System.out.println("Тест работоспособности реализованой коллекции MyArrayList, и её методов - которая является аналогом ArrayList");
        // создаем обект firstMyList класса MyArrayList с параметром <Integer>
        MyList<Integer> firstMyList = new MyArrayList<>();
        // добавим в firstMyList поочередно 30 элементов
        for (int i = 0; i < 30; i++) {
            int elem = (int) (Math.random() * 100 - 50);
            firstMyList.add(elem);
        }
        // виведем в консоль firstMyList
        System.out.println("1. " + firstMyList);
        // посмотрим размер firstMyList заполненых данными
        System.out.println("2. " + firstMyList.size());
        // удалим поочередно в firstMyList рандомные 25 элементов по их индексам
        Random rnd = new Random();
        while (firstMyList.size() != 5) {
             firstMyList.removeAtIndex(rnd.nextInt(firstMyList.size() - 1));
        }
        // виведем в консоль firstMyList
        System.out.println("3. " + firstMyList);
        // далее добавим в firstMyList сразу : 444, 555, 666
        firstMyList.addAll(444, 555, 666);
        // виведем в консоль firstMyList
        System.out.println("4. " + firstMyList);
        // добавим в firstMyList в место под индексом 2 - 10
        firstMyList.addAtIndex(2, 10);
        System.out.println("5. " + firstMyList);
        // добавим в firstMyList в место под индексом 4 - 777
        firstMyList.addAtIndex(4, 777);
        System.out.println("6. " + firstMyList);
        // глянем в реальное подкапотное состояние firstMyList
        System.out.println("7. " + firstMyList.toSeeAll());
        // посмотрим размер firstMyList заполненых данными
        System.out.println("8. " + firstMyList.size());
        // глянем в первый елемент firstMyList
        System.out.println("9. " + firstMyList.getFirstElement());
        // глянем в последний елемент firstMyList
        System.out.println("10. " + firstMyList.getLastElement());
        // проверим пустой ли firstMyList
        System.out.println("11. " + firstMyList.isEmpty());
        // очистим весь  firstMyList
        firstMyList.clear();
        // проверим пустой ли firstMyList
        System.out.println("12. " + firstMyList.isEmpty());

        // создадим обьект secondMyList класса MyArrayList с размером = 50
        MyList<Integer> secondMyList = new MyArrayList<>(50);
        secondMyList.addAll(1001, 2002, 3003, 4004, 5005);
        // виведем в консоль secondMyList
        System.out.println("13. " + secondMyList);
        // глянем в реальное подкапотное состояние secondMyList
        System.out.println("14. " + secondMyList.toSeeAll());
        // проверим есть ли в secondMyList - обект 5005
        System.out.println("15. " + secondMyList.contains(5005));
        // проверим есть ли в secondMyList - обект 7007
        System.out.println("16. " + secondMyList.contains(7007));

        // создадим более сложные обьекты obj1 obj2 obj3 obj4 класса Employee которые содержат поля (name, major, age, salary)
        Employee obj1 = new Employee("Ivan", "Senior", 25, 1500);
        Employee obj2 = new Employee("Sergey", "Direktor", 35, 1800);
        Employee obj3 = new Employee("Alex", "Junior", 20, 1000);
        Employee obj4 = new Employee("Ludmila", "Cleaning", 27, 500);
        // создаем обьект threeMyList класса MyArrayList с параметром <Employee>
        MyList<Employee> threeMyList = new MyArrayList<>();
        // далее добавим в threeMyList сразу : obj1 obj2 obj3 obj4
        threeMyList.addAll(obj1, obj2, obj3, obj4);
        // виведем в консоль threeMyList
        System.out.println("17. " + threeMyList);
        // достанем salary у сотрудника внаходящегося в threeMyList коллекции MyArrayList под индексом - 2
        System.out.println("18. " + threeMyList.get(2).getSalary());
        // достанем все salary у сотрудников находящихся в threeMyList коллекции MyArrayList
        System.out.println("19. " + "Все зарплаты сотрудников: ");
        for (int i = 0; i < threeMyList.size(); i++) {
            System.out.println("  - " + (i + 1) + ". " + threeMyList.get(i).getName() + ", зарплата: " + threeMyList.get(i).getSalary());
        }
        // совершим редактирования записи по индексу - 0 в threeMyList коллекции MyArrayList
        threeMyList.set(0, new Employee("Petr", "driver", 40, 700));
        // виведем в консоль threeMyList
        System.out.println("20. " + threeMyList);
        // посмотрим размер threeMyList заполненых данными
        System.out.println("21. " + threeMyList.size());
        // совершим редактирования под индексу - 1 , полей (name, salary) обекта Employee находящихся в threeMyList коллекции MyArrayList
        threeMyList.get(1).setName("Oksana");
        threeMyList.get(1).setSalary(1100);
        // заново достанем все salary у сотрудников находящихся в threeMyList коллекции MyArrayList
        System.out.println("22. " + "Все зарплаты сотрудников: ");
        for (int i = 0; i < threeMyList.size(); i++) {
            System.out.println("  - " + (i + 1) + ". " + threeMyList.get(i).getName() + ", зарплата: " + threeMyList.get(i).getSalary());
        }
        // удалим запись в threeMyList коллекции MyList под индексом - 2
        threeMyList.removeAtIndex(2);
        // заново достанем все salary у сотрудников находящихся в threeMyList коллекции MyArrayList
        System.out.println("23. " + "Все зарплаты сотрудников: ");
        for (int i = 0; i < threeMyList.size(); i++) {
            System.out.println("  - " + (i + 1) + ". " + threeMyList.get(i).getName() + ", зарплата: " + threeMyList.get(i).getSalary());
        }
        // создадим eще обьекты obj5 obj6 класса Employee
        Employee obj5 = new Employee("Anastasiya", "Lawyer", 34, 1700);
        Employee obj6 = new Employee("Irina", "Tester", 27, 1200);
        // добавим созданные обекты obj5 obj6 поочередно в в threeMyList коллекции MyArrayList
        threeMyList.add(obj5);
        threeMyList.add(obj6);
        // заново достанем все salary у всех сотрудников находящихся в threeMyList коллекции MyList
        System.out.println("24. " + "Все зарплаты сотрудников: ");
        for (int i = 0; i < threeMyList.size(); i++) {
            System.out.println("  - " + (i + 1) + ". " + threeMyList.get(i).getName() + ", зарплата: " + threeMyList.get(i).getSalary());
        }

    }
}
