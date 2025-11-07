#include <iostream>
#include <vector>
using namespace std;

// Структура узла дерева
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Preorder: корень → левое → правое
void preorder(TreeNode* root) {
    if (root == nullptr) return;
    cout << root->val << " ";      // Обрабатываем корень
    preorder(root->left);         // Рекурсия влево
    preorder(root->right);        // Рекурсия вправо
}

// Inorder: левое → корень → правое
void inorder(TreeNode* root) {
    if (root == nullptr) return;
    inorder(root->left);           // Рекурсия влево
    cout << root->val << " ";      // Обрабатываем корень
    inorder(root->right);          // Рекурсия вправо
}

// Postorder: левое → правое → корень
void postorder(TreeNode* root) {
    if (root == nullptr) return;
    postorder(root->left);         // Рекурсия влево
    postorder(root->right);        // Рекурсия вправо
    cout << root->val << " ";      // Обрабатываем корень
}

int main() {
    // Создаём дерево:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);

    cout << "Preorder: ";   preorder(root);   cout << endl;
    cout << "Inorder: ";    inorder(root);    cout << endl;
    cout << "Postorder: ";  postorder(root); cout << endl;

    // Очистка памяти (опущено для краткости)
    return 0;
}
