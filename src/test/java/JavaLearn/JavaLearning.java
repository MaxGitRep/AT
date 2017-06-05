package JavaLearn;

import java.util.*;

public class JavaLearning {
    public static void main(String[] args) {
        Random random = new Random();
        int num[] = new int[33];

        for (int i = 0; i < 1000; i++) {
            ++num[random.nextInt(33)];
        }

        System.out.println("N\tInteger");
        for (int i = 0; i < num.length; i++) {
            //System.out.println(i + "\t" + num[i]);
        }
////////////////////////////////////////////////////////////
        String hero[] = {"Hulk", "IronMan", "SpiderMan", "Thor", "Captain"};

        for (int i = 0; i < hero.length; i++){
        //System.out.println(hero[i]);
        }

        System.out.println("Position\tValue");
////////////////////////////////////////////////////////////
        //String animals[] = {"Fox", "Dog", "Cat", "Horse", "Snake"};
        int mass[] = {12,5,86,95,47,5,3,15,4,126,8};
        int sum = 0;

        for (int all: mass){
            //System.out.println(sum += all);
        }
////////////////////////////////////////////////////////////
        int massiv[][] = {{11}, {458, 44, 786, 89, 2}, {48, 87, 9}};
        for (int i[]: massiv){
            for (int j: i){
                System.out.print(j + "\t");
            }
            System.out.println();
        }
////////////////////////////////////////////////////////////
        System.out.println("Average " + av(56, 8, 45, 95, 47, 5, 36, 54));
////////////////////////////////////////////////////////////
        JavaHelper time = new JavaHelper();
        System.out.println(time.toMilitary());

        time.setTime(15, 58, 40);
        System.out.println(time.toMilitary());

        System.out.println(time.toNormal());
////////////////////////////////////////////////////////////

        JavaHelper fff1 = new JavaHelper();
        JavaHelper fff2 = new JavaHelper(2000);
        JavaHelper fff3 = new JavaHelper(2010, 6);
        JavaHelper fff4 = new JavaHelper(2012, 8, 14);

        System.out.printf("%s\n", fff1.toDisplay());
        System.out.printf("%s\n", fff2.toDisplay());
        System.out.printf("%s\n", fff3.toDisplay());
        System.out.printf("%s\n", fff4.toDisplay());

////////////////////////////////////////////////////////////
        int tabMultiply[][] = new int[10][10];
        System.out.println("/////////////");
        boolean str[] = new boolean[5];
        System.out.println(str[2]);

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabMultiply[i][j] = (i + 1) * (j + 1);
                System.out.printf("%4d", tabMultiply[i][j]);
            }
            System.out.println();
        }
////////////////////////////////////////////////////////////
        JavaRock bd = new JavaRock(16, 2, 1975);
        JavaHelper nameBD = new JavaHelper("Rick", bd);
        System.out.println(nameBD);

////////////////////////////////////////////////////////////
        for (JavaRock.Rock heroes : JavaRock.Rock.values()){
            System.out.printf("%s - %s and %s\n", heroes, heroes.getDesc1(), heroes.getDesc2());
        }
        System.out.println("\nOpa!\n");

        for (JavaRock.Rock heroes : EnumSet.range(JavaRock.Rock.Fry, JavaRock.Rock.Spider)){
            System.out.printf("%s - %s and %s\n", heroes, heroes.getDesc1(), heroes.getDesc2());
        }
        System.out.println();

////////////////////////////////////////////////////////////
        JavaRock pers1 = new JavaRock("Super", "Man");
        JavaRock pers2 = new JavaRock("Spider", "Man");
        JavaRock pers3 = new JavaRock("Iron", "Man");

        System.out.println();
        System.out.println(pers2.getFname());
        System.out.println(pers2.getLname());
        System.out.println(JavaRock.getCount());
////////////////////////////////////////////////////////////
/*
        JavaRock finalOb = new JavaRock(7);
        for (int i = 0; i < 8; i++){
            finalOb.add();
            System.out.printf("%s", finalOb);
        }*/
////////////////////////////////////////////////////////////
        JavaRock rock = new JavaRock();
        JavaHelper help = new JavaHelper();
        rock.mult();
        help.mult();

////////////////////////////////////////////////////////////
        JavaList list = new JavaList();
        JavaM man = new JavaM();
        JavaW wom = new JavaW();
        list.add(man);
        list.add(wom);

////////////////////////////////////////////////////////////
        JavaHomo[] pers = new JavaHomo[2];
        JavaM m = new JavaM();
        JavaW w = new JavaW();
        pers[0] = m;
        pers[1] = w;
        for (JavaHomo i : pers){
            i.chel();
        }

// Создадим хеш-карточку
        Map<String, Integer> hashMap = new HashMap<String, Integer>();

// Помещаем данные на карточку
        hashMap.put("Васька", 5);
        hashMap.put("Мурзик", 8);
        hashMap.put("Рыжик", 12);
        hashMap.put("Барсик", 5);

// Получаем набор элементов
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();

// Отобразим набор
        for (Map.Entry<String, Integer> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

// Добавляем значение
        int value = hashMap.get("Рыжик");
        hashMap.put("Рыжик", value + 3);
        System.out.println("У Рыжика стало " + hashMap.get("Рыжик"));

//Сгенерируем набор случайных чисел сто раз и посчитаем количество повторов
        Random random1 = new Random(36);
        Map<Integer, Integer> hashMap1 = new HashMap<Integer, Integer>();

        for (int i = 0; i < 100; i++){
            // Создадим число от 0 до 10
            int number = random1.nextInt(10);
            Integer frequency = hashMap1.get(number);
            hashMap1.put(number, frequency == null ? 1 : frequency + 1);
        }
        System.out.println(hashMap1);
    }


    public static int av (int...num){
        int sum = 0;
        for (int i: num)
            sum += i;
        return sum/num.length;
    }


}
