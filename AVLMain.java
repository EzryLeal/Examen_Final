import java.util.Scanner;

// Clase que representa un nodo en el árbol AVL
class Node {
    int value; //valor del nodo
    int height; //La altura de nodo (nos permite un balance)
    Node left, right; //referencia a los hijos izquierda y derecha.

    // Constructor del nodo con valor inicial
    Node(int value) {
        this.value = value;
        this.height = 1; // La altura inicial de un nodo recién creado es 1
    }
}

// Clase que representa el árbol AVL con sus operaciones
class AVLTree {
    Node root; // Nodo raíz del árbol

    // Método para obtener la altura de un nodo
    int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Método para obtener el factor de balance de un nodo
    int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Rotación a la derecha para mantener el balance del árbol
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Realizar rotación
        x.right = y;
        y.left = T2;

        // Actualizar alturas
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Rotación a la izquierda para mantener el balance del árbol
    Node rotateLeft(Node x) {
        Node y = x.right; //toma al hijo de la izquierda
        Node T2 = y.left; // guardar el sub arbol derecho de x

        // Realizar rotación
        y.left = x; //se mueve hacia la derecha
        x.right = T2; //se adigna el subarbol de y a x

        // Actualizar alturas
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // y esta se convierte en la nueva raiz
    }

    // Método para insertar un nuevo valor en el árbol AVL
    Node insert(Node node, int value) {
        if (node == null) return new Node(value); // Si el nodo es nulo, crear uno nuevo

        // Insertar el valor en la posición adecuada del BST
        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node; // Valor duplicado, no se inserta

        // Actualizar la altura del nodo actual
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // Obtener el factor de balance del nodo
        int balance = getBalanceFactor(node);

        // Aplicar rotaciones si el árbol se desbalancea
        if (balance > 1 && value < node.left.value) return rotateRight(node);
        if (balance < -1 && value > node.right.value) return rotateLeft(node);
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Retornar el nodo modificado
    }

    // Encuentra el nodo con el valor mínimo en un subárbol
    Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Método para eliminar un nodo del árbol AVL
    Node delete(Node node, int value) {
        if (node == null) return null;

        // Buscar el nodo a eliminar
        if (value < node.value)
            node.left = delete(node.left, value);
        else if (value > node.value)
            node.right = delete(node.right, value);
        else {
            // Caso de un solo hijo o ningún hijo
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                // Caso de dos hijos: encontrar el sucesor en orden
                Node temp = findMin(node.right);
                node.value = temp.value;
                node.right = delete(node.right, temp.value);
            }
        }

        if (node == null) return node;

        // Actualizar altura del nodo actual
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // Obtener el factor de balance
        int balance = getBalanceFactor(node);

        // Aplicar rotaciones para mantener el balance
        if (balance > 1 && getBalanceFactor(node.left) >= 0) return rotateRight(node);
        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalanceFactor(node.right) <= 0) return rotateLeft(node);
        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Imprimir el árbol AVL en consola de forma jerárquica
    void printTree(Node root, String indent, boolean isLeft) {
        if (root != null) {
            printTree(root.right, indent + (isLeft ? "│   " : "    "), false);
            System.out.println(indent + (isLeft ? "└── " : "┌── ") + root.value);
            printTree(root.left, indent + (isLeft ? "│   " : "    "), true);
        }
    }

    // Insertar un nuevo nodo e imprimir el árbol
    void insert(int value) {
        root = insert(root, value);
        printTree(root, "", true);
    }

    // Mostrar el árbol completo
    void presentTree() {
        System.out.println("\nÁrbol AVL completo:");
        printTree(root, "", true);
    }

    // Eliminar un nodo ingresado por error
    void deleteNode(int value) {
        root = delete(root, value);
        System.out.println("\nNodo eliminado.");
        printTree(root, "", true);
    }

    // Reiniciar el árbol desde cero
    void resetTree() {
        root = null;
        System.out.println("\nEl árbol ha sido reiniciado.");
    }
}

// Clase principal que maneja la interacción del usuario
public class AVLMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros para construir el árbol AVL.");
        System.out.println("Opciones:");
        System.out.println("'exit' o '-1' para salir.");
        System.out.println("'presentacion' para visualizar el árbol completo.");
        System.out.println("'nuevo' para reiniciar el árbol.");
        System.out.println("'eliminar' para borrar un nodo.");
        System.out.println("'continuar' para seguir editando.");

        // Bucle de interacción con el usuario
        while (true) {
            System.out.print("> ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit") || input.equals("-1")) break;
            else if (input.equalsIgnoreCase("presentacion")) tree.presentTree();
            else if (input.equalsIgnoreCase("nuevo")) tree.resetTree();
            else if (input.equalsIgnoreCase("eliminar")) {
                System.out.print("Ingrese el número a eliminar: ");
                int value = scanner.nextInt();
                tree.deleteNode(value);
            }
            else if (input.equalsIgnoreCase("continuar")) {
                System.out.println("Continuando con el árbol actual...");
            }
            else {
                try {
                    int value = Integer.parseInt(input);
                    tree.insert(value);
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }
        }
        scanner.close();
        System.out.println("¡Gracias por usar el programa!");
    }
}