package com.company.design.decorator;

public class AudiA3 extends AudiDecorator {
    public AudiA3(ICar audi, String modelName) {
        super(audi, modelName, 1000);
    }
}
