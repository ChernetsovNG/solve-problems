package wildcards_3_76;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PackerTest {

    @Test
    public void test1() {
        // Any kind of Bakery could be repacked to the Box with more basic type (e.g. from box with Pie to box with Food)
        Box<Pie> from = new BoxImpl<>();
        from.put(new Pie());

        Box<Food> to = new BoxImpl<>();

        Packer packer = new Packer();
        packer.repackage(to, from);

        assertThat(to.get()).isInstanceOf(Pie.class);
    }

    @Test
    public void test2() {
        // Any kind of Bakery could be repacked to the Box with more basic type (e.g. from box with Pie to box with Bakery)
        Box<Pie> from = new BoxImpl<>();
        from.put(new Pie());

        Box<Bakery> to = new BoxImpl<>();

        Packer packer = new Packer();
        packer.repackage(to, from);

        assertThat(to.get()).isInstanceOf(Pie.class);
    }

    @Test
    public void test3() {
        // Basic stuff like food can't be repacked into narrowly typed Box'es (e.g. with Cakes)
        Box<Food> from = new BoxImpl<>();
        from.put(new Food());

        Box<Cake> to = new BoxImpl<>();

        Packer packer = new Packer();
        // packer.repackage(to, from); can't
    }

    @Test
    public void test4() {
        // Arbitrary stuff like Strings or Objects can't be repacked without compile-time errors or warnings
        Box<String> from = new BoxImpl<>();
        Box<Cake> to = new BoxImpl<>();

        Packer packer = new Packer();
        // packer.repackage(to, from); can't
    }
}
