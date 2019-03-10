package com.github.marlonflorencio.java8.collections.list;

import com.github.marlonflorencio.java8.beans.Nota1;
import com.github.marlonflorencio.java8.beans.Nota2;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListTest {

    /**
     *  Caracteristicas
     *
     *  Possibilidade de acesso aleatorio
     *  Aceita ordenação
     *  Pode remover e adicionar itens em qualquer posição
     *  Aceita repetições
     *  Aceita elementos nulos
     *  Não é thread-safe
     *
     */

    @Test
    public void testInclusao(){

        List<Nota1> list = new ArrayList<>();

        list.add(new Nota1(1));
        list.add(new Nota1(1));
        list.add(null);
        list.add(new Nota1(2));

        Assert.assertEquals(4, list.size());

        list.forEach(System.out::println);
    }

    @Test
    public void testOrdenacao(){

        List<Nota1> list = new ArrayList<>();
        list.add(new Nota1(2));
        list.add(new Nota1(3));
        list.add(new Nota1(1));

        list.sort(Comparator.comparingInt(Nota1::getId));

        Assert.assertEquals(1, list.get(0).getId());
    }

    @Test
    public void testExclusao(){

        List<Nota1> list = new ArrayList<>();
        list.add(new Nota1(1));
        list.add(new Nota1(2));
        list.add(new Nota1(3));

        list.remove(1);

        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals(3, list.get(1).getId());
    }

    @Test
    public void testInclusaoAleatoria(){

        List<Nota1> list = new ArrayList<>();
        list.add(new Nota1(1));
        list.add(new Nota1(3));

        list.add(1, new Nota1(2));

        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals(2, list.get(1).getId());
        Assert.assertEquals(3, list.get(2).getId());
    }

    @Test
    public void testExclusaoPorObjeto(){

        List<Nota1> list = new ArrayList<>();
        list.add(new Nota1(1));
        list.add(new Nota1(2));
        list.add(new Nota1(2));
        list.add(new Nota1(3));

        list.remove(new Nota1(2));

        Assert.assertEquals(3, list.size());

        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals(2, list.get(1).getId());
        Assert.assertEquals(3, list.get(2).getId());

    }

    @Test
    public void testExclusaoPorObjeto2(){

        List<Nota1> list = new ArrayList<>();
        list.add(new Nota1(1));
        list.add(new Nota1(2));
        list.add(new Nota1(2));
        list.add(new Nota1(3));

        Nota1 nota = new Nota1(2);
        list.removeIf(nota::equals);

        Assert.assertEquals(2, list.size());

        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals(3, list.get(1).getId());
    }

    @Test
    public void testExclusaoPorObjeto3(){

        List<Nota2> list = new ArrayList<>();
        list.add(new Nota2(1));
        list.add(new Nota2(2));
        list.add(new Nota2(2));
        list.add(new Nota2(3));

        list.remove(new Nota2(2));

        Assert.assertEquals(4, list.size());

        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals(2, list.get(1).getId());
        Assert.assertEquals(2, list.get(2).getId());
        Assert.assertEquals(3, list.get(3).getId());
    }

}
