package com.javarush.test.level15.lesson12.bonus02;

/* Template pattern
1. В отдельном файле создать класс DrinkMaker с тремя абстрактными методами:
- void getRightCup() - выбрать подходящую чашку
- void putIngredient() - положить ингредиенты
- void pour() - залить жидкостью
2. В классе DrinkMaker создать и реализовать метод void makeDrink(), который готовит напиток в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.
3. В отдельных файлах создать классы LatteMaker и TeaMaker, которые наследуются от DrinkMaker.
4. Распредели следующие фразы между всеми методами в классах LatteMaker и TeaMaker, различные фразы для различных методов.
5. Каждый метод должен выводить в консоль свою фразу не пересекаясь с другими методами.
6. Фразы:
--"Заливаем водой"
--"Берем чашку для латте"
--"Насыпаем чай"
--"Берем чашку для чая"
--"Заливаем молоком с пенкой"
"Делаем кофе"
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker latte = new LatteMaker();
        DrinkMaker tea = new TeaMaker();
        latte.makeDrink();
        tea.makeDrink();
    }
}
