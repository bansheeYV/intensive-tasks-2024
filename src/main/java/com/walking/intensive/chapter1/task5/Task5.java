package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println(getAreaByHeron(12,13,5));
        for (double heigt : getHeights(3,4,5)){
            System.out.println(heigt + " ");
        }
        for (double median : getMedians(3,4,5)){
            System.out.println(median + " ");
        }
        for (double angle : getAngles(12,13,5)){
            System.out.println(angle + " ");
        }
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return -1;
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return -1;
        }
        return 0.25 * Math.sqrt(4*a*a*b*b - (a*a + b*b - c*c)*(a*a + b*b - c*c)); // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return new double[]{};
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return new double[]{};
        }
        double halfPerimetr = (a + b + c)/2;
        double sqrtParametrs = Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
        double h1 = (2/a) * sqrtParametrs;
        double h2 = (2/b) * sqrtParametrs;
        double h3 = (2/c) * sqrtParametrs;
        double[] heights = new double[]{h1, h2, h3};
        Arrays.sort(heights);
        return heights; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return new double[]{};
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return new double[]{};
        }
        double m1 = 0.5 * Math.sqrt(2*b*b + 2*c*c - a*a);
        double m2 = 0.5 * Math.sqrt(2*a*a + 2*c*c - b*b);
        double m3 = 0.5 * Math.sqrt(2*a*a + 2*b*b - c*c);
        double[] medians = new double[]{m1, m2, m3};
        Arrays.sort(medians);
        return medians; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return new double[]{};
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return new double[]{};
        }
        double bisA = Math.sqrt(b*c*(a + b + c)*(b + c - a))/(b + c);
        double bisB = Math.sqrt(a*c*(a + b + c)*(a + c - b))/(a + c);
        double bisC = Math.sqrt(a*b*(a + b + c)*(a + b - c))/(a + b);
        double[] bisectors = new double[]{bisA, bisB, bisC};
        Arrays.sort(bisectors);
        return bisectors; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return new double[]{};
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return new double[]{};
        }
        double angleA = Math.acos((b*b + c*c - a*a)/(2*b*c));
        double angleB = Math.acos((a*a + c*c - c*c)/(2*a*c));
        double angleC = Math.acos((a*a + b*b - c*c)/(2*a*b));
        System.out.println(180*angleB/Math.PI);
        double[] angles = new double[]{Math.toDegrees(angleA), Math.toDegrees(angleB), Math.toDegrees(angleC)};
        Arrays.sort(angles);
        return angles; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return -1;
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return -1;
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0){
            return -1;
        }
        if (a + b <= c || b + c <= a || a + c <= b){
            return -1;
        }

        return 0; // Заглушка. При реализации - удалить
    }
}
