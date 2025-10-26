# Сортировка выбором
def selection_sort(array):
    n = len(array)
    
    for i in range(n - 1):
        min_index = i
        
        for j in range(i + 1, n):
            if array[j] < array[min_index]:
                min_index = j
        
        array[i], array[min_index] = array[min_index], array[i]

def selection_sort_demo():
    example_array = [64, 25, 12, 22, 11]
    
    print("Исходный массив:")
    print_array(example_array)
    
    selection_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Сортировка пузырьком
def bubble_sort(array):
    n = len(array)
    
    for i in range(n - 1):
        swapped = False
        
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
                swapped = True
        
        if not swapped:
            break

def bubble_sort_demo():
    example_array = [64, 34, 25, 12, 22, 11]
    
    print("Исходный массив:")
    print_array(example_array)
    
    bubble_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Сортировка вставками
def insertion_sort(array):
    n = len(array)
    
    for i in range(1, n):
        key = array[i]
        j = i - 1
        
        while j >= 0 and array[j] > key:
            array[j + 1] = array[j]
            j -= 1
        
        array[j + 1] = key

def insertion_sort_demo():
    example_array = [12, 11, 13, 5, 6]
    
    print("Исходный массив:")
    print_array(example_array)
    
    insertion_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Сортировка слиянием
def merge_sort(array):
    if len(array) <= 1:
        return array
    
    mid = len(array) // 2
    left_half = array[:mid]
    right_half = array[mid:]
    
    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)
    
    return merge(left_half, right_half)

def merge(left, right):
    result = []
    i = j = 0
    
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    
    result.extend(left[i:])
    result.extend(right[j:])
    
    return result

def merge_sort_demo():
    example_array = [38, 27, 43, 3, 9, 82, 10]
    
    print("Исходный массив:")
    print_array(example_array)
    
    sorted_array = merge_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(sorted_array)


# Сортировка Шелла
def shell_sort(array):
    n = len(array)
    
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = array[i]
            j = i
            
            while j >= gap and array[j - gap] > temp:
                array[j] = array[j - gap]
                j -= gap
            
            array[j] = temp
        
        gap //= 2

def shell_sort_demo():
    example_array = [23, 12, 1, 8, 34, 56, 7]
    
    print("Исходный массив:")
    print_array(example_array)
    
    shell_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Быстрая сортировка
def quick_sort(array, low=0, high=None):
    if high is None:
        high = len(array) - 1
    
    if low < high:
        pi = partition(array, low, high)
        
        quick_sort(array, low, pi - 1)
        quick_sort(array, pi + 1, high)

def partition(array, low, high):
    pivot = array[high]
    i = low - 1
    
    for j in range(low, high):
        if array[j] <= pivot:
            i += 1
            array[i], array[j] = array[j], array[i]
    
    array[i + 1], array[high] = array[high], array[i + 1]
    return i + 1

def quick_sort_demo():
    example_array = [10, 7, 8, 9, 1, 5]
    
    print("Исходный массив:")
    print_array(example_array)
    
    quick_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Пирамидальная сортировка
def heap_sort(arr):
    n = len(arr)
    
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

def heapify(arr, size, root_index):
    largest = root_index
    left_child = 2 * root_index + 1
    right_child = 2 * root_index + 2
    
    if left_child < size and arr[left_child] > arr[largest]:
        largest = left_child
    
    if right_child < size and arr[right_child] > arr[largest]:
        largest = right_child
    
    if largest != root_index:
        arr[root_index], arr[largest] = arr[largest], arr[root_index]
        heapify(arr, size, largest)

def heap_sort_demo():
    example_array = [12, 11, 13, 5, 6, 7]
    
    print("Исходный массив:")
    print_array(example_array)
    
    heap_sort(example_array)
    
    print("\nОтсортированный массив:")
    print_array(example_array)


# Линейный поиск
def linear_search(array, target):
    for i in range(len(array)):
        if array[i] == target:
            return i
    return -1

def linear_search_demo():
    data = [3, 8, 1, 10, 5]
    key = 10
    result = linear_search(data, key)
    
    if result != -1:
        print(f"Элемент {key} найден на индексе {result}")
    else:
        print(f"Элемент {key} не найден")


