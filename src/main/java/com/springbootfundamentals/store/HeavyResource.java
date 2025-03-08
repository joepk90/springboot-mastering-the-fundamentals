package com.springbootfundamentals.store;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Bean Initialisation
 * 
 * - Early / Eager
 * 
 * - Lazy:
 *  - An optimization technique
 *  - Create objects when needed
 */

@Component
@Lazy
public class HeavyResource {
    public HeavyResource() {
        System.out.println("HeavyResource created (early/eager initialisation)");
    }
}
