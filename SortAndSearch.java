//Сортировка выбором 

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // Проходим по всем элементам массива, кроме последнего
        for (int i = 0; i < arr.length - 1; i++) {
            // Предполагаем, что минимальный элемент находится на текущей позиции i
            int minIndex = i;
            
            // Ищем минимальный элемент в оставшейся части массива
            for (int j = i + 1; j < arr.length; j++) {
                // Если находим элемент меньше текущего минимального
                if (arr[j] < arr[minIndex]) {
                    // Обновляем индекс минимального элемента
                    minIndex = j;
                }
            }
            
            // Если минимальный элемент не на своем месте, меняем их местами
            if (minIndex != i) {
                int temp = arr[i];      // Сохраняем текущий элемент во временной переменной
                arr[i] = arr[minIndex]; // Заменяем текущий элемент минимальным
                arr[minIndex] = temp;   // Заменяем минимальный элемент сохраненным
            }
        }
    }
}

//сортировка обменом 

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Получаем длину массива
        
        // Внешний цикл - количество проходов по массиву
        for (int i = 0; i < n - 1; i++) {
            // Внутренний цикл - сравнение соседних элементов
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего
                if (arr[j] > arr[j + 1]) {
                    // Меняем элементы местами
                    int temp = arr[j];     // Сохраняем текущий элемент
                    arr[j] = arr[j + 1];   // Заменяем текущий элемент следующим
                    arr[j + 1] = temp;     // Заменяем следующий элемент сохраненным
                }
            }
        }
    }
}

//сортировка вставками 

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length; // Получаем длину массива
        
        // Начинаем со второго элемента (индекс 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Запоминаем текущий элемент для вставки
            int j = i - 1;    // Начинаем сравнение с предыдущего элемента
            
            // Сдвигаем элементы большие key вправо
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Сдвигаем элемент вправо
                j = j - 1;           // Переходим к следующему элементу слева
            }
            
            // Вставляем key на правильную позицию
            arr[j + 1] = key;
        }
    }
}

//сортировка слиянием 

public class MergeSort {
    // Основной метод сортировки
    public static void mergeSort(int[] arr, int left, int right) {
        // Если левая граница меньше правой (есть что сортировать)
        if (left < right) {
            // Находим среднюю точку для разделения массива
            int mid = left + (right - left) / 2;
            
            // Рекурсивно сортируем левую половину
            mergeSort(arr, left, mid);
            
            // Рекурсивно сортируем правую половину
            mergeSort(arr, mid + 1, right);
            
            // Объединяем отсортированные половины
            merge(arr, left, mid, right);
        }
    }
    
    // Метод для слияния двух отсортированных массивов
    private static void merge(int[] arr, int left, int mid, int right) {
        // Вычисляем размеры временных массивов
        int n1 = mid - left + 1; // Размер левого подмассива
        int n2 = right - mid;    // Размер правого подмассива
        
        // Создаем временные массивы
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Индексы для временных массивов и основного массива
        int i = 0, j = 0, k = left;
        
        // Сливаем временные массивы обратно в основной массив
        while (i < n1 && j < n2) {
            // Выбираем меньший элемент из двух массивов
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i]; // Берем элемент из левого массива
                i++;                 // Переходим к следующему элементу левого массива
            } else {
                arr[k] = rightArr[j]; // Берем элемент из правого массива
                j++;                  // Переходим к следующему элементу правого массива
            }
            k++; // Переходим к следующей позиции в основном массиве
        }
        
        // Копируем оставшиеся элементы левого массива (если есть)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        // Копируем оставшиеся элементы правого массива (если есть)
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}

//сортировка Шелла

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length; // Получаем длину массива
        
        // Начинаем с большого промежутка, затем уменьшаем его
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Выполняем сортировку вставками для этого промежутка
            for (int i = gap; i < n; i++) {
                // Сохраняем arr[i] во временной переменной
                int temp = arr[i];
                int j;
                
                // Сдвигаем элементы, пока не найдем правильную позицию для arr[i]
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap]; // Сдвигаем элемент на gap позиций
                }
                
                // Вставляем сохраненный элемент в правильную позицию
                arr[j] = temp;
            }
        }
    }
}

//быстрая сортировка 

