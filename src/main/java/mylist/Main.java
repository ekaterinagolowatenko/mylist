package mylist;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(1, 15);

        System.out.print("Список");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        list.set(0, 5);

        list.remove(3);

        int last = list.removeLast();
        int[] arr = list.toArray();
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        list.clear();
        System.out.println(list.size());

        MyList list2 = new MyList();
        list2.add(1);
        list2.add(2);

        MyList list3 = new MyList();
        list3.add(1);
        list3.add(2);

        int[] source = {100, 200, 300};
        MyList list4 = new MyList(source);
        System.out.println(list4.get(1));

        MyList list5 = new MyList(5);
        System.out.println(list5.size());

        MyList list6 = new MyList(null);
        System.out.println(list6.size());
    }
}