package wildcards_3_76;

public class Packer {

    /*
     Any kind of Bakery could be repacked to the Box with more basic type (e.g. from box with Pie to box with Food)

     Basic stuff like food can't be repacked into narrowly typed Box'es (e.g. with Cakes)

     Arbitrary stuff like Strings or Objects can't be repacked without compile-time errors or warnings

     Repacking actually happens
     */
    public <T extends Food> void repackage(Box<? super T> to, Box<? extends T> from) {
        T elem = from.get();
        to.put(elem);
    }
}

class Food {
}

class Bakery extends Food {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}

interface Box<T> {

    void put(T item);

    T get();
}

class BoxImpl<T> implements Box<T> {

    private T elem;

    @Override
    public void put(T item) {
        elem = item;
    }

    @Override
    public T get() {
        return elem;
    }
}
