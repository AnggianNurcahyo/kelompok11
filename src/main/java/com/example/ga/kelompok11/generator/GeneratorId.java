package com.example.ga.kelompok11.generator;

public class GeneratorId {
    public static String generateMasterId(int lastCounter) {
        return String.format("%05d", lastCounter + 1);
    }
}
