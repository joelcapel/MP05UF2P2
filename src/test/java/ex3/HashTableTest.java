package ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void count() {
        ex2.HashTable hashTable = new ex2.HashTable();
        hashTable.put("1","uno");
        hashTable.put("2", "dos");
        hashTable.put("3", "tres");
        hashTable.put("4", "cuatro");
        hashTable.put("1", "cinco");
        hashTable.put("6", "seis");

        System.out.println("COUNT PUT TOTAL: " + hashTable.count());
        hashTable.toString();
        Assertions.assertEquals(6,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());

        ex2.HashTable hashTable1 = new ex2.HashTable();

        hashTable1.put("1", "uno");
        hashTable1.put("2", "dos");
        hashTable1.put("3", "tres");
        hashTable1.put("4", "cuatro");
        System.out.println("COUNT DROP TOTAL: "+ hashTable1.count());

        hashTable1.drop("1");
        System.out.println("COUNT DROP: "+ hashTable1.count() + " nodo 1 eliminado");
        hashTable1.drop("2");
        System.out.println("COUNT DROP: "+ hashTable1.count() + " nodo 2 eliminado");
        hashTable1.drop("3");
        System.out.println("COUNT DROP: "+ hashTable1.count() + " nodo 3 eliminado");
        hashTable1.drop("4");
        System.out.println("COUNT DROP: "+ hashTable1.count() + " nodo 4 eliminado");

        hashTable.toString();
        Assertions.assertEquals(0,hashTable1.count());
        Assertions.assertEquals(16,hashTable1.size());
        Assertions.assertEquals("\n bucket[2] = [1, uno] -> [3, tres] -> [4, cuatro]" +
                "\n bucket[3] = [2, dos]", hashTable1.toString());
    }

    @Test
    void size() {
        ex2.HashTable hashTable = new ex2.HashTable();
        hashTable.put("1","uno");
        hashTable.put("2", "dos");
        hashTable.put("3", "tres");
        hashTable.put("4", "cuatro");
        hashTable.put("1", "cinco");
        hashTable.put("6", "seis");

        System.out.println("SIZE PUT TOTAL: " + hashTable.size());
        hashTable.toString();
        Assertions.assertEquals(6,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());

        ex2.HashTable hashTable1 = new ex2.HashTable();

        hashTable1.put("1", "uno");
        hashTable1.put("2", "dos");
        hashTable1.put("3", "tres");
        hashTable1.put("4", "cuatro");

        hashTable1.drop("1");
        hashTable1.drop("2");
        hashTable1.drop("3");
        hashTable1.drop("4");

        System.out.println("SIZE DROP TOTAL: " + hashTable1.size());
        hashTable.toString();
        Assertions.assertEquals(0,hashTable1.count());
        Assertions.assertEquals(16,hashTable1.size());
        Assertions.assertEquals("\n bucket[2] = [1, uno] -> [3, tres] -> [4, cuatro]" +
                "\n bucket[3] = [2, dos]", hashTable1.toString());
    }

    @Test
    void put() {
        ex2.HashTable hashTable = new ex2.HashTable();
        hashTable.put("1","uno");
        hashTable.put("3", "tres");
        hashTable.put("4", "cuatro");
        hashTable.put("6", "seis");

        hashTable.put("12", "doce");
        hashTable.put("23", "ventitres");
        hashTable.put("1", "cinco");


        hashTable.toString();
        Assertions.assertEquals(7,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());
        Assertions.assertEquals("\n bucket[2] = [1, uno] -> [3, tres] -> [4, cuatro]" +
                "\n bucket[3] = [2, dos]", hashTable.toString());
    }

    @Test
    void get() {
        ex2.HashTable hashTable = new ex2.HashTable();
        hashTable.put("1", "uno");
        hashTable.put("2", "dos");
        hashTable.put("3", "tres");
        hashTable.put("4", "cuatro");

        String noColosion = hashTable.get("2");
        String ColosionInicio = hashTable.get("1");
        String ColosionMedio = hashTable.get("3");
        String ColosionFinal = hashTable.get("4");
        String noExist = hashTable.get("put3");

        Assertions.assertEquals("2", noColosion);
        Assertions.assertEquals("uno", ColosionInicio);
        Assertions.assertEquals("tres", ColosionMedio);
        Assertions.assertEquals("cuatro", ColosionFinal);
        Assertions.assertEquals(null, noExist);
    }

    @Test
    void drop() {
        ex2.HashTable hashTable = new ex2.HashTable();

        hashTable.put("1", "uno");
        hashTable.put("2", "dos");
        hashTable.put("3", "tres");
        hashTable.put("4", "cuatro");

        hashTable.drop("1");
        hashTable.drop("2");
        hashTable.drop("3");
        hashTable.drop("4");

        hashTable.toString();
        Assertions.assertEquals(0,hashTable.count());
        Assertions.assertEquals(16,hashTable.size());
        Assertions.assertEquals("\n bucket[2] = [1, uno] -> [3, tres] -> [4, cuatro]" +
                "\n bucket[3] = [2, dos]", hashTable.toString());

    }
}