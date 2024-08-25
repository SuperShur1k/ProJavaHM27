package org.example.lesson27.hw;

// Создайте конструктор со всеми полями
//и метод toString который возвращает строку со значениями всех полей.
//С помощью Reflection API создайте экземпляр  класса Course через
// ссылку на рефлексионный конструктор.
//С помощью Reflection API вызовите у экземпляра класса метод
// toString и выведите на экран его результат

import java.lang.reflect.Field;

public class Course {
    @Fake(value = "hello 123")
    private String specialization;
    private int duration;
    private double price;

    public Course(String specialization, int duration, double price) {
        this.specialization = specialization;
        this.duration = duration;
        this.price = price;
    }

    @Override
    public String toString() {

        // В toString в Course используйте value() из аннотации Fake вместо значения specialization если value() не пусто
        Class clazz = this.getClass();
        String alternativeSpecialization = "";
        try {
            Field specializationField = clazz.getDeclaredField("specialization");
            Fake fake = specializationField.getAnnotation(Fake.class);
            alternativeSpecialization = fake.value();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return "Course{" +
            "specialization='" + (!alternativeSpecialization.equals("") ? alternativeSpecialization : specialization) + '\'' +
            ", duration=" + duration +
            ", price=" + price +
            '}';
    }
}
