package com.company.design.decorator;

public class AudiA5 extends AudiDecorator {
    public AudiA5(ICar audi, String modelName) {
        super(audi, modelName, 3000);
    }
}
