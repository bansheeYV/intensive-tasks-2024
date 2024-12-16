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

        for (double angle : getAngles(3,4,5)){
            System.out.println(angle + " ");
        }
    }

    static boolean isTriangleExist (double a, double b, double c){
        if (a < 0 || b < 0 || c < 0){
            return false;
        }

        return (a + b > c && b + c > a && a + c > b);
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
        if (!isTriangleExist(a, b, c)){
            return -1;
        }

        return 0.25 * Math.sqrt(4 * a * a * b * b - (a * a + b * b - c * c) * (a * a + b * b - c * c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return new double[0];
        }

        double halfPerimetr = (a + b + c)/2;
        double sqrtParametrs = Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
        double height1 = (2/a) * sqrtParametrs;
        double height2 = (2/b) * sqrtParametrs;
        double height3 = (2/c) * sqrtParametrs;
        double[] heights = new double[]{height1, height2, height3};
        Arrays.sort(heights);
        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return new double[0];
        }

        double median1 = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
        double median2 = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
        double median3 = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
        double[] medians = new double[]{median1, median2, median3};
        Arrays.sort(medians);
        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return new double[0];
        }

        double bisectorA = Math.sqrt(b * c * (a + b + c) * (b + c - a))/(b + c);
        double bisectorB = Math.sqrt(a * c * (a + b + c) * (a + c - b))/(a + c);
        double bisectorC = Math.sqrt(a * b * (a + b + c) * (a + b - c))/(a + b);
        double[] bisectors = new double[]{bisectorA, bisectorB, bisectorC};
        Arrays.sort(bisectors);
        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return new double[0];
        }

        double angleA = Math.acos((b * b + c * c - a * a)/(2 * b * c));
        double angleB = Math.acos((a * a + c * c - b * b)/(2 * a * c));
        double angleC = Math.acos((a * a + b * b - c * c)/(2 * a * b));
        double[] angles = new double[]{Math.toDegrees(angleA), Math.toDegrees(angleB), Math.toDegrees(angleC)};
        Arrays.sort(angles);
        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return -1;
        }

        return getAreaByHeron(a, b, c)/((a + b + c)/2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isTriangleExist(a, b, c)){
            return -1;
        }

        return (a * b * c) / (getAreaByHeron(a, b, c) * 4);
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
        if (!isTriangleExist(a, b, c)){
            return -1;
        }

        double cosAngleA = (b * b + c * c - a * a)/(2 * b * c);
        double sinAngleA = Math.sqrt(1 - cosAngleA * cosAngleA);
        return (b * c * sinAngleA)/2;
    }
}
