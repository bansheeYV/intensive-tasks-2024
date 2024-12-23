package com.walking.intensive.chapter3.task13;

/**
 * Ваша задача - с помощью лейки полить все растения в саду.
 * Всего в саду N растений. Они расположены в ряд и слева направо помечены
 * от 0 до N-1. Таким образом i-е растение расположено в точке x = i.
 *
 * <p>В точке x = -1 есть река, в которой вы можете наполнить свою лейку.
 *
 * <p>Каждому растению требуется определенное количество воды.
 * Полив растений производится следующим образом:
 *
 * <ol>
 * <li>Растения поливаются в порядке слева направо;
 * <li>Если после полива текущего растения, в лейке недостаточно воды, чтобы ПОЛНОСТЬЮ полить следующее растение,
 *      вы должны вернуться к реке, чтобы полностью наполнить лейку;
 * <li>Вы не можете наполнять лейку раньше времени. Единственный путь к реке - это выполнение пункта 2.
 * </ol>
 *
 * <p>Изначально вы находитесь у реки, то есть ваше положение - x = -1.
 * Для перемещения к соседнему растению требуется один шаг.
 *
 * <p>Для расчета количества шагов, необходимых для полива всех растений, реализуйте метод getStepsCount().
 *
 * <p>Входящие параметры метода:
 *
 * <ol>
 * <li>Массив целых чисел, где каждый элемент обозначает объем воды, необходимый соответствующему растению.
 *      Индекс массива - номер растения в саду. Растение не может требовать для полива менее 1 единицы воды;
 * <li>Объем лейки. Обозначен целым числом. Объем лейки не может быть отрицателен или равен нулю.
 * </ol>
 *
 * <p>Возвращаемое значение метода - количество шагов, необходимых для полива всех растений.
 *
 * <p>Пример:
 *
 * <p>Входящие параметры: [2,2,3,3], 5
 *
 * <p>Возвращаемое значение: 14
 *
 * <p>Если сад пуст - количество шагов для его полива равно 0.
 *
 * <p>При наличии некорректных входных данных верните -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task13 {
    public static void main(String[] args) {
        int[] plants = new int[] {2,2,3,3};
        int wateringCanVolume = 5;
        System.out.println(getStepsCount(plants, wateringCanVolume));
    }

    static int getStepsCount(int[] plants, int wateringCanVolume) {
        if (!isValid(plants, wateringCanVolume)) {
            return -1;
        }

        if (plants.length == 0) {
            return 0;
        }

        int stepsCount = 0;
        int currentVolumeOfWater = wateringCanVolume;

        for (int i = 0; i < plants.length; i++) {

            currentVolumeOfWater -= plants[i];
            stepsCount++;

            if (i < plants.length - 1 && currentVolumeOfWater < plants[i + 1]) {
                stepsCount += (i + 1) * 2;
                currentVolumeOfWater = wateringCanVolume;
            }
        }

        return stepsCount;
    }

    static boolean isValid(int[] plants, int wateringCanVolume) {

        for (int i = 0; i < plants.length; i++) {
            if (plants[i] < 1) {
                return false;
            }
        }

        if (wateringCanVolume < 1) {
            return false;
        }

        return true;
    }
}