public class QuickSort {
    // Основной метод быстрой сортировки
    public static void quickSort(int[] arr, int low, int high) {
        // Если есть что сортировать (low < high)
        if (low < high) {
            // Разделяем массив и получаем индекс опорного элемента
            int pi = partition(arr, low, high);
            
            // Рекурсивно сортируем элементы до опорного
            quickSort(arr, low, pi - 1);
            
            // Рекурсивно сортируем элементы после опорного
            quickSort(arr, pi + 1, high);
        }
    }
    
    // Метод для разделения массива
    private static int partition(int[] arr, int low, int high) {
        // Выбираем последний элемент как опорный
        int pivot = arr[high];
        
        // Индекс меньшего элемента (указывает на правильную позицию опорного)
        int i = low - 1;
        
        // Проходим по всем элементам от low до high-1
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j] <= pivot) {
                i++; // Увеличиваем индекс меньшего элемента
                
                // Меняем местами arr[i] и arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Помещаем опорный элемент на правильную позицию
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // Возвращаем позицию опорного элемента
        return i + 1;
    }
}

//пирамидальная сортировка 

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length; // Получаем длину массива
        
        // Построение max-heap (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Извлекаем элементы из кучи один за другим
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }
    
    // Преобразование поддерева в max-heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;        // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1;   // Левый дочерний элемент
        int right = 2 * i + 2;  // Правый дочерний элемент
        
        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Если правый дочерний элемент больше текущего наибольшего
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // Если наибольший элемент не корень
        if (largest != i) {
            // Меняем местами корень и наибольший элемент
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Рекурсивно преобразуем затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}

//последовательный поиск 

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        // Проходим по всем элементам массива
        for (int i = 0; i < arr.length; i++) {
            // Если нашли целевой элемент
            if (arr[i] == target) {
                return i; // Возвращаем индекс найденного элемента
            }
        }
        
        // Если элемент не найден, возвращаем -1
        return -1;
    }
}

//бинарный поиск 

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;                    // Левая граница поиска
        int right = arr.length - 1;      // Правая граница поиска
        
        // Пока левая граница не превысила правую
        while (left <= right) {
            int mid = left + (right - left) / 2; // Находим середину
            
            // Если элемент в середине равен целевому
            if (arr[mid] == target) {
                return mid; // Возвращаем индекс
            }
            
            // Если целевой элемент меньше среднего
            if (arr[mid] > target) {
                right = mid - 1; // Ищем в левой половине
            } else {
                left = mid + 1;  // Ищем в правой половине
            }
        }
        
        // Если элемент не найден
        return -1;
    }
}

//интерполирующий поиск 

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;                    // Нижняя граница
        int high = arr.length - 1;      // Верхняя граница
        
        // Пока целевой элемент находится между границами и границы не совпали
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Если границы совпали
            if (low == high) {
                // Если элемент найден, возвращаем индекс
                if (arr[low] == target) {
                    return low;
                }
                return -1; // Иначе возвращаем -1
            }
            
            // Вычисляем позицию с помощью интерполяционной формулы
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            
            // Если элемент найден
            if (arr[pos] == target) {
                return pos; // Возвращаем позицию
            }
            
            // Если целевой элемент меньше элемента в позиции pos
            if (arr[pos] > target) {
                high = pos - 1; // Ищем в левой части
            } else {
                low = pos + 1;  // Ищем в правой части
            }
        }
        
        // Если элемент не найден
        return -1;
    }
}

//поиск Фибоначчи 

public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length; // Длина массива
        
        // Инициализируем числа Фибоначчи
        int fibMMm2 = 0;          // (m-2)-е число Фибоначчи
        int fibMMm1 = 1;          // (m-1)-е число Фибоначчи
        int fibM = fibMMm2 + fibMMm1; // m-е число Фибоначчи
        
        // Находим наименьшее число Фибоначчи, большее или равное n
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }
        
        int offset = -1; // Отметка об исключенном диапазоне
        
        // Пока есть элементы для проверки
        while (fibM > 1) {
            // Проверяем, valid ли fibMMm2
            int i = Math.min(offset + fibMMm2, n - 1);
            
            // Если target больше значения в i, отсекаем подмассив от offset до i
            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }
            // Если target меньше значения в i, отсекаем подмассив после i
            else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }
            // Элемент найден
            else {
                return i;
            }
        }
        
        // Сравниваем последний элемент
        if (fibMMm1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }
        
        // Элемент не найден
        return -1;
    }
}
