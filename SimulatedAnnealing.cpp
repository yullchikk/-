#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cmath>
#include <random>

// Функция цели
double objective_function(double x)
{
    return pow((x - 7), 2) + 5;
}

// Генерация соседнего решения путём небольшого сдвига текущего значения x
double generate_neighbor(double current_x, double max_step_size)
{
    std::default_random_engine generator(time(nullptr));
    std::uniform_real_distribution<double> distribution(-max_step_size, max_step_size);
    
    // Добавляем случайный сдвиг к текущему решению
    return current_x + distribution(generator);
}

// Имитация отжига
void simulated_annealing()
{
    const int iterations = 10000;          // Количество итераций
    const double initial_temperature = 100;// Начальная температура
    const double cooling_rate = 0.98;      // Скорость охлаждения

    std::srand(static_cast<unsigned>(std::time(nullptr)));

    // Случайное начальное значение в диапазоне [0, 20]
    double current_x = static_cast<double>(rand()) / RAND_MAX * 20;
    double best_x = current_x;
    double temperature = initial_temperature;

    for(int i = 0; i < iterations; ++i)
    {
        // Генерируем новое соседнее решение
        double new_x = generate_neighbor(current_x, 1); // Максимальный размер шага равен 1
        
        // Проверяем, находится ли оно внутри диапазона [0, 20]
        if(new_x >= 0 && new_x <= 20)
        {
            double delta = objective_function(new_x) - objective_function(current_x);
            
            // Если новый кандидат лучше, принимаем его немедленно
            if(delta < 0 || exp(-delta / temperature) > ((static_cast<double>(rand())) / RAND_MAX))
                current_x = new_x;
                
            // Обновляем лучшее решение
            if(objective_function(current_x) < objective_function(best_x))
                best_x = current_x;
        }
        
        // Уменьшаем температуру согласно заданному коэффициенту охлаждения
        temperature *= cooling_rate;
    }

    std::cout << "Минимум функции достигнут в точке x=" << best_x << ", минимальное значение: " << objective_function(best_x) << "\n";
}

int main() {
    simulated_annealing();
    return 0;
}
// пример вывода: Минимум функции достигнут в точке x=6.95183, минимальное значение: 5.00232 
