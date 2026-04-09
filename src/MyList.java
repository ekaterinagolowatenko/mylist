public class MyList {
    private int[] data;
    private int size;     // сколько чисел находится

    public MyList() {
        data = new int[10];
        size = 0;
    }

    public MyList(int capacity){  //констуктор доступен всем и одно целое число - емкость (сколько всего мест в массиве
        data = new int[capacity];
        size = 0;
    }

    public MyList(int[] array) {
        if (array == null) { //null ведет себя как констуктор по умолч.
            data = new int[10]; //имя приватного поля (внутренний массив)
            size = 0;
        } else {         //кпируем все числа из переданного массива в наш
            data = new int[array.length];
            for (int i = 0; i < array.length; i++) { // пока i меньше длины массива и увеличь iна один
                data[i] = array[i];
            }
            size = array.length;
        }
    }

    private void grow() { //метод расширяет массив и ничего не возвращает
        int newCapacity = data.length * 2;
        int[] newData = new int[newCapacity]; //пекременная с новой вместимостью
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        } //кирилл максимович, если вы это читаете, то ответье пж, если не сложно: вот мы увеличили массив в 2 раза, соотвественно он сначала заполнился нулями --> мы добавили наши данные до n индекса, но оставшияся длинна все еще заполнена нулями, которые занимают памяьь, нужно ли как-то обрезать этот хвост?
        data = newData; //garbage collector удаляет методы на которые большеникто не ссылается
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
            throw new IndexOutOfBoundsException(index  + size);
        }

        if (size == data.length) {
            grow();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

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
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
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
        int[] result = new int[size];  //массив ТОЧНО под размер
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
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