# Бинарный поиск
def binary_search(array, target):
    low = 0
    high = len(array) - 1
    
    while low <= high:
        mid = low + (high - low) // 2
        
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    
    return -1

def binary_search_demo():
    sorted_array = [1, 3, 5, 7, 9, 11]
    search_key = 7
    index = binary_search(sorted_array, search_key)
    
    if index != -1:
        print(f"Значение {search_key} найдено на индексе {index}")
    else:
        print(f"Значение {search_key} не найдено в массиве.")


# Интерполяционный поиск
def interpolation_search(array, target):
    low = 0
    high = len(array) - 1
    
    while low <= high and target >= array[low] and target <= array[high]:
        if low == high:
            if array[low] == target:
                return low
            return -1
        
        pos = low + ((high - low) // (array[high] - array[low])) * (target - array[low])
        pos = min(max(pos, low), high)
        
        if array[pos] == target:
            return pos
        elif array[pos] < target:
            low = pos + 1
        else:
            high = pos - 1
    
    return -1

def interpolation_search_demo():
    sorted_array = [10, 15, 20, 25, 30, 35, 40, 45, 50]
    search_key = 35
    index = interpolation_search(sorted_array, search_key)
    
    if index != -1:
        print(f"Значение {search_key} найдено на индексе {index}")
    else:
        print(f"Значение {search_key} не найдено в массиве.")


# Поиск Фибоначчи
def fibonacci_search(array, x):
    n = len(array)
    
    fib_m2 = 0
    fib_m1 = 1
    fib_m = fib_m2 + fib_m1
    
    while fib_m < n:
        fib_m2 = fib_m1
        fib_m1 = fib_m
        fib_m = fib_m2 + fib_m1
    
    offset = -1
    
    while fib_m > 1:
        i = min(offset + fib_m2, n - 1)
        
        if array[i] < x:
            fib_m = fib_m1
            fib_m1 = fib_m2
            fib_m2 = fib_m - fib_m1
            offset = i
        elif array[i] > x:
            fib_m = fib_m2
            fib_m1 = fib_m1 - fib_m2
            fib_m2 = fib_m - fib_m1
        else:
            return i
    
    if fib_m1 and offset + 1 < n and array[offset + 1] == x:
        return offset + 1
    
    return -1

def fibonacci_search_demo():
    sorted_array = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
    x = 85
    result = fibonacci_search(sorted_array, x)
    
    if result != -1:
        print(f"Элемент {x} найден на индексе {result}")
    else:
        print(f"Элемент {x} не найден в массиве.")


# Вспомогательная функция для вывода массива
def print_array(arr):
    print(' '.join(map(str, arr)))


# Демонстрация всех алгоритмов
if __name__ == "__main__":
    print("=== СОРТИРОВКА ВЫБОРОМ ===")
    selection_sort_demo()
    
    print("\n=== СОРТИРОВКА ПУЗЫРЬКОМ ===")
    bubble_sort_demo()
    
    print("\n=== СОРТИРОВКА ВСТАВКАМИ ===")
    insertion_sort_demo()
    
    print("\n=== СОРТИРОВКА СЛИЯНИЕМ ===")
    merge_sort_demo()
    
    print("\n=== СОРТИРОВКА ШЕЛЛА ===")
    shell_sort_demo()
    
    print("\n=== БЫСТРАЯ СОРТИРОВКА ===")
    quick_sort_demo()
    
    print("\n=== ПИРАМИДАЛЬНАЯ СОРТИРОВКА ===")
    heap_sort_demo()
    
    print("\n=== ЛИНЕЙНЫЙ ПОИСК ===")
    linear_search_demo()
    
    print("\n=== БИНАРНЫЙ ПОИСК ===")
    binary_search_demo()
    
    print("\n=== ИНТЕРПОЛЯЦИОННЫЙ ПОИСК ===")
    interpolation_search_demo()
    
    print("\n=== ПОИСК ФИБОНАЧЧИ ===")
    fibonacci_search_demo()