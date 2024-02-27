import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ////////БАЗОВАЯ СЛОЖНОСТЬ////////////
        ////////////////////////////////////
        //Создал массив типа Employee
        Employee[] info = new Employee[10];
        info[0] = new Employee("Ivanov Ivan Ivanovich", 20_000, 1);
        info[1] = new Employee("Petrov Petr Petrovich", 50_000, 1);
        info[2] = new Employee("Sergeev Sergei Sergeevich", 40_000, 3);
        info[3] = new Employee("Denisov Denis Denisovich", 60_000, 3);
        info[4] = new Employee("Abrikosov Dmitriy Borisovich", 100_000, 2);
        info[5] = new Employee("Kulikov Stepan Ivanovich", 70_000, 2);
        info[6] = new Employee("Sidorov Mihail Mihailovich", 30_000, 4);
        info[7] = new Employee("Plahov Oleg Olegovich", 90_000, 4);
        info[8] = new Employee("Mironov Nikita Aleksandrovich", 150_000, 5);
        info[9] = new Employee("Sundukov Aleksei Evgenevich", 10_000, 5);
        //Вызываем метод для " Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString));"
        System.out.println(Arrays.toString(info));
        //Вызываем метод для "Посчитать сумму затрат на ЗП в месяц"
        double totalSalary = Employee.countSumSalary(info);
        System.out.println("Сумма затрат на ЗП в месяц = " + totalSalary);
      /*  ////Вызываем метод для "Найти сотрудника с минимальной ЗП;"
        Employee personWithMinSalary = Employee.findPersonWithMinSalary(info);
        //double minSalary = Employee.minSalary(info);*/
        // System.out.println("minSalary = " + minSalary);
        double maxSalary = Employee.maxSalary(info);
        // System.out.println("maxSalary = " + maxSalary);
        //Вызываем метод для "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
        double middleSalary = Employee.countMiddleSalary(info);
        System.out.println("Среднее значение зарплат = " + middleSalary);
        //Вызываем метод для "Распечатать ФИО всех сотрудников (метод ничего)."
        Employee.printFullName(info);
        //////////////////////ПОВЫШЕННАЯ СЛОЖНОСТЬ//////////////////
        ///////////////////////////////////////////////////////////
        //Вызываем метод для "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
        double percentForEveryonePerson = 0;//для второго задания (индексация сотрудников)
        Employee.changeSalaryOnPercent(info, percentForEveryonePerson);
        // System.out.println("info[4].getSalary() = " + info[4].getSalary());
        //Назначаем номер отдела для отбора сотрудников по отделам
        int numberDepartment = 1;// nomberDepartment может быть от 1 до 5 включительно
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Сумму затрат на зп по отделу;
        Employee.countTotalSalaryInDepartment(info, numberDepartment);
        System.out.println("Сумма затрат на зп по отделу " + numberDepartment + " равна " + Employee.countTotalSalaryInDepartment(info, numberDepartment));
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        Employee.countMiddleSalaryInDepartment(info, numberDepartment);
        System.out.println("Средняя зп по отделу " + numberDepartment + " равна " + Employee.countMiddleSalaryInDepartment(info, numberDepartment));
        //Вводим процент индексации зарплаты сотрудноков в отделе
        double percentUpSalaryInDepartment = 10;
        //Вызываем метод для "Получить в качестве параметра номер отдела (1-5) и найти"
        ////Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;


        //Назначаем число для отбора сотрудников по зарплате больше/меньше salaryForSelectionEmployees
        double salaryForSelectionEmployees = 18_000;
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        Employee.findPersonsWithSalaryLessSalaryForSelectionEmployees(info, salaryForSelectionEmployees);
        //Вызываем метод для "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        Employee.findPersonsWithSalaryMoreSalaryForSelectionEmployees(info, salaryForSelectionEmployees);
    }
}

//Создал класс Employee с полями ФИО, зарплата, отдел, id, переменную счетчик
class Employee {
    private String fullName;
    private double salary;
    private int department;
    private int id;
    static int counter = 1;

