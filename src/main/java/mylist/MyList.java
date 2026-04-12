package mylist;

public class MyList {
    private int[] data;
    private int size;     // сколько чисел находится

    public MyList() {
        data = new int[10];
        size = 0;
    }

    public MyList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }//констуктор доступен всем и одно целое число - емкость (сколько всего мест в массиве
        data = new int[capacity];
        size = 0;
    }

    public MyList(int[] array) {
        if (array == null) {
            data = new int[10];
            size = 0;
        } else {
            data = new int[array.length];
            System.arraycopy(array, 0, data, 0, array.length);
            size = array.length;
        }
    }

    private void grow() {
        int newCapacity = data.length * 2;
        if (newCapacity == 0) {
            newCapacity = 10;
        }
        int[] newData = new int[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }


    public void add(int value) {
        if (size == data.length) {
            grow();
        }
        data[size] = value;  //кладем в свободную ячейку
        size++;              //увеличиваем счётчик
    }

public void add(int index, int value) {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException(index + size);
    }
    if (size == data.length) {
        grow();
    }
    System.arraycopy(data, index, data, index + 1, size - index);
    data[index] = value;
    size++;
}

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", размер: " + size);
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index  + size);
        }
        data[index] = value;
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + size);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }


    public int removeLast() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("Список пуст");
        }
        size--;
        return data[size];  // возвращаем последний, но не стираем из памяти (не нужно)
    }
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;  // если indexOf вернул не -1 → есть
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

public int[] toArray() {
    int[] result = new int[size];
    System.arraycopy(data, 0, result, 0, size);
    return result;
}


    public void clear() {
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MyList)) return false;

        MyList other = (MyList) o;

        if (this.size != other.size) return false;

        for (int i = 0; i < size; i++) {
            if (this.data[i] != other.data[i]) {
                return false;  // нашли разное → не равны
            }
        }
        return true;  // все элементы совпали
    }

    @Override //с хэш кодами все равно не очень поняла
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = 31 * result + data[i];
        }
        return result;
    }
}