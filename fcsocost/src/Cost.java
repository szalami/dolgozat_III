/*
 * Sallai András, 2024-02-19
 * Copyright (c) 2024, Sallai András
 * Licenc: MIT
 * Refaktorálás: Faragó Csaba, 2024-02-25
 */

public class Cost {
    Double transport;
    Double business;
    Double repair;

    public Cost(Double transport, Double business, Double repair) {
        this.transport = transport;
        this.business = business;
        this.repair = repair;
    }

    public Cost() {

    }

}