    //Создал конструктор класса Employee
    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        id = counter++;
    }

    //Создал геттер id
    public int getId() {
        return this.id;
    }

    //Создал геттер fullName
    public String getFullName() {
        return this.fullName;
    }

    //Создал сеттер salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Создал геттер salary
    public double getSalary() {
        return this.salary;
    }

    //Создал сеттер department
    public void setDepartment(int department) {
        this.department = department;
    }

    //Создал геттер department
    public int getDepartment() {
        return this.department;
    }

    //Создал метод "Получить список всех сотрудников со всеми имеющимися по ним данными
    // (вывести в консоль значения всех полей (toString));"
    public String toString() {
        return "id =" + id + ", ФИО =" + fullName + ", зарплата =" + salary + ", отдел =" + department;
    }

    //Создал метод "Посчитать сумму затрат на ЗП в месяц"
    public static double countSumSalary(Employee[] info) {
        double totalSalary = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            totalSalary = info[i].getSalary() + totalSalary;
        }
        return totalSalary;
    }

    //Создал метод "Найти сотрудника с минимальной ЗП;"
   /* public static Employee findPersonWithMinSalary(Employee[] info) {
        double minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (minSalary > info[i].getSalary()) {
                minSalary = info[i].getSalary();
            }
        }
        return i;
    }*/
   /* public static double maxSalary(Employee[] info) {
        double maxlSalary = Integer.MIN_VALUE;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (maxlSalary < info[i].getSalary()) {
                maxlSalary = info[i].getSalary();
            }
        }
        return maxlSalary;
    }*/

    //Создал метод "Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);"
    public static double countMiddleSalary(Employee[] info) {
        int count = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            count += 1;
        }
        double middleSalary = Employee.countSumSalary(info) / count;
        return middleSalary;
    }

    //Создал метод "Распечатать ФИО всех сотрудников (метод ничего)."
    public static void printFullName(Employee[] info) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            System.out.println(info[i].getFullName());
        }
    }

    //Создал метод "Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)"
    public static void changeSalaryOnPercent(Employee[] info, double percentForEveryonePerson) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            info[i].setSalary(info[i].getSalary() * (1 + percentForEveryonePerson / 100));
        }
    }
    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
//Сотрудника с минимальной зп;


    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
//Сотрудника с максимальной зп;


    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
//Сумму затрат на зп по отделу;
    public static double countTotalSalaryInDepartment(Employee[] info, int numberDepartment) {
        double sumSalary = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                sumSalary = sumSalary + info[i].getSalary();
            } else {
                continue;
            }
        }
        return sumSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
//Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static double countMiddleSalaryInDepartment(Employee[] info, int numberDepartment) {
        double middleSalary;
        int count = 0;
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                count += 1;
            } else {
                continue;
            }
        }
        middleSalary = Employee.countTotalSalaryInDepartment(info, numberDepartment) / count;
        return middleSalary;
    }

    //Создал метод "Получить в качестве параметра номер отдела (1-5) и найти"
//Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public static void upPercentInDepartment(Employee[] info, int numberDepartment, double percentUpSalaryInDepartment) {
        for (int i = 0; i < info.length && info[i] != null; i++) {
            if (info[i].getDepartment() == numberDepartment) {
                info[i].setSalary(info[i].getSalary() * (1 + percentUpSalaryInDepartment / 100));
            } else {
                continue;
            }
        }
    }
        //Создал метод "Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);"
        public static void findPersonsWithSalaryLessSalaryForSelectionEmployees (Employee[]info,
        double salaryForSelectionEmployees){
            System.out.println("Сотрудники с зарплатой <" + salaryForSelectionEmployees + " :");
            for (int i = 0; i < info.length && info[i] != null; i++) {
                if (info[i].getSalary() < salaryForSelectionEmployees) {
                    System.out.print("id " + info[i].getId() + ", ");
                    System.out.print("ФИО " + info[i].getFullName() + ", ");
                    System.out.print("зарплата " + info[i].getSalary());
                    System.out.println();
                } else {
                    continue;
                }
            }
        }

        //Создал метод "Получить в качестве параметра число и вывести:
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)."
        public static void findPersonsWithSalaryMoreSalaryForSelectionEmployees (Employee[]info,
        double salaryForSelectionEmployees){
            System.out.println("Сотрудники с зарплатой >=" + salaryForSelectionEmployees + " :");
            for (int i = 0; i < info.length && info[i] != null; i++) {
                if (info[i].getSalary() >= salaryForSelectionEmployees) {
                    System.out.print("id " + info[i].getId() + ", ");
                    System.out.print("ФИО " + info[i].getFullName() + ", ");
                    System.out.print("зарплата " + info[i].getSalary());
                    System.out.println();
                } else {
                    continue;
                }
            }
        }
    }