//создание списка

#include <iostream>
#include <list>
#include <algorithm>

int main() {
    std::list<int> myList;
    
    myList.push_back(10);
    myList.push_back(20);
    myList.push_back(30);
    
    myList.push_front(5);
    myList.push_front(1);
    
    std::cout << "Список: ";
    for (int num : myList) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::cout << "Размер: " << myList.size() << std::endl;
    
    std::cout << "Первый элемент: " << myList.front() << std::endl;
    std::cout << "Последний элемент: " << myList.back() << std::endl;
    
    return 0;
}



// создание стека 

#include <iostream>
#include <stack>

int main() {
    std::stack<int> myStack;
    
    myStack.push(10);
    myStack.push(20);
    myStack.push(30);
    
    std::cout << "Верхний элемент: " << myStack.top() << std::endl;
    
    std::cout << "Извлекаем: " << myStack.top() << std::endl;
    myStack.pop();
    
    std::cout << "Теперь верхний: " << myStack.top() << std::endl;
    myStack.pop();
    
    if (myStack.empty()) {
        std::cout << "Стек пуст!" << std::endl;
    } else {
        std::cout << "В стеке еще есть элементы" << std::endl;
    }
    
    return 0;
}
