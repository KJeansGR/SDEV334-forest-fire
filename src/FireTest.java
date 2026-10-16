import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void test_starting_point_is_not_tree() {
        char[][] forest = {
            {'.','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void test_1_tree() {
        char[][] forest = {
            {'t'},
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void test_1_column() {
        char[][] forest = {
            {'t'},
            {'t'},
            {'t'},
            {'t'},
            {'t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 4;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
    @Test
    public void test_1_row() {
        char[][] forest = {
            {'t','t','t','t'},
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 3;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
    @Test
    public void test_strange_shape_graph() {
        char[][] forest = {
            {'t'},{'t'},{'t'},{'t'},
            {'t'},{'t'},
            {'t'},{'t'},{'t'},
            {'t'},
            {'t'},{'t'},{'t'},
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 12;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
    @Test
    public void test_All_Empty() {
        char[][] forest = {
            {'.'},{'.'},{'.'},
            {'.'},{'.'},{'.'},
            {'.'},{'.'},{'.'},
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
}
