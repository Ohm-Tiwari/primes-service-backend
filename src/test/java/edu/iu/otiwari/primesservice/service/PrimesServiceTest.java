package edu.iu.otiwari.primesservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService p = new PrimesService();

    @Test
    void _45isNotPrime() {
        int n = 45;
        boolean expected = false;
        boolean actual = p.isPrime(n);

        assertEquals(expected, actual);
    }

    @Test
    void _539828945930573IsNotPrime(){
        long n = 539828945930573L;
        boolean expected = false;
        boolean actual = p.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void _285191IsNotPrime(){
        long n = 285191L;
        boolean expected = true;
        boolean actual = p.isPrime(n);
        assertEquals(expected, actual);
    }
}