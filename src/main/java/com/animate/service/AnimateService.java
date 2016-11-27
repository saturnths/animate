package com.animate.service;

import java.util.ArrayList;
import java.util.List;
import com.animate.domain.Particle;
import org.apache.commons.lang3.StringUtils;

public class AnimateService {

    /**
     * The animate method simulates movement and location of particles in a linear chamber.
     *
     * @param speed Number of positions particles move in 1 unit of time.
     * @param init Initial conditions.
     * @return An array of strings showing occupied locations for each unit of time.
     * @exception IllegalArgumentException if the speed parameter is <= 0.
     * @exception IllegalArgumentException if the init parameter is empty.
     */
    public List<String> animate(int speed, String init) {
        List<Particle> particles = new ArrayList<>();
        List<String> results = new ArrayList<>();
        String allDotsString = getStringWithAllDots(init.length());
        boolean atLeastOneParticleInRange;

        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be a non-negative, non-zero integer");
        }

        if (init.length() == 0) {
            throw new IllegalArgumentException("Init must be not empty");
        }

        // Scan the string to generate the first result.

        StringBuilder firstPass = new StringBuilder(init);

        for (int i=0; i<init.length(); i++) {
            char c = init.charAt(i);

            // Check for occupied locations to mark them, and populate the particles array.
            if (c == 'L' || c == 'R') {
                firstPass.setCharAt(i, 'X');

                int step = speed;
                if (c == 'L') { step = -1 * speed; }
                particles.add(new Particle(step, i));
            }
        }

        results.add(firstPass.toString());

        // For each time step, animate particles and place Xs in the string that's initially filled with dots.

        if (particles.size() > 0) {
            StringBuilder curTimeStep;

            do {
                curTimeStep = new StringBuilder(allDotsString);
                atLeastOneParticleInRange = false;

                for (Particle particle : particles) {
                    int location = particle.move();

                    if (0 <= location && location < init.length()) {
                        atLeastOneParticleInRange = true;
                        curTimeStep.setCharAt(particle.getIndex(), 'X');
                    }
                }

                results.add(curTimeStep.toString());

            } while (atLeastOneParticleInRange);
        }

        return results;
    }

    // Generates a new 'blank' string populated with dots.
    private String getStringWithAllDots(int len) {
        return StringUtils.repeat('.', len);
    }

    public static void main(String[] args) {
        AnimateService service = new AnimateService();
        String init = "R....L";
        List<String> result = service.animate(1, init);

        System.out.println("Input: speed=1, init=\"" + init + "\"");
        System.out.println("Output: " + result);
    }

}
