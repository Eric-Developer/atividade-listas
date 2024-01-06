package exercicio1;

public class Lista {

    private int[] array;
    private int size;

    public Lista(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public void add(int value) {
        if (size < array.length) {
            array[size++] = value;
        } else {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size++] = value;
        }
    }

    public void concat(Lista otherList) {
        int newSize = this.size + otherList.size;
        int[] newArray = new int[newSize];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        System.arraycopy(otherList.array, 0, newArray, this.size, otherList.size);
        this.array = newArray;
        this.size = newSize;
    }

    public void divide(Lista firstList, Lista secondList, int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        
        firstList.array = new int[index];
        System.arraycopy(this.array, 0, firstList.array, 0, index);
        firstList.size = index;

        int secondListSize = this.size - index;
        secondList.array = new int[secondListSize];
        System.arraycopy(this.array, index, secondList.array, 0, secondListSize);
        secondList.size = secondListSize;
    }

    public Lista copy() {
        Lista newList = new Lista(this.size);
        System.arraycopy(this.array, 0, newList.array, 0, this.size);
        newList.size = this.size;
        return newList;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lista lista1 = new Lista(5);
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);

        Lista lista2 = new Lista(5);
        lista2.add(4);
        lista2.add(5);

        lista1.concat(lista2);
        System.out.println("Lista após a concatenação:");
        lista1.print();

        
        Lista firstList = new Lista(5);
        Lista secondList = new Lista(5);
        lista1.divide(firstList, secondList, 3);
        System.out.println("Primeira lista após a divisão:");
        firstList.print();
        System.out.println("Segunda lista após a divisão:");
        secondList.print();

        Lista copiedList = lista1.copy();
        System.out.println("Cópia da lista original:");
        copiedList.print();

        int elementToSearch = 5;
        System.out.println("A lista contém o elemento " + elementToSearch + "? " + lista1.contains(elementToSearch));
    }
}
