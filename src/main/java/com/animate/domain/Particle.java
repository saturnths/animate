package com.animate.domain;

public class Particle {
        // negative for leftward direction, positive for rightward direction
        private final int step;

        // index to the string that represents the particle's location in the chamber
        private int index;

        public Particle(int step, int index) {
            this.step = step;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public int move() {
            this.index += step;
            return this.index;
        }
    }