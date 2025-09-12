// создание списка
import java.util.ArrayList;

public class MinimalList {
    public static void main(String[] args) {
        
        ArrayList<String> fruits = new ArrayList<>();
        
        
        fruits.add("Яблоко");
        fruits.add("Груша");
        fruits.add("Вишня");
        
        
        System.out.println(fruits);
    }
}


// создание стека 
import java.util.Stack;

public class MinimalStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        stack.push("Первый");
        stack.push("Второй");
        stack.push("Третий");
        
        System.out.println("Стек: " + stack);
        System.out.println("Верхний: " + stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println("Извлекли: " + stack.pop());
        }
    }
}